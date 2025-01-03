package com.sg.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sg.decrypt.Decrypt;
import com.sg.userdaoimpl.UserDAOImpl;
import com.sg.userpojo.User;

public class Login extends HttpServlet{
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String encryptedEmail = Decrypt.decrypt(email);
		String password = req.getParameter("pwd");
		
		UserDAOImpl udao = new UserDAOImpl();
		User u = udao.fetchSpecific(email);
		if(u != null)
		{
			if(u.getPassword().equals(password))
			{
				HttpSession session = req.getSession();
				session.setAttribute("loggedInUser",u);
				resp.sendRedirect("GetRestaurant");
			}
			else
			{
				resp.sendRedirect("passwordIncorrect.jsp");
			}
		}
		else
		{
			resp.sendRedirect("invalidUser.jsp");
		}
	}
}
