package Pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Addmemberdetails
 */
@WebServlet("/Addmemberdetails")
public class Addmemberdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int aadharID=Integer.parseInt(request.getParameter("aadharID"));
			String email= request.getParameter("email");
			String name= request.getParameter("name");
			int age=Integer.parseInt(request.getParameter("age"));
			String phone= request.getParameter("phone");		
			String address= request.getParameter("address");
			
	 		PrintWriter out =response.getWriter();

	 	   DatabaseConfig d1 = new DatabaseConfig();

	 	   
	 	   
	 	   Connection con= d1.getCon();
	 	   //queries are stored in pre compiled form 
	 	   //they are faster then statement 
	 	   //prepared statement inherits Statement 
	 	    //in place of value we write ? 
	 	    PreparedStatement ps= con.prepareStatement("insert into memberdetail values(?,?,?,?,?,?);");	
	 		ps.setInt(1, aadharID);
	 		ps.setString(2, email);
	 		ps.setString(3, name);
	 		ps.setInt(4, age);
	 		ps.setString(5, phone);
	 		ps.setString(6, address);
	 		int y1 =ps.executeUpdate();
	 		if(y1>0)
	 		{
	 			 System.out.println(" record inserted");
				response.sendRedirect("adminportal.html");

	 		}
	 		
	 			}catch(Exception f) {}}

	        
		
	}
