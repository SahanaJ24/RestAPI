package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;

@Service
public class CarService {
	@Autowired
	CarRepository repository;
	
	public boolean postCar(Car car) {
		repository.save(car);
		return true;
	}

	public List<Car> getCarsByOwners(int owners) {
		return repository.findByOwners(owners);
	}

	public List<Car> getCarByAddress(String address) {
		return repository.findByAddress(address);
	}

	public List<Car> getCarByCarName(String carname) {
		return repository.findByCarName(carname);
	}

	public List<Car> getCarByOwnersAndCarType(int owners, String cartype) {
		return repository.findByOwnersAndCarType(owners, cartype);
	}
}
