package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BloodCamp;
import com.example.demo.repository.Bloodrepository;

@Service
public class Bloodservice {
	@Autowired
	Bloodrepository repository;
	public String Adddonor(BloodCamp bc) {
		repository.save(bc);
		return "Donor Added";
	}
	public List<BloodCamp> getDonor(){
		return repository.findAll();
	}
}
