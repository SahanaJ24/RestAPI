package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Child;

@Repository
public interface Childrepository extends JpaRepository<Child,Integer> {
	
}
