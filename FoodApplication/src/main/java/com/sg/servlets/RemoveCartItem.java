package com.sg.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sg.cartdaoimpl.CartDAOImpl;
import com.sg.cartitempojo.CartItem;

/**
 * Servlet implementation class RemoveCartItem
 */
@WebServlet("/RemoveCartItem")
public class RemoveCartItem extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		int id = Integer.parseInt(req.getParameter("cartItemId"));
		
//		PrintWriter pw = resp.getWriter();
//		
//		pw.println(id);
		
		Map<Integer , CartItem> cart = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");
		
		
		CartDAOImpl cdaoi = new CartDAOImpl();
		
		cart = cdaoi.removeItem(cart, id);
		req.getSession().setAttribute("cart", cart);
		resp.sendRedirect("cart.jsp");
	}

}
