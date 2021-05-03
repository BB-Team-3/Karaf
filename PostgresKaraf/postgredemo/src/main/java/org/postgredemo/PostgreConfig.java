package org.postgredemo;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class PostgreConfig {

	public static Connection getcon() throws Exception {

		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("osgi:service");

		// Look up our data source
		DataSource ds = (DataSource) envCtx.lookup("jdbc/postgresql");
		Connection con = ds.getConnection();
		if (!con.isClosed()) {
			System.out.println("connected");
			return con;
		} else {
			System.out.println("not connected");
			return null;
			
		}
	

	}

}
