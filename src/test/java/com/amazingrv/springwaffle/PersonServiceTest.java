package com.amazingrv.springwaffle;

import com.amazingrv.springwaffle.dto.PersonDTO;
import com.amazingrv.springwaffle.entity.PersonEntity;
import com.amazingrv.springwaffle.mapper.PersonMapper;
import com.amazingrv.springwaffle.mapper.PersonMapperImpl;
import com.amazingrv.springwaffle.repo.PersonRepository;
import com.amazingrv.springwaffle.service.PersonService;
import com.amazingrv.springwaffle.service.impl.PersonServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author rjat3
 */
@SpringBootTest
@ContextConfiguration(classes = {PersonServiceImpl.class, PersonMapperImpl.class})
class PersonServiceTest {
    @MockBean
    private PersonRepository repository;

    @Autowired
    private PersonMapper mapper;

    @Autowired
    private PersonService service;

    @Test
    void shouldReturnDTOWhenFoundInDB() {
        PersonEntity entity = new PersonEntity("123", "ABC");
        when(repository.findById(anyString())).thenReturn(Optional.of(entity));
        PersonDTO result = service.getPerson("123");
        assertThat(result).isNotNull();
        verify(repository).findById("123");
    }

}
