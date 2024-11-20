package com.sg.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sg.cartdaoimpl.CartDAOImpl;
import com.sg.cartitempojo.CartItem;
import com.sg.menudaoimpl.MenuDAOImpl;
import com.sg.menupojo.Menu;

@WebServlet("/AddToCartController")
public class AddToCartController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // Retrieve the cart from the session or initialize a new one
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }

        try {
            int menuId = Integer.parseInt(req.getParameter("menuId"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));

            // Retrieve menu details
            MenuDAOImpl menuDao = new MenuDAOImpl();
            Menu menu = menuDao.getMenu(menuId);

            if (menu == null) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().write("{\"message\": \"Invalid menu item.\"}");
                return;
            }

            // Add item to the cart
            CartDAOImpl cartDao = new CartDAOImpl();
            CartItem newItem = new CartItem(menuId, menu.getRestaurantId(), menu.getName(), quantity, menu.getPrice(), menu.getImage(), menu.getDescription());
            cart = cartDao.addItem(cart, newItem);

            // Update the session cart
            req.getSession().setAttribute("cart", cart);

            resp.getWriter().write("{\"message\": \"Item added to cart successfully.\"}");
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("{\"message\": \"Invalid input. Please check the data.\"}");
        }
    }
}
