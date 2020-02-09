package com.demo.springwaffle.mapper;

import com.demo.springwaffle.dto.PersonDTO;
import com.demo.springwaffle.entity.PersonEntity;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class PersonMapper {

    public PersonDTO toPersonDTO(PersonEntity person) {
        PersonDTO dto = new PersonDTO();
        dto.setUid(person.getUid());
        dto.setFirstName(person.getFirstName());
        return dto;
    }

    public PersonEntity toPersonEntity(PersonDTO dto) {
        PersonEntity entity = new PersonEntity();
        entity.setUid(dto.getUid());
        entity.setFirstName(dto.getFirstName());
        return entity;
    }
}
