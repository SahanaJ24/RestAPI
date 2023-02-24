package com.example.demo.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Child;
import com.example.demo.repository.Childrepository;

@Service
public class ChildService {
	@Autowired
	Childrepository repository;
	public boolean AddChild(Child ch) {
		repository.save(ch);
		return true;
	}
	public List<Child> getChildSorted(String field){
		return repository.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	public List<Child> getChildPaginated(int offset,int pageSize){
		Page<Child> page=repository.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}
	public List<Child> getChildWithPaginationAndSorting(int offset, int pageSize, String field) {
		Page<Child>page=repository.findAll(PageRequest.of(offset, pageSize,Sort.by(field)));
		return page.getContent();
		
	}
}
