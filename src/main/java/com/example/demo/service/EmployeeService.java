package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Dto.EmpAddressDto;
import com.example.demo.Entity.EmployeeAddress;
import com.example.demo.Entity.EmployeeDto;


public interface EmployeeService {
	public List<EmployeeDto> getEmpl();
	public EmployeeDto saveEmpl(EmployeeDto dto);
	public String deleteEmpl(EmployeeDto dto);
	public EmployeeDto updateEmpl(EmployeeDto dto);
	public List<EmployeeDto> findbyName( EmployeeDto dto);
	public Optional<EmployeeDto> findbyId(EmployeeDto dto);
	public String ValidateNSave(EmpAddressDto dto);
	public String updateNameByEmail(String name,String email);
	public String updateSalaryByEmail(int salary,String email);
	public String updateNameSalaryByEmail(String name,int salary,String email);
	public List<EmployeeDto> getAllByNameOrCityOrEmail(String name, String city, String email);
	public List<EmployeeDto> getAllByNameOrCityOrEmailOrZipcode(String name, String city, String email, String zipcode);
	public int saveAllEmpl(List<EmployeeDto> dto);
	public List<EmployeeDto> getAllByCity(String city);
	public String updateZipcodebByCity(String zipcode,String city);
}
