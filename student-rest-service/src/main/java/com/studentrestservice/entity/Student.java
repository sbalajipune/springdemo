package com.studentrestservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

@Entity
@NamedQuery(name = "getAllStudents", query = "select s FROM Student s")
public class Student
{
	@Id
	private int srn;
	@Size(min = 3, message = "Student name should have at least 3 characters")
	private String sname;
	private String sclass;
	
	public Student()
	{
		
	}
	
	public Student(int rn, String name, String cl)
	{
		this.srn = rn;
		this.sname = name;
		this.sclass = cl;
	}
	public int getSrn() {
		return srn;
	}
	public void setSrn(int srn) {
		this.srn = srn;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
}
