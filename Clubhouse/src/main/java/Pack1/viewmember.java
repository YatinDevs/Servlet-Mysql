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
 * Servlet implementation class viewallmember
 */
@WebServlet("/viewmember")
public class viewmember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();

		try {

        DatabaseConfig d1 = new DatabaseConfig();
        Statement s = d1.getS();
        int aadharID= Integer.parseInt(request.getParameter("aadharID"));
        // ResultSet interface ===> we traverse data from database
        // to fetch data we use resultset.next()
        ResultSet rs= s.executeQuery("select * from memberdetail order by aadharID where aadharID="+aadharID+";");
       
        //rs.next();
        out.println("<h1>Lists of Members </h1>");
        out.println("<table border=2>");
        out.print("<tr><th> aadharID <th> EmailID <th> Name <th> Age <th> PhoneNo <th> Address <th> Edit <th>Delete</tr>");
        while (rs.next())
        {
        // 1 and 2 are column number

        out.println("<tr><td> " +rs.getInt(1)+ "<td> " + rs.getString(2)+" <td> "+rs.getString(3)+ " <td> "+ rs.getInt(4)+ "<td>"+rs.getString(5)+ "<td>"+rs.getString(6));
        out.println("<td><a href='editbook?aadharID=" +  rs.getInt(1)+"'>Edit</a></td>");
        out.println("<td><a href='deletemember?aadharID=" +  rs.getInt(1)+"'>Delete</a>");
        System.out.println("Record Displayed to be Viewed");
        }
        } catch(Exception f) {	System.out.println("error occurred!!!!!!!!!!!---------" + f.getMessage()); }
	
	}
	


}
