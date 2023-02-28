package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;

@RestController
public class CarController {
	@Autowired
	CarService Service;
	@PostMapping("/car")
	public boolean postCar(@RequestBody Car car) {
		return Service.postCar(car);
	}
	
	@GetMapping("/owners/{owners}")
	public List<Car> getCarByOwners(@PathVariable int owners){
		return Service.getCarsByOwners(owners);
	}
	
	@GetMapping("/address/{address}")
	public List<Car> getCarByAddress(@PathVariable String address){
		return Service.getCarByAddress(address);
	}
	
	@GetMapping("/carname/{carname}")
	public List<Car> getCarByCarName(@PathVariable String carname){
		return Service.getCarByCarName(carname);
	}
	
	@GetMapping("/owners/{owners}/cartype/{cartype}")
	public List<Car> getCarByOwnersAndCarType(@PathVariable int owners, @PathVariable String cartype){
		return Service.getCarByOwnersAndCarType(owners,cartype);
	}
}
