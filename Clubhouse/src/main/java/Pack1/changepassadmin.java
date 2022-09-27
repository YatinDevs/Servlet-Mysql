package Pack1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
 
@WebServlet("/changepassadmin")
public class changepassadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try
		 {
		HttpSession s1= request.getSession();
		String u= (String)s1.getAttribute("user");
		
		String p=request.getParameter("pass");//this data will come from changepassword form
		
		 DatabaseConfig d1= new DatabaseConfig();
		 Connection con= d1.getCon();
		 PreparedStatement ps=con.prepareStatement("update adminlogin set pass=? where user=?");
		 ps.setString(1, p);
		 ps.setString(2, u);
		 ps.executeUpdate();
		 System.out.println("Password Updated!!");
		 response.sendRedirect("adminportal.html");
		}catch(Exception s) {}
	}

}
