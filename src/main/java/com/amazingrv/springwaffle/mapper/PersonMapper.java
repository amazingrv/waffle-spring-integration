package com.amazingrv.springwaffle.mapper;

import com.amazingrv.springwaffle.dto.PersonDTO;
import com.amazingrv.springwaffle.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mappings({
            @Mapping(target = "uid", source = "person.uid"),
            @Mapping(target = "firstName", source = "person.firstName")
    })
    public PersonDTO toPersonDTO(PersonEntity person);

    @Mappings({
            @Mapping(target = "uid", source = "dto.uid"),
            @Mapping(target = "firstName", source = "dto.firstName")
    })
    public PersonEntity toPersonEntity(PersonDTO dto);
}
