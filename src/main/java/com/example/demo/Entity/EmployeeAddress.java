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
@Table(name= "empaddress")
public class EmployeeAddress {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int aid;
private String city;
private String district;
private String state;
private String zipcode;

@OneToOne
@JsonIgnoreProperties("addr")
@JoinColumn(name = "aid")
private EmployeeDto employeedto;
}
