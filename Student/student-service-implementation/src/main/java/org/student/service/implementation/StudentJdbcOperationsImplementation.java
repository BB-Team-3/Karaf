package org.student.service.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.student.service.api.Student;
import org.student.service.api.StudentJdbcOperations;

public class StudentJdbcOperationsImplementation implements StudentJdbcOperations {

	Scanner sc = new Scanner(System.in);

	@Override
	public void displayStudent() throws Exception {
		Connection connection = DsConnection.getconn();
		System.out.println("in display");
		String displaysql = "select * from student";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(displaysql);
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
		}
	}

	@Override
	public void addStudent() throws Exception {
		Connection connection = DsConnection.getconn();
		System.out.println("in insert");
		Student s = new Student();
		System.out.println("enter student id: ");
		s.setId(sc.nextInt());
		System.out.println("enter student name: ");
		s.setName(sc.next());
		System.out.println("enter student marks: ");
		s.setMarks(sc.next());
		String addsql = "insert into student values (?, ?, ?)";

		PreparedStatement ps = connection.prepareStatement(addsql);
		ps.setInt(1, s.getId());
		ps.setString(2, s.getName());
		ps.setString(3, s.getMarks());
		int i = ps.executeUpdate();
		if (i > 0)
			System.out.println("data inserted");
	}

	@Override
	public void updateStudent() throws Exception {
		Connection connection = DsConnection.getconn();
		System.out.println("in update");
		Student s = new Student();

		System.out.println("enter student id that you want to update marks: ");
		s.setId(sc.nextInt());
		System.out.println("enter the updated marks: ");
		s.setMarks(sc.next());
		String updatesql = "update student set marks = ? where id= ?";

		PreparedStatement ps = connection.prepareStatement(updatesql);
		ps.setString(1, s.getMarks());
		ps.setInt(2, s.getId());
		int i = ps.executeUpdate();
		if (i > 0)
			System.out.println("updated successfully");
	}

	@Override
	public void deleteStudent() throws Exception {
		Connection connection = DsConnection.getconn();
		System.out.println("in delete");
		Student s = new Student();

		System.out.println("enter student id to delete: ");
		s.setId(sc.nextInt());
		String deletesql = "delete from student where id = ?";

		PreparedStatement ps = connection.prepareStatement(deletesql);
		ps.setInt(1, s.getId());
		int i = ps.executeUpdate();
		if (i > 0)
			System.out.println("deleted successfully");
	}

	@Override
	public void createTable() throws Exception {
		Connection connection = DsConnection.getconn();

		Statement st = connection.createStatement();
		String createtablesql = "create table if not exists student (id int primary key, name varchar(20), marks varchar(20))";
		st.execute(createtablesql);
		st.close();
	}

}
