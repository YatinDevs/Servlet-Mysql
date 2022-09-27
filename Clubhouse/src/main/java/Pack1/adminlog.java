package Pack1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
/**
 * Servlet implementation class adminlog
 */
@WebServlet("/adminlog")
public class adminlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
			String user= request.getParameter("user");
			String pass= request.getParameter("pass");

			DatabaseConfig d= new DatabaseConfig();
			Connection c= d.getCon();
			Statement s= c.createStatement();
			ResultSet rs= s.executeQuery("select * from adminlogin where user='"+user+"' and pass='"+pass+"'   ");
			System.out.println("Password Entered");
			//resultset cannot move previous unless we mention it as scrollable 
			if(rs.next()) 
			{ // state management
				//creating session
				HttpSession s1= request.getSession();
				s1.setAttribute("user",user);
				s1.setAttribute("pass",pass);
				
				// to loacte the page we want to go
				RequestDispatcher rd= request.getRequestDispatcher("adminportal.html");
				System.out.println(" Entered Valid Password");

				rd.forward(request, response);
			}
			else
			{
				response.sendRedirect("adminlogin.html");
				System.out.println(" Entered Invalid Password ");

			}
			}
			catch(Exception d) {}
		}

}
