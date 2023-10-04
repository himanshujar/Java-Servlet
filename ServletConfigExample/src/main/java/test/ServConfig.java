package test;
import javax.servlet.*;
import java.io.*;
public class ServConfig extends GenericServlet{
	public int count;
	public void init(ServletConfig sc) {
		count=Integer.parseInt(sc.getInitParameter("count"));
	}
	public void service(ServletRequest req,ServletResponse res) 
	throws IOException,ServletException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		pw.println("value of count : "+count);
		pw.close();
	}
    public void destroy() {}
}
