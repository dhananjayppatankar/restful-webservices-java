package com.dhananjay.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("students")
public class StudentResource {
	
StudentRepo studentRepo = new StudentRepo();	
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})	
	public List<Student> getStudents()
	{
		System.out.println("Student get Method Called");
		
		return studentRepo.getStudents();
	}
	
	
//	@GET
//	@Path("student/{id}")
//	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})	
//	public Student getStudent(@javax.ws.rs.PathParam ("id") int id)
//	{
//		System.out.println("Student id get Method Called");
//		
//		// return studentRepo.getStudent(id);
//		 
//	}
	
	
	@POST
	@Path("createstudent")
	public Student createS(Student s){
		
	
		System.out.println(s);
	//	studentRepo.createStudent(s);
		return(s);
		
	}

}
