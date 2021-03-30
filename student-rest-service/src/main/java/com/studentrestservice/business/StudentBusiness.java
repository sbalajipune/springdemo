package com.studentrestservice.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.studentrestservice.entity.Student;
import com.studentrestservice.jparepository.StudentJpaRepository;

@Service
public class StudentBusiness
{
	@Autowired
	StudentJpaRepository repository;
	
	public StudentBusiness(StudentJpaRepository repository)
	{
		this.repository = repository;
	}
	
	public void createStudentTable()
	{
		//repository.createStudentTable();
	}
	
	public void insertStudent(Student s)
	{
		repository.insertStudent(s);
	}
	
	public List<Student> getAllStudents()
	{
		return repository.getAllStudents();
	}
	
	public Student getStudentByRn(int rn)
	{
		return repository.getStudentByRn(rn);
	}
}
