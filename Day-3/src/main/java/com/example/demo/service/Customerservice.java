package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class Customerservice {
	@Autowired
	CustomerRepository repository;
	public String AddCustomer(Customer cust) {
		repository.save(cust);
		return "Added";
	}
	public List<Customer> getCustomer(){
		return repository.findAll();
	}
}
