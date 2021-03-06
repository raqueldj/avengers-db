package io.avengers.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MarvelDao {

	static Class c;
	
	public MarvelDao() {
		if (c == null) {
			try {
				c = Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new IllegalStateException("SQL Driver is not here: " + e.getMessage());
			}
		}
	}
	
	protected Connection connectToMySql(){
		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/marvel", "root", "");
			return connect;
		} catch (SQLException e) {
			throw new IllegalStateException("Wrong credentials (= login / password), or url or overloaded connection: " + e.getMessage());
		}
	}

}
