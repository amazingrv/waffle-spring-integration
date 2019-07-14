package com.demo.springwaffle.dto;

import java.util.List;

public class PersonListRespDTO extends BaseStatusDTO {
	private List<PersonDTO> personList;

	public List<PersonDTO> getPersonList() {
		return personList;
	}

	public void setPersonList(List<PersonDTO> personList) {
		this.personList = personList;
	}

}
