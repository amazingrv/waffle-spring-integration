package com.amazingrv.springwaffle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity class for Person in DB
 *
 * @author rjat3
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntity {
    @Id
    private String uid;
    private String firstName;
}
