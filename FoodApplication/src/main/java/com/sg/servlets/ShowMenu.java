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

@WebServlet("/ShowMenu")
public class ShowMenu extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
        int id = Integer.parseInt(req.getParameter("restaurantId"));
        MenuDAOImpl mdaoimpl = new MenuDAOImpl();
        List<Menu> menuList = mdaoimpl.fetchOnId(id);
        
        if (menuList != null && !menuList.isEmpty()) {
        	req.setAttribute("menu", menuList);
            req.getRequestDispatcher("menu.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "Menu not found for the given restaurant ID");
            req.getRequestDispatcher("invalidUser.jsp").forward(req, resp);
        }
    }
}
