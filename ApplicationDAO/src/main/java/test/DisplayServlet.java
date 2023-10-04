package test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class DisplayServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) 
	throws IOException,ServletException{
		PrintWriter pw= res.getWriter();
		res.setContentType("text/html");
		String uname=req.getParameter("uname");
		pw.println("<h1>----------------------Welcome "+uname+"-------------------</h1>");
		Connection con= DBConnection.getCon();
		String query="Select * from users where username=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, uname);
			ResultSet rs= preparedStatement.executeQuery();
			while(rs.next()) {
				pw.println("<h2> userId: "+rs.getInt(1));
				pw.println("<h2> userName: "+rs.getString(3));
				pw.println("<h2> password: "+rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
