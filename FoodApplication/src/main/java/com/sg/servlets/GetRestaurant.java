package com.sg.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sg.menudaoimpl.MenuDAOImpl;
import com.sg.menupojo.Menu;
import com.sg.restaurantdaoimpl.RestaurantDAOImpl;
import com.sg.restaurantpojo.Restaurant;

@WebServlet("/GetRestaurant")
public class GetRestaurant extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RestaurantDAOImpl rdaoimpl = new RestaurantDAOImpl();
		MenuDAOImpl mdaoi = new MenuDAOImpl();
		
		// Fetch the list of restaurants and store it in resList
		List<Restaurant> resList = rdaoimpl.fetchAll();
		
		// Set resList in session attribute for access in home.jsp
		req.getSession().setAttribute("resList", resList);
		
		List<Menu> hmList = mdaoi.getRatedMenu(4.80);
		
		if(hmList != null && !hmList.isEmpty())
		{
			req.getSession().setAttribute("hmList" , hmList);
		}
		else
		{
			PrintWriter pw = resp.getWriter();
			pw.println("MenuList is Empty");
		}
		
		// Redirect to home.jsp
		resp.sendRedirect("home.jsp");
	}
}
