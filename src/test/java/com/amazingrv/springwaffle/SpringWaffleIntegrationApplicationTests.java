package com.amazingrv.springwaffle;

import com.amazingrv.springwaffle.entity.PersonEntity;
import com.amazingrv.springwaffle.repo.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author rjat3
 */
@SpringBootTest
@AutoConfigureMockMvc
class SpringWaffleIntegrationApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PersonRepository repository;

    @BeforeEach
    public void setup() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName("TestABC");
        personEntity.setUid("123");
        repository.save(personEntity);
    }

    @WithMockUser()
    @Test
    public void shouldReturnPersonAllUsers() throws Exception {
        this.mockMvc.perform(get("/api/person/all").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"persons\":[{\"uid\":\"123\",\"firstName\":\"TestABC\"}]}"));
    }

    @WithMockUser()
    @Test
    public void shouldReturnPersonFound() throws Exception {
        this.mockMvc.perform(get("/api/person/123").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"person\":{\"uid\":\"123\",\"firstName\":\"TestABC\"}}"));
    }

    @WithMockUser()
    @Test
    public void shouldReturnNotFound() throws Exception {
        this.mockMvc.perform(get("/api/person/9999").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
