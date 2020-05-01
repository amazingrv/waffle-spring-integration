package com.demo.springwaffle;

import com.demo.springwaffle.dto.PersonDTO;
import com.demo.springwaffle.entity.PersonEntity;
import com.demo.springwaffle.mapper.PersonMapper;
import com.demo.springwaffle.mapper.PersonMapperImpl;
import com.demo.springwaffle.repo.PersonRepository;
import com.demo.springwaffle.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {PersonService.class, PersonMapperImpl.class})
public class PersonServiceTest {
    @MockBean
    private PersonRepository repository;

    @Autowired
    private PersonMapper mapper;

    @Autowired
    private PersonService service;

    @Test
    public void shouldReturnDTOWhenFoundInDB() {
		PersonEntity entity = new PersonEntity("123", "ABC");
		when(repository.findById(anyString())).thenReturn(Optional.of(entity));
        PersonDTO result = service.getPerson("123");
        assertThat(result).isNotNull();
        verify(repository).findById("123");
    }

}
