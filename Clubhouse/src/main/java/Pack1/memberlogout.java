package Pack1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class memberlogout
 */
@WebServlet("/memberlogout")
public class memberlogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
			HttpSession s1= request.getSession();
			s1.removeAttribute("user");
			s1.removeAttribute("pass");
			s1.invalidate();
			response.sendRedirect("Homepage.html");
			System.out.println("Logged Out Sucessfully");
	}

	

}
