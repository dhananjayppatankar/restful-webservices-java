package com.dhananjay.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		try {
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery(sql);

			while (result.next()) {

				Student student = new Student();
				student.setId(result.getInt(1));
				student.setEmail(result.getString(2));
				student.setName(result.getString(3));

				studentList.add(student);

			}
			return studentList;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public Student getStudent(int id) {
		Student student = new Student();
		String sql = "select * from alien where id=" + id;
		try {
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery(sql);

			if (result.next()) {

				student.setId(result.getInt(1));
				student.setEmail(result.getString(2));
				student.setName(result.getString(3));

				// studentList.add(student);

			}
			return student;

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;

	}

	public void createStudent(Student s) {

		String sql = "insert into alien values (?,?,?)";

		PreparedStatement pr;
		try {
			pr = con.prepareStatement(sql);

			pr.setInt(1, s.getId());
			pr.setString(2, s.getEmail());
			pr.setString(3, s.getName());
			pr.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void removeStud(int id) {

		String sql = "delete from alien where id=?";

		PreparedStatement pr;
		try {
			pr = con.prepareStatement(sql);
			pr.setInt(1, id);
			pr.executeUpdate();
			System.out.println("record removed successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void updateStudent(Student s) {

		String sql = " update alien set name=? , email=? where id=? ";

		PreparedStatement pr;
		try {
			pr = con.prepareStatement(sql);

			pr.setInt(3, s.getId());
			pr.setString(2, s.getEmail());
			pr.setString(1, s.getName());
			pr.executeUpdate();
			System.out.println("Update complete");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
