package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.Employeeservice;

@RestController
public class EmployeeController {
	@Autowired 
	Employeeservice service;
	
	@PostMapping("/emp")
	public boolean AddEmployee(@RequestBody Employee emp) {
		return service.AddEmployee(emp);
	}
	@GetMapping("/emp")
	public List<Employee> read(){
		return service.getEmployee();
	}
	@GetMapping("/emp/{id}")
	public Optional<Employee> readById(@PathVariable int id){
		return service.getCustomerById(id);
	}
}
