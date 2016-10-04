package com.ts.entitymanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlBrowserEntity {
	public static void main(String []args ){
		try {
			selectRecordsFromTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 private static Connection conn;
 public static Connection MysqlEntity(){
  conn = null;
  try{
   String userName = "emailtalkdev";
   String password = "m0Isfs1dAYUGk7XF";
   String url = "jdbc:mysql://192.168.0.10/emailtalkdev";
   Class.forName ("com.mysql.jdbc.Driver").newInstance ();
   conn = DriverManager.getConnection(url, userName, password);
   System.out.println("Works");
  }
  catch(Exception e){
   System.out.println("Exception found"+e);
  }
return conn;
 }
 public Connection getConnection(){
  return conn;
 }
 public void closeConnection(){
  try{
   conn.close ();
  }catch (Exception e) {
   System.out.println ("Connection close error");
  }
 }
 
 

	private static void selectRecordsFromTable() throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "SELECT User_ID, First_Name, Last_Name, Email_Address FROM Users WHERE User_ID = ?";

		try {
			dbConnection = MysqlEntity();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, 1);

			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				String userid = rs.getString("User_ID");
				String firstname = rs.getString("First_Name");
				String lastname = rs.getString("Last_Name");
				String emailaddress = rs.getString("Email_Address");

				System.out.println("userid : " + userid);
				System.out.println("First Name : " + firstname );
				System.out.println("Last Name : "+lastname);
				System.out.println("Email Address : "+emailaddress);

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}
}
