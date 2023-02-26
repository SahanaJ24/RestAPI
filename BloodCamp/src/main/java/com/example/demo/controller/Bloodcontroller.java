package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BloodCamp;
import com.example.demo.service.Bloodservice;

@RestController
public class Bloodcontroller {
	@Autowired
	Bloodservice service;
	@PostMapping("/bc")
	public String Adddonor(@RequestBody BloodCamp bc) {
		return service.Adddonor(bc);
	}
	@GetMapping("/bc")
	public List<BloodCamp> read(){
		return service.getDonor();
	}
}
