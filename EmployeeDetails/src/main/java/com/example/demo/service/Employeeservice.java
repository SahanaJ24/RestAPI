package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.Employeerepository;

@Service          
public class Employeeservice {
	@Autowired
	Employeerepository repository;
	public boolean AddEmployee(Employee emp){
		repository.save(emp);
		return true;
	}
	public List<Employee> getEmployee(){
		return repository.findAll();
	}
	public Optional<Employee> getCustomerById(int id){
		return repository.findById(id);
	}
}
