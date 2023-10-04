package test;
import java.sql.*;
public class DBConnection {
	public static Connection con=null;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String username = "root";
			String password = "Himanshu@12";
			String url = "jdbc:mysql://localhost:3306/usersdb";
			con = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}	
	public static Connection getCon(){
		return con;
	}
}

