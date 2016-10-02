package com.ts.entitymanager;
import java.sql.Connection;
import java.sql.DriverManager;

public final class MysqlEntity {
	public static void main(String []args ){
		MysqlEntity();
	}
 private static Connection conn;
 public static void MysqlEntity(){
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
}