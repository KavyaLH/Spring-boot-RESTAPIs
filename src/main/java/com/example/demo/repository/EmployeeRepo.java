package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.EmployeeAddress;
import com.example.demo.Entity.EmployeeDto;



@Repository
@Transactional
public interface EmployeeRepo extends JpaRepository<EmployeeDto, Integer> {

	//@Query (nativeQuery = true, value= "select ed.* from empaddress as es join  employeetable as ed  on es.aid =ed.addr_aid")
	public List<EmployeeDto> findByEname(String name);
	public EmployeeDto findByEid(int eid);
	
	@Query (nativeQuery = true, value= "update employeetable et set et.ename=:ename where et.email=:email")
	 @Modifying
	 public int updateNamebyEmail(@Param("ename") String ename,@Param("email") String email);
	
	@Query (nativeQuery = true, value= "update employeetable et set et.esalary=:esalary where et.email=:email")
	 @Modifying
	 public int updateSalarybyEmail(@Param("esalary") int esalary,@Param("email") String email);
	 
	@Query (nativeQuery = true, value= "update employeetable et set et.ename=:ename, et.esalary=:esalary where et.email=:email")
	 @Modifying
	 public int updateNameSalarybyEmail(@Param("ename") String ename,@Param("esalary") int esalary,@Param("email") String email);


	@Query (nativeQuery = true, value= "select et.* from employeetable et where et.ename=:ename or  et.email=:email or et.addr_aid in ( select aid from empaddress where city= :city)")
	 @Modifying
	 public List<EmployeeDto> getAllByNameOrCityOrEmail(@Param("ename") String ename, @Param("city") String city, @Param("email") String email);


@Query (nativeQuery = true, value= "select et.* from employeetable et where et.ename=:ename or  et.email=:email or et.addr_aid in ( select aid from empaddress where city= :city) or et.addr_aid in(select aid from empaddress where zipcode=:zipcode)")
@Modifying
public List<EmployeeDto> getAllByNameOrCityOrEmailOrZipcode(@Param("ename") String ename, @Param("city") String city, @Param("email") String email, @Param("zipcode") String zipcode);

@Query (nativeQuery = true, value= "select et.* from employeetable et where  et.addr_aid in ( select aid from empaddress where city= :city)")
@Modifying
public List<EmployeeDto> getAllByCity(@Param("city") String city);

}