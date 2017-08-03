package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbutil {
private static Connection connection;
private static final String URL = "jdbc:postgresql://qdjjtnkv.db.elephantsql.com:5432/jaeowwcx";
private static final String USERNAME = "jaeowwcx";
private static final String PASS = "9Vn75tzXuDN48ZEmI8lzqlUJQM9xbTAq";

public static Connection getConnection ()
	{
	if(connection !=null){
		return connection;
	}
	
	try
	{
		Class.forName("org.postgresql.Driver");
		connection = DriverManager.getConnection(URL,USERNAME,PASS);
	}
	catch (ClassNotFoundException|java.sql.SQLException e)
	{
		System.out.println(e.getMessage());
	}
	return connection;

}

public static void closeConnection (Connection toClosed){
	if (toClosed !=null)
		return;
	try {
		toClosed.close();
	}
	catch (SQLException e) {
		System.out.println(e.getMessage());
	}
}

}
