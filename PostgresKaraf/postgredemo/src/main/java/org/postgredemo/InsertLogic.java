package org.postgredemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertLogic {

	public static void insert() throws Exception {
		
		Scanner sc=new Scanner(System.in);
		Connection con= PostgreConfig.getcon();
		System.out.println("Enter id ");
		int id=sc.nextInt();
		System.out.println(id);
		System.out.println("Enter name of the student");
		String name=sc.next();
		System.out.println(name);
		System.out.println("Enter the section");
		String sec=sc.next();
		System.out.println(sec);
		
		PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, sec);
		int i=ps.executeUpdate();
		if(i!=0)
		{
			System.out.println("Inserted");
			
		}
		else
		{
			System.out.println("Insertion Failed");
		}
	}

}
