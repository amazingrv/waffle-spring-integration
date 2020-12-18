package com.amazingrv.springwaffle.mapper;

import com.amazingrv.springwaffle.dto.PersonDTO;
import com.amazingrv.springwaffle.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for PersonDTO and PersonEntity
 *
 * @author rjat3
 */
@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "uid", source = "person.uid")
    @Mapping(target = "firstName", source = "person.firstName")
    PersonDTO toPersonDTO(PersonEntity person);

    @Mapping(target = "uid", source = "dto.uid")
    @Mapping(target = "firstName", source = "dto.firstName")
    PersonEntity toPersonEntity(PersonDTO dto);
}
