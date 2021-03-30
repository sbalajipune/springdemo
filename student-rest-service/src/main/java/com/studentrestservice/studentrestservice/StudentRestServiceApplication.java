package com.studentrestservice.studentrestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.studentrestservice")
@EntityScan("com.studentrestservice.entity")
//'extends SpringBootServletInitializer' is only required if this service has to be deployed on external tomcat by creating a war file
public class StudentRestServiceApplication extends SpringBootServletInitializer
{
	public static void main(String[] args) {
		SpringApplication.run(StudentRestServiceApplication.class, args);
	}
}
