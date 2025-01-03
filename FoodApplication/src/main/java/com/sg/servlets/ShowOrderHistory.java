package com.sg.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sg.oderhistorypojo.OrderHistory;
import com.sg.orderhistorydaoimpl.OrderHistoryDAOImpl;
import com.sg.userpojo.User;

/**
 * Servlet implementation class ShowOrderHistory
 */
@WebServlet("/ShowOrderHistory")
public class ShowOrderHistory extends HttpServlet {
	
	
	private int userId;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User u = (User) req.getSession().getAttribute("loggedInUser");
		
		userId = u.getUid();
		
		OrderHistoryDAOImpl ohdaoi = new OrderHistoryDAOImpl();
		
		ArrayList<OrderHistory> ohList =  ohdaoi.fetchOnId(userId);
		
		req.getSession().setAttribute("ohList", ohList);
		
		resp.sendRedirect("orderHistory.jsp");
		
	}

}
