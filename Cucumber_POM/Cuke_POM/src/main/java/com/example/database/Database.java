package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	 Connection con;
	 ResultSet results;
   private void DBConnection() {
	   
	    try {
			con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS;DATABASENAME=CHAMPS;encrypt=false;integratedSecurity=true;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
   private void GetQuery() throws SQLException {
	   DBConnection();
	  String query = "Select * FROM Accounts WHERE FirstName =\'James\'";
	  Statement statement = this.con.createStatement();
	   results = statement.executeQuery(query);
	
   }
   public String GetNames() throws SQLException {
	   GetQuery();
	   results.next();
	  String firstName = results.getString("FirstName");
	   return firstName;
   }
}
