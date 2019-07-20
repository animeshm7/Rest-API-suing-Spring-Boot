package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.StudentRepo;
import com.example.demo.model.Student;

@RestController
public class StudentController 
{
	@Autowired
	StudentRepo repo;
	
	@RequestMapping("/")
	public String home()
	{
		return "hello and Welcome to the Spring Boot Application. You can create a New Note by making a POST request to/api/notes endpoint";
	}
	
	// FOLLOWING METHOD WILL BE USED TO CREATE AN ENTRY IN THE STUDENT TABLE
	@PostMapping("/Student")
	public Student addStudent(Student student)
	{
		repo.save(student);
		return student;
	}
	

	// FOLLOWING METHOD WILL BE USED TO FIND AN ENTRY IN THE STUDENT TABLE
	@RequestMapping("/Student/{sid}")
	@ResponseBody
	public Optional<Student> getStudent(@PathVariable int sid)
	{
		return repo.findById(sid);
	}
	
	
	// FOLLOWING METHOD WILL BE USED TO DISPLAY ALL THE ENTRIES IN THE STUDENT TABLE
	@GetMapping(path="/Student")
	@ResponseBody
	public java.util.List<Student> getStudents()
	{
		return (List<Student>) repo.findAll();
	}
	
	// FOLLOWING METHOD WILL BE USED TO DELETE AN ENTRY FROM THE STUDENT TABLE
	@DeleteMapping("/Student/{sid}")
	public String deleteStudent(@PathVariable int sid)
	{
		repo.deleteById(sid);
		return "deleted";
	}
	
	// FOLLOWING METHOD WILL BE USED TO UPDATE AN ENTRY IN THE STUDENT TABLE
	@PutMapping(path="/Student")
	public Student updateStudent(Student student)
	{
		repo.save(student);
		return student;
	}
	
	
}
	
