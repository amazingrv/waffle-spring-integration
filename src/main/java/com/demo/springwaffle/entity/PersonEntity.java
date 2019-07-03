package com.demo.springwaffle.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PersonEntity {
	@Id
	private String empCode;
	private String firstName;
}
