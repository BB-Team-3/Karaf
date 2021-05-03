package org.student.service.implementation;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DsConnection {

	public static Connection getconn() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("osgi:service");

		DataSource ds = (DataSource) envCtx.lookup("jdbc/student-h2");
		Connection con = ds.getConnection();
		return con;
	}
}
