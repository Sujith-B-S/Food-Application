package com.sg.servlets;
		
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sg.cartitempojo.CartItem;
import com.sg.oderhistorypojo.OrderHistory;
import com.sg.orderhistorydaoimpl.OrderHistoryDAOImpl;
import com.sg.orderitemdaoimpl.OrderItemDAOImpl;
import com.sg.orderitempojo.OrderItem;
import com.sg.ordersdaoimpl.OrdersDAOImpl;
import com.sg.orderspojo.Orders;
import com.sg.userpojo.User;
		
/**		
 * Servlet implementation class SaveOrders
 */		
@WebServlet("/SaveOrders")
public class SaveOrders extends HttpServlet {
		
		
	private int userId;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	    PrintWriter pw = resp.getWriter();
	    User u = (User) req.getSession().getAttribute("loggedInUser");

	    
	    //Edit
	    String address = req.getParameter("address");
	    String phone = req.getParameter("phone");
	    
	   // pw.println(address+" "+phone);
	    
	    
	    
	    
	    
	    if (u != null) {
	        userId = u.getUid();
	    } else {
	        resp.sendRedirect("invalidUser.jsp");
	        return; // Exit to prevent further execution
	    }

	    // Retrieve cart from session
	    Map<Integer, CartItem> cart = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");
	    if (cart == null || cart.isEmpty()) {
	        pw.println("Cart is empty!");
	        return;
	    }

	    OrdersDAOImpl odaoi = new OrdersDAOImpl();
	    OrderItemDAOImpl oidaoi = new OrderItemDAOImpl();
	    OrderHistoryDAOImpl ohdaoi = new OrderHistoryDAOImpl();

	    // Loop through the cart and process each item
	    for (CartItem c : cart.values()) {
	        // Create and insert order
	        Orders o = new Orders();
	        o.setUserId(userId);
	        o.setRestuarantId(c.getRestaurantId());
	        o.setMenuId(c.getItemId());
	        o.setQuantity(c.getQuantity());
	        o.setTotal(c.getQuantity() * c.getPrice());
	        o.setPayment("UPI");
	        o.setStatus("Delivered");

	        odaoi.inserData(o);

	        // Retrieve the latest inserted order
	        Orders insertedOrder = odaoi.getMaxOrderId();

	        // Create and insert order item
	        OrderItem oi = new OrderItem(insertedOrder.getOrderId(), insertedOrder.getMenuId(), 
	                                      insertedOrder.getQuantity(), insertedOrder.getTotal());
	        oidaoi.insertData(oi);

	        // Create and insert order history
	        OrderHistory oh = new OrderHistory(insertedOrder.getOrderId(), insertedOrder.getUserId(), 
	                                           insertedOrder.getRestuarantId(), insertedOrder.getTotal(), insertedOrder.getStatus());
	        ohdaoi.insertData(oh);
	    }
	    
	    resp.sendRedirect("orderSuccess.jsp");
	}
	
}		
		
		
		