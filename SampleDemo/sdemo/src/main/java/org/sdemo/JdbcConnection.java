package org.sdemo;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcConnection {
	public static Connection connection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("osgi:service");

		// Look up our data source
		DataSource ds = (DataSource)
		  envCtx.lookup("jdbc/mysql1");
		Connection con=ds.getConnection();
		return con;
			
	}
}
