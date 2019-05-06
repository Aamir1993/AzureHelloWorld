package main;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AuthenticationController")
public class AuthenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AuthenticationController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");  
        rd.forward(request, response);  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		response.setContentType("text/html");   
		  
		String username = request.getParameter("username");  
		String password = request.getParameter("password");
		UserManager con = UserManager.getInstance();
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");  
		
		if(request.getParameter("login") != null) {
			//Log in
			boolean status = con.verifyUser(username, password);
			  		  
			if(status){
				User currentUser = UserManager.getInstance().getUserByUsername(username);
				if(currentUser != null) {
					currentUser.setSessionID(request.getSession().getId());
					request.setAttribute("username", currentUser.getUsername());
					request.setAttribute("id", currentUser.getId());
					rd = request.getRequestDispatcher("login.jsp"); 
				}  
			}
		}
		rd.forward(request, response);  
	}  
}
