package org.sdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insertion {
	public static void insert() throws Exception {
		Connection con=JdbcConnection.connection();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id");
		int id=sc.nextInt();
		System.out.println(id);
		System.out.println("Enter the name");
		String name=sc.next();
		System.out.println(name);
		System.out.println("Enter the salary");
		String salary=sc.next();
		System.out.println(salary);
		PreparedStatement ps=con.prepareStatement("insert into employee3 value(?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, salary);
		int a = ps.executeUpdate();
		if(a==1) {
			System.out.println("inserted");
		}
	}
}
