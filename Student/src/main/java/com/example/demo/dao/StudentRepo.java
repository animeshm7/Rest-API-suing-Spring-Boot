package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Student;

public interface StudentRepo extends CrudRepository<Student, Integer>
{
	//THIS IS A REPOSITORY FOR THE STUDENTS AND THIS IS AN INTERFACE EXTENDED FROM A CRUD REPOSITORY
	
	List<Student> findByBranch(String branch);
}
