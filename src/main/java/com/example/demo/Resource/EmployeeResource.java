package com.example.demo.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.EmployeeDto;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeResource {

	@Autowired
	EmployeeService service;

	@Autowired
	EmployeeRepo repo;

	private static final Logger logger = LoggerFactory.getLogger(EmployeeResource.class);

	@GetMapping("get")
	public ResponseEntity<List<EmployeeDto>> getEmp() throws Exception {
		logger.info("Inside getEmp():");
		List<EmployeeDto> listOfEmployees = new ArrayList<>();
		try {
			logger.info("Inside try of getEmp()");
			listOfEmployees = service.getEmpl();
			if (listOfEmployees.isEmpty()) {
				logger.info("Inside if of getEmp()");
				throw new UserNotFoundException("No record found");
			}
		} catch (Exception e) {
			logger.info("Inside catch of getEmp()");
			e.printStackTrace();
		}
		logger.info("Inside getEmp(): Returning list of employees");
		return new ResponseEntity<List<EmployeeDto>>(listOfEmployees, HttpStatus.OK);
	}

	@PostMapping("save")
	public ResponseEntity<String> saveEmp(@RequestBody EmployeeDto dto) {

		logger.info("Inside saveEmp: save() method");
		try {
			EmployeeDto emailID = service.findByEmailid(dto.getEmail());
			if(emailID == null)
			{
			logger.info("Inside try block of saveEmp");
			EmployeeDto ed = service.saveEmpl(dto);
			
			}
		} catch (Exception e) {
			logger.info("Inside catch block of saveEmp");
			e.printStackTrace();
		}
		
		return new ResponseEntity<String>("Inserted Successfully", HttpStatus.OK);
		
	}

	@DeleteMapping("delete/{eid}")
	public void deleteEmp(@PathVariable int eid) {
		
		EmployeeDto em =repo.getOne(eid);
				service.deleteEmpl(em);
				
		/*
		 * logger.info("Inside deleteEmp: delete() method"); EmployeeDto em =
		 * repo.getOne(eid); logger.info("Inside deleteEmp:Outside try block");
		 * 
		 * try { logger.info("Inside deleteEmp:within try block");
		 * service.deleteEmpl(em); } catch (Exception e) {
		 * logger.info("Inside deleteEmp:within catch block"); e.printStackTrace(); } if
		 * (em == null) { logger.info("Inside deleteEmp:within if "); return new
		 * ResponseEntity<String>("Id not found", HttpStatus.NOT_FOUND); } else {
		 * logger.info("Inside deleteEmp:else block"); return new
		 * ResponseEntity<String>("Record with Id " + eid + " deleted", HttpStatus.OK);
		 * }
		 */
	}

	/*
	 * @PutMapping("/put") public ResponseEntity<String> updateEmp(@RequestBody
	 * EmployeeDto dto) { boolean val = false; try {
	 * logger.info("Inside updateEmp: save() method"); service.updateEmpl(dto); val
	 * = true; } catch (Exception e) { e.printStackTrace(); } if (val == true) {
	 * return new ResponseEntity<String>("Updated successfully", HttpStatus.OK); }
	 * else return new ResponseEntity<String>("Unsuccessful",
	 * HttpStatus.NOT_ACCEPTABLE); }
	 */
	@PutMapping("/putByEmail/{email}")
	public ResponseEntity<String> updateEmplByEmail(@PathVariable String email, @RequestBody EmployeeDto dto) {
		boolean val = false;
		try {
			logger.info("Inside updateEmplByEmail: upadate() method");
			if((service.updateEmpByEmail(dto.getName(), dto.getContact(), dto.getDob(), dto.getGender(), email).equals("Email ID not found")))
			{
				val = false;
				logger.info("Inside "+ val);
			}
			else
			{
				val = true;
				logger.info("Inside else"+ val);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (val == true) {
			return new ResponseEntity<String>("Updated successfully", HttpStatus.OK);
		} else
			return new ResponseEntity<String>("Unsuccessful", HttpStatus.NOT_ACCEPTABLE);
	}

	/*
	 * @GetMapping("/getByNamePasswrd/{name}/{password}") public String
	 * getByNamePassword(@PathVariable(name ="name") String name, @PathVariable(name
	 * = "password") String password, @RequestBody EmployeeDto dto) { String data=
	 * service.findIdByNamePassword(name, password) ; if(data.equals("ID found")) {
	 * return "Login successful"; } else return "Error with login details"; }
	 */
	@GetMapping("/getByNamePasswrd/{name}/{password}")	
	public String getByNamePassword(@PathVariable(name ="name") String name, @PathVariable(name = "password") String password)
	{
		String data= service.findIdByNamePassword(name, password) ;
	if(data.equals("ID found"))
	{
		return "Login successful";
	}
	else
		return null;
	}

}
