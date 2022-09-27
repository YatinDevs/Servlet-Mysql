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
 * Servlet implementation class updatemember
 */
@WebServlet("/updatemember")
public class updatemember extends HttpServlet {
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {

	int aadharID=Integer.parseInt(request.getParameter("aadharID"));
	String email= request.getParameter("email");
	String name= request.getParameter("name");
	int age=Integer.parseInt(request.getParameter("age"));
	String phone= request.getParameter("phone");		
	String address= request.getParameter("address");
	DatabaseConfig db= new DatabaseConfig();
    Statement s= db.getS();
    PrintWriter out= response.getWriter();
	 out.println(aadharID +  "   "+ email +"  " + name + " "+ age + " " + phone + " " +  address);
	 
    int y=s.executeUpdate("update memberdetail set email='  "+ email +"',name=' " + name + "',age= '"+ age + "',phone='" + phone + " ',address=' " + address+"'  where aadharID='"+aadharID+"';");
   
	
			    
	     response.sendRedirect("viewallmember");
       }catch (Exception e) {}
	}

}
