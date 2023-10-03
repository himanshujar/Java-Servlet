package test;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;
public class DisplayServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String uname= req.getParameter("uname");
		pw.println("Welcome "+uname+"  -----!");
		String url = "jdbc:mysql://localhost:3306/usersdb";
        String username = "root";
        String password = "Himanshu@12";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
        	String sql = "SELECT * FROM users where username = ?";
            
            // Create a PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,uname);
            ResultSet rs=preparedStatement.executeQuery();
            pw.println("<h1>----------------------User Details-----------------------</h1>");
            while(rs.next()) {
            	pw.println("userId: "+rs.getInt(1));
            	pw.println("password: "+rs.getString(2));
            	pw.println("userName: "+rs.getString(3));
            }
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
} 