package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Teacher;

public interface TeacherRepo extends CrudRepository<Teacher, Integer>
{
	List<Teacher> findBySubject(String subject);
}
