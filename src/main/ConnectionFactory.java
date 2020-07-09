package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class ConnectionFactory {

	public static String DRIVER = "com.mysql.jdbc.Driver"; 
	public static String URL = "jdbc:mysql://localhost:3306/library";
	public static String USER = "root"; 
	public static String PASSWORD = "12345";
	
	public static Connection getConnection(){
		
		try{
			Class.forName(DRIVER); 
			
			return DriverManager.getConnection(URL, USER, PASSWORD); 
			
			
		}catch(Exception e){
			System.err.println(e);
		}
		return null; 
	}
	
	public static void closeConnection(Connection connection){
		
		try{
			
		if(connection != null){
			
			connection.close();
			
		}
		
		}catch(Exception e){
			System.err.println(e);
		}
		
	}
	
	public static void closeConnection(Connection connection, PreparedStatement pstmt){
		
		try{
			if(pstmt != null){
			pstmt.close();
			}
		}catch(Exception e){
			System.err.println(e);
		}
		
		closeConnection(connection); 

	}
	
	public static void closeConnection(Connection connection, PreparedStatement pstmt, ResultSet result ){
		
		try{
			
			if(result != null){
				result.close();
			}
			
		}catch(Exception e){
			System.err.println();
		}
		
		closeConnection(connection, pstmt); 
	}
	
}
