package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Dto.EmpAddressDto;
import com.example.demo.Entity.EmployeeAddress;
import com.example.demo.Entity.EmployeeDto;

@Repository
@Transactional
public interface AddressRepo extends JpaRepository<EmployeeAddress, Integer>{

	public EmployeeAddress findBycity(String cname);
	
	@Query (nativeQuery = true, value= "update empaddress et set et.zipcode=:zipcode where et.city= :city")
	@Modifying
	public int updateZipByCity(@Param("zipcode") String zipcode,@Param("city") String city);
	
}
