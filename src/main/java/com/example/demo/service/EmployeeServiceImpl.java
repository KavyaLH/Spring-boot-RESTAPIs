package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Dto.EmployeeDto;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo repo;

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public List<EmployeeDto> getEmpl() {
		logger.info("Inside getEmpl: findAll() method");
		return repo.findAll();

	}

	@Override
	public EmployeeDto saveEmpl(EmployeeDto dto) {

		logger.info("Inside saveEmpl: save() method");
		EmployeeDto ed = repo.save(dto);
		return ed;
	}

	@Override
	public String deleteEmpl(EmployeeDto dto) {
		logger.info("Inside deleteEmpl: delete() method");
		repo.delete(dto);
		return "deleted";
	}

	@Override
	public EmployeeDto updateEmpl(EmployeeDto dto) {
		logger.info("Inside updateEmp: save() method");
		return repo.save(dto);
	}

	@Override
	public String updateEmpByEmail(String name, String contact, String dob, String gender, String email) {
		logger.info("Inside updateNameByEmail: ");
		int nameEmail = repo.updateEmplbyEmail(name, contact, dob, gender, email);
		if (nameEmail == 1) { return "updated"; } else { return "Email ID not found";
		
		  }
	}

	@Override
	public EmployeeDto findByEmailid(String email) {
	
		logger.info("Inside findByEmailid: ");
		return repo.findByEmail(email);
	}

	@Override
	public String findIdByNamePassword(String name,String password) {
		logger.info("Inside findIdByNamePassword: ");
		List<EmployeeDto> data= repo.getByNameAndPassword(name, password);
		logger.info("Inside findIdByNamePassword: data = "+data);
		if(! (data.isEmpty() || data == null) )
		{
			return "ID found";			
		}
		else
		{
		return "ID not found";
		}
	}
	
}
