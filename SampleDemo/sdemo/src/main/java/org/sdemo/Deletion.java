package org.sdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Deletion {
	public static void delete() throws Exception {
		Connection con = JdbcConnection.connection();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id:");
		int id=sc.nextInt();
		System.out.println(id);
		PreparedStatement ps=con.prepareStatement("delete from employee3 where id=?");
		ps.setInt(1, id);
		int a=ps.executeUpdate();
		if(a==1) {
			System.out.println("record deleted");
		}
	}
}
