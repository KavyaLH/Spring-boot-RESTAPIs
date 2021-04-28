package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="employeetable")
public class EmployeeDto {
	
@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)

private int eid;
private String ename;
private int esalary;
private String email;

@OneToOne
@JsonIgnoreProperties("employeedto")
private EmployeeAddress addr;
}
