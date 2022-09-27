package Pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deletemember
 */
@WebServlet("/deletemember")
public class deletemember extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   try {
		     DatabaseConfig db= new DatabaseConfig();
		     Statement s= db.getS();
		     int aadharID= Integer.parseInt(request.getParameter("aadharID"));
		     String email=request.getParameter("email");
		     
		     int y=s.executeUpdate("delete from memberdetail where aadharID="+aadharID+";");
		     System.out.println("Member Deleted Sucessfully");

		     response.sendRedirect("viewallmember");
		   }catch(Exception f) {}
		}
		
   	
}

	

