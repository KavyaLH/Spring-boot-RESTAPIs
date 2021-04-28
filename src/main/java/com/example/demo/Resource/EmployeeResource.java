package com.example.demo.Resource;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.EmpAddressDto;
import com.example.demo.Entity.EmployeeAddress;
import com.example.demo.Entity.EmployeeDto;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.service.EmployeeService;



@RestController
@RequestMapping("/")
public class EmployeeResource {
	
	@Autowired
	EmployeeService service;
	 
	 private static final Logger logger=LoggerFactory.getLogger(EmployeeResource.class);
	 
	 @CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("get")
	public List<EmployeeDto> getEmp()
	{
		logger.info("Inside getEmp: findAll() method");	
		return service.getEmpl();
	}

	
	@PostMapping("save")
	public EmployeeDto saveEmp(@RequestBody EmployeeDto dto)
	{
		logger.info("Inside saveEmp: save() method");	
		EmployeeDto ed= service.saveEmpl(dto);
		return ed;
	}


	@DeleteMapping("/delete")
	public String deleteEmp(@RequestBody EmployeeDto dto)
	{
		logger.info("Inside deleteEmp: delete() method");	
		service.deleteEmpl(dto);
		return "deleted";
	}
	
	@PutMapping("/put")

	public EmployeeDto updateEmp(@RequestBody EmployeeDto dto)
	{
		logger.info("Inside updateEmp: save() method");	
		return service.updateEmpl(dto);
}
	
	@RequestMapping("/getbyname")
	public List<EmployeeDto> findbyname(@RequestBody EmployeeDto dto) {
		logger.info("Inside findbyname: findByEname() method" );	
		return (List<EmployeeDto>) service.findbyName(dto);

	}
	@RequestMapping("/getbyid")
	public Optional<EmployeeDto> findbyid(@RequestBody EmployeeDto dto) {
		logger.info("Inside findbyid: findByEid() method" );	
		return service.findbyId(dto);
}
	@PostMapping("/saveempl")
	public String saveData(@RequestBody EmpAddressDto dto1)
	{
		//logger.info("Inside saveDataaaaa: "+service.ValidateNSave(dto1) );
		service.ValidateNSave(dto1);
	return "Successfully saved";
	}
	
	@PutMapping("/updatenamebyemail")
	public String updateName(@RequestBody EmployeeDto dto)
	{
		logger.info("Inside updateName: "+service.updateNameByEmail(dto.getEname(), dto.getEmail()));
	return service.updateNameByEmail(dto.getEname(), dto.getEmail());
	
	}
	
	
	@PutMapping("/updatesalarybyemail")
	public String upadateSalary(@RequestBody EmployeeDto dto)
	{
	logger.info("Inside upadatesalary: "+service.updateSalaryByEmail(dto.getEsalary(), dto.getEmail()));
	return service.updateSalaryByEmail(dto.getEsalary(), dto.getEmail());
	
	}
	@PutMapping("/updatenamesalarybyemail")
	public String upadateNameSalary(@RequestBody EmployeeDto dto)
	{
	logger.info("Inside upadateNameSalary: "+service.updateNameSalaryByEmail(dto.getEname(), dto.getEsalary(), dto.getEmail()));
	return service.updateNameSalaryByEmail(dto.getEname(), dto.getEsalary(), dto.getEmail());
	
	}
	@GetMapping("/getnamecityemail")
	public List<EmployeeDto> getbyNameEmailCity(@RequestBody EmpAddressDto dto)
	{
		logger.info("Inside getEmp: findAll() method");	
		return service.getAllByNameOrCityOrEmail(dto.getEname(),dto.getCity(), dto.getEmail());
	
	}
	@GetMapping("/getnamecityemailzip")
	public List<EmployeeDto> getbyNameEmailCityZipcode(@RequestBody EmpAddressDto dto)
	{
		logger.info("Inside getbyNameEmailCityZipcode:");	
		return service.getAllByNameOrCityOrEmailOrZipcode(dto.getEname(),dto.getCity(), dto.getEmail(),dto.getZipcode());
	
	}
	@PostMapping("saveAll")
	public String saveAllEmp(@RequestBody List<EmployeeDto> dto)
	{
		logger.info("Inside saveAllEmp:");	
		int ed= service.saveAllEmpl(dto);
		return "saved";
	}
	@GetMapping("/getbycity")
	public List<EmployeeDto> getbyCity(@RequestBody EmpAddressDto dto)
	{
		logger.info("Inside getbyCity:");	
		return service.getAllByCity(dto.getCity());
	
	}
	@PutMapping("/updatepincodebycity")
	public String upadatePinByCity(@RequestBody EmployeeAddress dto)
	{
	logger.info("Inside upadatePinByCity: " + service.updateZipcodebByCity(dto.getZipcode(), dto.getCity()));
	return service.updateZipcodebByCity(dto.getZipcode(), dto.getCity());
	
	}
}
