package com.demo.springwaffle.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonListRespVO extends BaseStatusVO {
	private List<PersonVO> personList;
}
