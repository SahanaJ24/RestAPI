package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Expense;
import com.example.demo.repository.Expenserepo;

@Service
public class ExpenseService {
	@Autowired
	Expenserepo repository;
	public String Addexpense(Expense exp) {
		repository.save(exp);
		return "Amount Added";
	}
	public List<Expense> getexpense(){
		return repository.findAll();
	}
	public Optional<Expense> getexpenseById(int id){
		return repository.findById(id);
	}
	public String updateexpense(Expense blood) {
		repository.save(blood);
		return "Expense Updated";
	}
	public String deleteexpenseById(int id) {
		repository.deleteById(id);
		return "Expense Deleted";
	}
	public List<Expense> getexpenseSorted(String field){
		return repository.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	
	public List<Expense> getexpensePaginated(int offset,int pageSize){
		Page<Expense> page=repository.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}
	public List<Expense> getexpenseWithPaginationAndSorting(int offset, int pageSize, String field) {
		Page<Expense>page=repository.findAll(PageRequest.of(offset, pageSize,Sort.by(field)));
		return page.getContent();	
	}
}
