package Pack1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
 
@WebServlet("/changepassmember")
public class changepassmember extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try
		 {
		HttpSession s2= request.getSession();
		int u= (int)s2.getAttribute("aadharID");
		
		String p=request.getParameter("pass");//this data will come from changepassword form
		
		 DatabaseConfig d1= new DatabaseConfig();
		 Connection con= d1.getCon();
		 PreparedStatement ps=con.prepareStatement("update memberlogins set pass=? where aadharID=?");
		 ps.setString(1, p);
		 
		 ps.setInt(2, u);
		 ps.executeUpdate();
		 System.out.println("Password Updated!!");
		 response.sendRedirect("memberportal.html");
		}catch(Exception s) {}
	}

}
