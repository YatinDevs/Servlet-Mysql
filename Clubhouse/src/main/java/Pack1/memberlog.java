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
@WebServlet("/memberlog")
public class memberlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
			int aadharID= Integer.parseInt(request.getParameter("aadharID"));
			String pass= request.getParameter("pass");

			DatabaseConfig d= new DatabaseConfig();
			Connection c= d.getCon();
			Statement s= c.createStatement();
			ResultSet rs= s.executeQuery("select * from memberlogins where aadharID='"+aadharID+"' and pass='"+pass+"'   ");
			System.out.println("Password Entered");
			//resultset cannot move previous unless we mention it as scrollable 
			if(rs.next()) 
			{ // state management
				//creating session
				HttpSession s2= request.getSession();
				s2.setAttribute("aadharID",aadharID);
				s2.setAttribute("pass",pass);
				
				// to loacte the page we want to go
				RequestDispatcher rd= request.getRequestDispatcher("memberportal.html");
				System.out.println("Password Entered Valid");

				rd.forward(request, response);
			}
			else
			{
				response.sendRedirect("memberlogin.html");
				System.out.println("Password Entered Invalid");

			}
			}
			catch(Exception d) {}
		}

}
