package org.sdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Updation {
	public static void update() throws Exception {
		Connection con=JdbcConnection.connection();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id");
		int id=sc.nextInt();
		System.out.println(id);
		System.out.println("Enter the new salary");
		String salary=sc.next();
		System.out.println(salary);
		PreparedStatement ps=con.prepareStatement("update employee3 set salary=? where id=?");
		ps.setInt(2, id);
		ps.setString(1, salary);
		int a = ps.executeUpdate();
		if(a==1) {
			System.out.println("updated");
		}
	}
}
