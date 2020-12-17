package com.amazingrv.springwaffle.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * DTO class for person
 *
 * @author rjat3
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PersonDTO {
    @NotBlank(message = "Id is mandatory")
    private String uid;

    @NotBlank(message = "Name is mandatory")
    private String firstName;
}
