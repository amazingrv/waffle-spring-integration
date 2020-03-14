package com.demo.springwaffle.mapper;

import com.demo.springwaffle.dto.PersonDTO;
import com.demo.springwaffle.entity.PersonEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PersonMapperImpl.class)
public class PersonMapperTest {
    @Autowired
    private PersonMapper mapper;

    private PersonEntity initialEntity;
    private PersonDTO initialDTO;
    private PersonDTO expectedDTO;
    private PersonEntity expectedEntity;

    @Before
    public void setup() {
        initialEntity = new PersonEntity("123", "ABC");
        expectedDTO = new PersonDTO("123", "ABC");

        initialDTO = new PersonDTO("234", "XYZ");
        expectedEntity = new PersonEntity("234", "XYZ");
    }

    @Test
    public void shouldReturnDTOWhenProvidedEntity() {
        PersonDTO actualDTO = mapper.toPersonDTO(initialEntity);
        assertThat(actualDTO).isNotNull();
        assertThat(actualDTO).isEqualTo(expectedDTO);
    }

    @Test
    public void shouldReturnEntityWhenProvidedDTO() {
        PersonEntity actualEntity = mapper.toPersonEntity(initialDTO);
        assertThat(actualEntity).isNotNull();
        assertThat(actualEntity).isEqualTo(expectedEntity);
    }
}
