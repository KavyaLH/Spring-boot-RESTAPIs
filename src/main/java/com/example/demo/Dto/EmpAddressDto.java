package com.example.demo.Dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class EmpAddressDto {
	private int eid;
	private String ename;
	private int esalary;
	private String email;
	private String city;
	private String zipcode;
}
