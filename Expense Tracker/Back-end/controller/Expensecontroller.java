package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Expense;
import com.example.demo.service.ExpenseService;

@RestController
public class Expensecontroller {
	@Autowired
	ExpenseService service;
	@PostMapping("/exp")
	@CrossOrigin(origins="http://localhost:3000")
	public String addexpense(@RequestBody Expense exp) {
		return service.Addexpense(exp);
	}
	@GetMapping("/exp")
	@CrossOrigin(origins="http://localhost:3000")
	public List<Expense> read(){
		return service.getexpense();
	}
	@GetMapping("/exp{id}")
	public Optional<Expense> readById(@PathVariable int id){
		return service.getexpenseById(id);
	}
	@PutMapping("/exp")
	@CrossOrigin(origins="http://localhost:3000")
	public String update(@RequestBody Expense exp) {
		return service.updateexpense(exp);
	}
	@DeleteMapping("/exp/{id}")
	@CrossOrigin(origins="http://localhost:3000")
	public String delete(@PathVariable int id) {
		return service.deleteexpenseById(id);
	}
	//Sorting
	@GetMapping("/exp/{field}")
	public List<Expense> expenseSorted(@PathVariable String field){
		return service.getexpenseSorted(field);
	}
	//Pagination
	@GetMapping("/blood/{offset}/{pageSize}")
	public List<Expense> expensePaginate(@PathVariable int offset, @PathVariable int pageSize){
		return service.getexpensePaginated(offset, pageSize);
	}
	//Sorting and Pagination
	@GetMapping("/blood/{offset}/{pageSize}/{field}")
	public List<Expense> getexpenseWithPaginationAndSorting(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field){
		return service.getexpenseWithPaginationAndSorting(offset, pageSize, field); 
	}
}
