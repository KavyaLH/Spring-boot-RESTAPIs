package com.example.demo.Dto;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="employeeapptable")
public class EmployeeDto {
	
@Id	
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "eid")
private int eid;

@Column(name = "name")
private String name;

@Column(name = "email")
private String email;

@Column(name = "contact")
private String contact;

@Column(name = "dob")
private String dob;

@Column(name = "gender")
private String gender;

@Column(name = "password")
private String password;

@Transient
private String conpassword;


}