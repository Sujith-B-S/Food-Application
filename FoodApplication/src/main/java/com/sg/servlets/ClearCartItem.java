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
 * Servlet implementation class ClearCartItem
 */
@WebServlet("/ClearCartItem")
public class ClearCartItem extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Map<Integer , CartItem> cart = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");
		
		
		CartDAOImpl cdaoi = new CartDAOImpl();
		
		cdaoi.clearCart(cart);
		
		resp.sendRedirect("cart.jsp");
	}

}
