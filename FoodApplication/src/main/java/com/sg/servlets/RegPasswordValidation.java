package com.sg.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/validation")
public class RegPasswordValidation extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("cpassword");
		
		if(password.equals(confirmPassword)) {
			RequestDispatcher rd = req.getRequestDispatcher("register");
			rd.forward(req, resp);  // Use forward to send the form data to Register servlet for processing.
		} else {
			req.setAttribute("errorMessage", "Passwords do not match. Please try again.");
			RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
			rd.forward(req, resp);  // Redirect back to the registration page with an error message.
		}
	}
}
