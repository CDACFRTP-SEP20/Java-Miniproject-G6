package com.gms.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class DbUtil {
	public static String dbUrl="jdbc:mysql://localhost:3306/gms-db" ;
	public static String dbUser="root" ;
	public static String dbPassword="cybage@123" ;
	/*
	 * 
	 * dbURL=jdbc:mysql://localhost:3306/gms-db
dbUser=root
dbPassword=cybage@123
	static {
		try{
			FileReader fr = new FileReader("app.properties");	//reading file
			Properties props = new Properties();				//properties to convert data into key value
			props.load(fr);
			dbUrl = props.getProperty("dbUrl");
			dbUser = props.getProperty("dbUser");
			dbPassword = props.getProperty("dbPassword");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	*/

	
	//with connection pool
		/*public static Connection getConnection() throws Exception{
			Connection con = DriverManager.getConnection();
			return con;
		}
*/

	//without connection pool
		public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");		//class will be loaded automatically (thin driver)
			Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		return con;
		}

	//getting connection from connection pool
	/*public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection();
		return con;
	}
	private static BasicDataSource getDataSource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl(dbUrl);
		ds.setUsername(dbUser);
		ds.setPassword(dbPassword);
		ds.setMinIdle(5);
		ds.setMaxIdle(10);
		ds.setMaxOpenPreparedStatements(100);
		return ds;		
	}*/
}