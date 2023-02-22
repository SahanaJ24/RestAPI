package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.Customerservice;

@RestController
public class Customercontroller {
	@Autowired
	Customerservice service;
	
	@PostMapping("/cust")
	public String addCustomer(@RequestBody Customer cust) {
		return service.AddCustomer(cust);
	}
	@GetMapping("/cust")
	public List<Customer> read(){
		return service.getCustomer();
	}
	
}
