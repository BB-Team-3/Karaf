package org.sdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Selection {
	public static void select() throws Exception {
		Connection con=JdbcConnection.connection();
		PreparedStatement ps=con.prepareStatement("select * from employee3");
		ResultSet rs=ps.executeQuery();
		System.out.println("ID:          Name:            Salary:");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
	}
}
