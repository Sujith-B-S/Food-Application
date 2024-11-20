package com.sg.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sg.userdao.UserDAO;
import com.sg.userdaoimpl.UserDAOImpl;
import com.sg.userpojo.User;
import com.tap.Encrypt.Encrypt;

@WebServlet("/register")
public class Register extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String encryptedName = Encrypt.encrypt(name);
		String email = req.getParameter("email");
		String encryptedEmail = Encrypt.encrypt(email);
		String password = req.getParameter("password");
		String encryptedPassword = Encrypt.encrypt(password);
		String mobile = req.getParameter("mobile");
		String encryptedMobile = Encrypt.encrypt(mobile);
		String address = req.getParameter("address");
		String encryptedAddress = Encrypt.encrypt(address);
		
		UserDAO udao = new UserDAOImpl();
		User u = new User(encryptedName, encryptedEmail, encryptedPassword, encryptedMobile, encryptedAddress);
		int status = udao.insert(u);

		if(status != 0) {
			// Redirect to login.jsp if registration is successful
			resp.sendRedirect("login.jsp");
		} else {
			// Redirect back to register.jsp with an error message if registration fails
			req.setAttribute("errorMessage", "Registration failed. This email may already be registered.");
			req.getRequestDispatcher("register.jsp").forward(req, resp);
		}
	}
}
