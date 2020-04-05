package ca.myseneca.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.DelegatingCallableStatement;

import oracle.jdbc.OracleCallableStatement;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * DbUtilities provides functionality to read property file, get connection for
 * database, print sql exception
 */
public class ConnectionPool {
	private static ConnectionPool pool = null;
	private static DataSource dataSource = null;

	private ConnectionPool() {
		try {
			InitialContext ic = new InitialContext();
			dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/oracle");
		} catch (NamingException e) {
			System.out.println(e);
		}
	}

	public static synchronized ConnectionPool getInstance() {
		if (pool == null) {
			pool = new ConnectionPool();
		}
		return pool;
	}

	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

	public static OracleCallableStatement getOracleCallableStatement(CallableStatement callableStatement)
			throws SQLException {
		OracleCallableStatement ocs = null;

		if (callableStatement instanceof DelegatingCallableStatement) {
			DelegatingCallableStatement dcs = (DelegatingCallableStatement) callableStatement;
			ocs = (OracleCallableStatement) dcs.getInnermostDelegate();
		}
		return ocs;
	}
}
