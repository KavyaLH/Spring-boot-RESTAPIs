package com.example.demo.service;

import java.util.List;

import com.example.demo.Dto.EmployeeDto;

public interface EmployeeService {
	public List<EmployeeDto> getEmpl();

	public EmployeeDto saveEmpl(EmployeeDto dto);

	public String deleteEmpl(EmployeeDto dto);

	public EmployeeDto updateEmpl(EmployeeDto dto);
	public String updateEmpByEmail(String name,String contact,String dob,String gender,String email);
	
	public EmployeeDto findByEmailid(String email);
	public String findIdByNamePassword(String name, String password);
}
