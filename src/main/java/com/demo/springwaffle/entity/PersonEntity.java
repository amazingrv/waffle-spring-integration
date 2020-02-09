package com.demo.springwaffle.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class PersonEntity {
    @Id
    private String uid;
    private String firstName;
}
