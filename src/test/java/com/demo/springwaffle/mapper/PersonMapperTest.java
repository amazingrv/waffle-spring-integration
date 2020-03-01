package com.demo.springwaffle.mapper;

import com.demo.springwaffle.dto.PersonDTO;
import com.demo.springwaffle.entity.PersonEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class PersonMapperTest {

    private PersonMapper mapper;

    private PersonEntity initialEntity;
    private PersonDTO initialDTO;
    private PersonDTO expectedDTO;
    private PersonEntity expectedEntity;

    @Before
    public void setup() {
        mapper = new PersonMapper();
        initialEntity = new PersonEntity("123", "ABC");
        expectedDTO = new PersonDTO("123", "ABC");

        initialDTO = new PersonDTO("234", "XYZ");
        expectedEntity = new PersonEntity("234", "XYZ");
    }

    @Test
    public void shouldReturnDTOWhenProvidedEntity(){
        PersonDTO actualDTO = mapper.toPersonDTO(initialEntity);
        assertThat(actualDTO).isEqualTo(expectedDTO);
    }

    @Test
    public void shouldReturnEntityWhenProvidedDTO(){
        PersonEntity actualEntity = mapper.toPersonEntity(initialDTO);
        assertThat(actualEntity).isEqualTo(expectedEntity);
    }
}
