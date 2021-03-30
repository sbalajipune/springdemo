package com.studentrestservice.bean;

public class Student
{
	private int srn;
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
