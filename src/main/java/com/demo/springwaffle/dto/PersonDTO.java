package com.demo.springwaffle.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PersonDTO {
    @NotBlank(message = "Id is mandatory")
    private String uid;

    @NotBlank(message = "Name is mandatory")
    private String firstName;
}
