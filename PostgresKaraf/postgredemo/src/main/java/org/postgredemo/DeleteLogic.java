package org.postgredemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteLogic {

	public static void delete() throws Exception {
		Scanner sc=new Scanner(System.in);
		Connection con= PostgreConfig.getcon();
	
		System.out.println("Enter id to be deleted ");
		int id=sc.nextInt();
		System.out.println(id);
		
		PreparedStatement ps=con.prepareStatement("delete from student where id=?");
		ps.setInt(1,id);
		
		int i=ps.executeUpdate();
		if(i!=0)
			System.out.println("Deleted");
		else
			System.out.println("Not deleted");
	}

}
