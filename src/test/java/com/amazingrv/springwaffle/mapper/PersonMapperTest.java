package com.amazingrv.springwaffle.mapper;

import com.amazingrv.springwaffle.dto.PersonDTO;
import com.amazingrv.springwaffle.entity.PersonEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author rjat3
 */
@SpringBootTest(classes = PersonMapperImpl.class)
class PersonMapperTest {
    @Autowired
    private PersonMapper mapper;

    private static PersonEntity initialEntity;
    private static PersonDTO initialDTO;
    private static PersonDTO expectedDTO;
    private static PersonEntity expectedEntity;

    @BeforeAll
    static void setup() {
        initialEntity = new PersonEntity("123", "ABC");
        expectedDTO = new PersonDTO("123", "ABC");

        initialDTO = new PersonDTO("234", "XYZ");
        expectedEntity = new PersonEntity("234", "XYZ");
    }

    @Test
    void shouldReturnDTOWhenProvidedEntity() {
        PersonDTO actualDTO = mapper.toPersonDTO(initialEntity);
        assertThat(actualDTO).isNotNull().isEqualTo(expectedDTO);
    }

    @Test
    void shouldReturnEntityWhenProvidedDTO() {
        PersonEntity actualEntity = mapper.toPersonEntity(initialDTO);
        assertThat(actualEntity).isNotNull().isEqualTo(expectedEntity);
    }
}
