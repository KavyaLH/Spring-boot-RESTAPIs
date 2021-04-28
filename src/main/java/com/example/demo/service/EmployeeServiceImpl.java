package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.EmpAddressDto;
import com.example.demo.Entity.EmployeeAddress;
import com.example.demo.Entity.EmployeeDto;
import com.example.demo.repository.AddressRepo;
import com.example.demo.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService  {

	@Autowired
	EmployeeRepo repo;
	
	@Autowired
	AddressRepo arepo;
	
	private static final Logger logger=LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Override
	public List<EmployeeDto> getEmpl() {
		logger.info("Inside getEmpl: findAll() method");	
		return repo.findAll();
	}

	@Override
	public EmployeeDto saveEmpl(EmployeeDto dto) {

		logger.info("Inside saveEmpl: save() method");	
		EmployeeDto ed= repo.save(dto);
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
	public List<EmployeeDto> findbyName(EmployeeDto dto) {
		logger.info("Inside findbyName: findByEname() method" );	
		return (List<EmployeeDto>) repo.findByEname(dto.getEname());

	}

	@Override
	public Optional<EmployeeDto> findbyId(EmployeeDto dto) {
		logger.info("Inside findbyId: findByEid() method" );	
		return repo.findById(dto.getEid());
	}

	@Override
	public String ValidateNSave(EmpAddressDto dto) {
	 logger.info("Inside ValidateNSave: "+dto.getCity() );
		EmployeeAddress empadd = arepo.findBycity(dto.getCity());
		logger.info("Inside ValidateNSaveeee: "+empadd );
		
		if(empadd == null)
		{
			return "Address not found";
			
		}
		else
		{
			EmployeeDto dto1= new EmployeeDto();
			dto1.setEname(dto.getEname());
			dto1.setEsalary(dto.getEsalary());
			dto1.setEmail(dto.getEmail());
			dto1.setAddr(empadd);
			repo.save(dto1);
			return "Saved";
		}	
	}

	@Override
	public String updateNameByEmail(String ename, String email) {
		logger.info("Inside updateNameByEmail: ");
		int nameEmail = repo.updateNamebyEmail(ename, email);
		if (nameEmail == 1) { return "updated"; } else { return "Email ID not found";
		  }
	}

	@Override
	public String updateSalaryByEmail(int salary, String email) {
		logger.info("Inside updateSalaryByEmail:" );
		int salEmail = repo.updateSalarybyEmail(salary, email);
		
		  if (salEmail == 1) { return "updated"; } else { return "Email ID not found";
		  }
		 
	}

	@Override
	public String updateNameSalaryByEmail(String ename, int esalary, String email) {
		logger.info("Inside updateNameSalaryByEmail:" );
		int nameSalEmail = repo.updateNameSalarybyEmail(ename, esalary, email);
		
		  if (nameSalEmail == 1) { return "updated"; } else { return "Email ID not found";
		  }
	}

	@Override
	public List<EmployeeDto> getAllByNameOrCityOrEmail(String ename, String city, String email) {
		logger.info("Inside getAllByNameOrCityOrEmail:" +repo.getAllByNameOrCityOrEmail(ename, city, email));
		return repo.getAllByNameOrCityOrEmail(ename, city, email);
		
	}

	@Override
	public List<EmployeeDto> getAllByNameOrCityOrEmailOrZipcode(String ename, String city, String email,
			String zipcode) {
		
		return repo.getAllByNameOrCityOrEmailOrZipcode(ename, city, email, zipcode);
	}

	@Override
	public int saveAllEmpl(List<EmployeeDto> dto) {
		
	 repo.saveAll(dto);
	 return 1;
	}

	@Override
	public List<EmployeeDto> getAllByCity(String city) {
		
		return repo.getAllByCity(city);
	}

	@Override
	public String updateZipcodebByCity(String zipcode, String city) {
		
		int updatePin= arepo.updateZipByCity(zipcode, city);
		logger.info("updateZipcodebByCity "+updatePin);
		if(updatePin == 0)
		{
			return "City not found";
		}
		else
		{
			return "Data Saved";
		}
	}
		
}
