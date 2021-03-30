package com.studentrestservice.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.studentrestservice.business.StudentBusiness;
import com.studentrestservice.entity.Student;
import com.studentrestservice.exception.StudentNotFoundException;

@RestController
@Validated
public class StudentController 
{
	@Autowired
	StudentBusiness business;
	
	//@RequestMapping(path="/students/{srn}", method = RequestMethod.GET)
	@GetMapping("/students/{srn}")
	public Student getStudentBySrn(@PathVariable("srn") @Min(value=1, message = "Roll number should be greater than 0") int rn)
	{
		Student student = business.getStudentByRn(rn);
		
		if(student == null)
			throw new StudentNotFoundException("Student with rollnumber " + rn + " not found");
		
		return student;
	}
	
	@GetMapping("/students")
	public List<Student> showAllStudents()
	{
		return business.getAllStudents();
	}
	
	@PostMapping("/student")
	public ResponseEntity<Student> createStudent(@Valid @RequestBody Student s)
	{
		business.insertStudent(s);
		return new ResponseEntity<Student>(HttpStatus.CREATED);
	}
}
