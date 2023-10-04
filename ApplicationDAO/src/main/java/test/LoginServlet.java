package test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
	throws IOException,ServletException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String uname=req.getParameter("uname");
		String pword=req.getParameter("pword");
		Connection con = DBConnection.getCon();
		String sql="Select * from users where username = ? and password = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, uname);
			preparedStatement.setString(2, pword);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				pw.println("Login Successful");
				RequestDispatcher rd= req.getRequestDispatcher("display");
				rd.forward(req, res);
			}
			else {
				pw.println(" Invalid Login");
				RequestDispatcher rd = req.getRequestDispatcher("Login.html");
				rd.include(req, res);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
