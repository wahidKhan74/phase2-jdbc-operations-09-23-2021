package com.simplilearn.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.simplilearn.util.InItConn;

public class ProductDAO {

	// create table
	public static void createTable(String tableName) throws SQLException {
		// get db connection
		Connection conn = new InItConn().getConnection();
		// prepare sql query
		String query = "create table " + tableName + "(id bigint primary key auto_increment,"
				+ " name varchar(100) , price decimal(10,2), date_added timestamp default now())";
		// create sql statement
		Statement stm = conn.createStatement();
		// execute query
		stm.execute(query);
		// close db connection
		conn.close();
	}

	// create product
	public static void addPorduct(String tableName, String productName, String productPrice) throws SQLException {
		// get db connection
		Connection conn = new InItConn().getConnection();
		// prepare insert query
		String query = "insert into " + tableName + "(name,price) values('" + productName + "'," + productPrice + ")";
		// create statement
		Statement stm = conn.createStatement();
		// execute query
		stm.execute(query);
		// close db connection
		conn.close();
	}

	// read all products
	public static ResultSet readProducts(String tableName) throws SQLException {
		// get db connection
		Connection conn = new InItConn().getConnection();

		// prepare insert query
		String query = "select * from " + tableName;

		// create statement
		Statement stm = conn.createStatement();

		// execute query
		ResultSet response = stm.executeQuery(query);

		return response;
	}

	// update product
	public static void updatePorduct(String tableName, String productId, String productName, String productPrice)
			throws SQLException {
		// get db connection
		Connection conn = new InItConn().getConnection();

		String query = "update " + tableName + " set name='" + productName + "',price=" + productPrice + " where id="
				+ productId;
		// create statement
		Statement stm = conn.createStatement();
		// execute query
		stm.execute(query);
		// close db connection
		conn.close();
	}

	// delete product
	public static void deletePorduct(String tableName, String productId) throws SQLException {

		// get db connection
		Connection conn = new InItConn().getConnection();

		String query = "delete from " + tableName + " where id="+ productId;
		// create statement
		Statement stm = conn.createStatement();
		// execute query
		stm.execute(query);
		// close db connection
		conn.close();
	}

	
}
