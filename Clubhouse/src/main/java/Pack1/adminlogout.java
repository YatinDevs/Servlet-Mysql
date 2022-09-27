package Pack1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class adminlogout
 */
@WebServlet("/adminlogout")
public class adminlogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public adminlogout() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
			HttpSession s2= request.getSession();
			s2.removeAttribute("aadharID");
			s2.removeAttribute("pass");
			s2.invalidate();
			response.sendRedirect("Homepage.html");
			System.out.println("Logged Out Sucessfully");
	}

	

}
