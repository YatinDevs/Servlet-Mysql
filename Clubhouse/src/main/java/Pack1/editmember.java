package Pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;;

@WebServlet("/editmember")
public class editmember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		int  aadharID= Integer.parseInt(request.getParameter("aadharID"));
		
		DatabaseConfig db= new DatabaseConfig();
		Statement s= db.getS();
		ResultSet rs= s.executeQuery("select * from memberdetail where aadharID='"+ aadharID +"' ");
		rs.next();
		PrintWriter out= response.getWriter();
		
		response.setHeader("Content-Type", "text/html");
		
		
		
		out.println("<form action='updatemember' method='post'>");
		out.println("AadharID :<input type='text' name='aadharID'   value='"+rs.getInt(1)+"'><br>");
		out.println("EmailID :<input type='text' name='email' value='"+rs.getString(2)+"'><br>");
		out.println("Name :<input type='text' name='name' value='"+rs.getString(3)+"'><br>");
		out.println("Age :<input type='text' name='age' value='"+rs.getInt(4)+"'><br>");
		out.println("Phone NO :<input type='text' name='phone'     value='"+rs.getString(5)+"'><br>");
		out.println("Address :<input type='text' name='address'     value='"+rs.getString(6)+"'><br>");
		out.println("<input type='submit'>");
		out.println("</form>");
		
		}
		catch(Exception df) {}
		

}
}
