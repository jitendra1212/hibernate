package com.nt.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

public class CustomJdbcConnectionProvider implements ConnectionProvider{

	@Override
	public boolean isUnwrappableAs(Class unwrapType) {
		System.out.println("CustomJdbcConnectionProvider.isUnwrappableAs()");
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> unwrapType) {
		System.out.println("CustomJdbcConnectionProvider.unwrap()");
		return null;
	}

	@Override
	public Connection getConnection() throws SQLException {
	System.out.println("CustomJdbcConnectionProvider.getConnection()");
	Connection con=null;
	try {
		//register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//esablish connection
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott", "tiger");
		
	}
	catch(SQLException se) {
		throw se;
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
		
	}

	@Override
	public void closeConnection(Connection con) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("CustomJdbcConnectionProvider.closeConnection()");
		con.close();
		
	}

	@Override
	public boolean supportsAggressiveRelease() {
		System.out.println("CustomJdbcConnectionProvider.supportsAggressiveRelease()");
		return false;
	}

}
