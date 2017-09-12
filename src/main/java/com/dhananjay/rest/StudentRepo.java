package com.dhananjay.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo {

	Connection con = null;

	public StudentRepo() {

		String connectUri = "jdbc:mysql://localhost:3306/telusko";
		String uname = "root";
		String passwd = "admin";
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(connectUri, uname, passwd);
			System.out.println("Connected to DB");
		} catch (Exception e) {
			System.out.println("SQL Ecxeption");
		}
	}

	public List<Student> getStudents() {
		List<Student> studentList = new ArrayList<Student>();
		String sql = "select * from alien";
		try{
		Statement st = con.createStatement();
		ResultSet result = st.executeQuery(sql);
		
		while(result.next()){
			
			Student student = new Student();
			student.setId(result.getInt(1));
			student.setEmail(result.getString(2));
			student.setName(result.getString(3));
			
			studentList.add(student);
			
			
		}
		return studentList;
		
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	}

//	public Student getStudent(int id) {
//
//		for (Student student : myList) {
//
//			if (student.getId() == id) {
//
//				return student;
//			}
//
//		}
//		return new Student();
//	}
//
//	public void createStudent(Student s) {
//
//		myList.add(s);
//		System.out.println(myList);
//	}

}
