package com.sg.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sg.cartdaoimpl.CartDAOImpl;
import com.sg.cartitempojo.CartItem;

/**
 * Servlet implementation class UpdateCartItem
 */
@WebServlet("/UpdateCartItem")
public class UpdateCartItem extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");
        if (cart == null) {
            resp.sendRedirect("cart.jsp?error=Cart is empty.");
            return;
        }

        try {
            int cartItemId = Integer.parseInt(req.getParameter("cartItemId"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));

            CartDAOImpl cartDao = new CartDAOImpl();
            cart = cartDao.updateItem(cart, cartItemId, quantity);

            req.getSession().setAttribute("cart", cart);
            resp.sendRedirect("cart.jsp");
        } catch (NumberFormatException e) {
            resp.sendRedirect("cart.jsp?error=Invalid input.");
        }
    }
}
