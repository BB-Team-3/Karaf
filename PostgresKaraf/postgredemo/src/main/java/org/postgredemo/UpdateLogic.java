package org.postgredemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateLogic {

	public static void update() throws Exception {
		
		Scanner sc=new Scanner(System.in);
		Connection con= PostgreConfig.getcon();
	
		System.out.println("Enter id where you want to update the section ");
		int id=sc.nextInt();
		System.out.println(id);
		
		System.out.println("Enter the new section");
		String sec=sc.next();
		System.out.println(sec);
		
		PreparedStatement ps=con.prepareStatement("update student set section=? where id=?");
		ps.setInt(1, id);
		ps.setString(2, sec);
		int i=ps.executeUpdate();
		 
		 if(i!=0)
			{
				System.out.println("updated");				
			}
			else
			{
				System.out.println("Update Failed");
			}
		
	}

}
