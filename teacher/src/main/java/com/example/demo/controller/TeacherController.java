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

import com.example.demo.dao.TeacherRepo;
import com.example.demo.model.Teacher;

@RestController
public class TeacherController 
{
	@Autowired
	TeacherRepo repo;
	
	@RequestMapping("/")
	public String home()
	{
		return "hello and Welcome to the Spring Boot Application. You can create a New Note by making a POST request to/api/notes endpoint";
	}
	
	/*@RequestMapping("/addTeacher")
	public String addTeacher(Teacher teacher)
	{
		repo.save(teacher);
		return "home.jsp";
	}*/
	
	@PostMapping("/Teacher")
	public Teacher addTeacher(Teacher teacher)
	{
		repo.save(teacher);
		return teacher;
	}
	

	@RequestMapping("/Teacher/{tid}")
	@ResponseBody
	public Optional<Teacher> getTeacher(@PathVariable int tid)
	{
		return repo.findById(tid);
	}
	@GetMapping(path="/Teacher")
	@ResponseBody
	public java.util.List<Teacher> getTeachers()
	{
		return (List<Teacher>) repo.findAll();
	}
	
	@DeleteMapping("/Teacher/{tid}")
	public String deleteTeacher(@PathVariable int tid)
	{
		repo.deleteById(tid);
		return "deleted";
	}
	@PutMapping(path="/Teacher")
	public Teacher updateTeacher(Teacher teacher)
	{
		repo.save(teacher);
		return teacher;
	}
	
	
}
	
