package com.studentrestservice.jparepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.studentrestservice.entity.Student;

@Repository
@Transactional
public class StudentJpaRepository
{
	@PersistenceContext
	EntityManager entityManager;
	
	/*public void createStudentTable()
	{
		jdbcTemplate.execute("create table Student(srn int, sname varchar(20), sclass varchar(20))");
		System.out.println("Student table created!");
	}*/
	
	public void insertStudent(Student s)
	{
		entityManager.merge(s);
		System.out.println("A row is inserted in Student table!");
	}
	
	public List<Student> getAllStudents()
	{
		Query namedQuery = entityManager.createNamedQuery("getAllStudents");
		return namedQuery.getResultList();
	}
	
	public Student getStudentByRn(int rn)
	{
		return entityManager.find(Student.class, rn);
	}
}
