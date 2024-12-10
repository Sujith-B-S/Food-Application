package com.sg.orderitemdaoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sg.dbutil.MyConnection;
import com.sg.orderitempojo.OrderItem;

public class OrderItemDAOImpl {
	
	private Connection con;
	String insertQuery = "insert into `orderitems`(`orderId`,`menuId`,`quantity`,`itemTotal`) values (?,?,?,?)";
	private PreparedStatement pstmt;
	private int status;

	public OrderItemDAOImpl() {

		con = MyConnection.connect();
	}
	
	public int insertData(OrderItem oi)
	{
		try {
			pstmt = con.prepareStatement(insertQuery);
			pstmt.setInt(1, oi.getOrderId());
			pstmt.setInt(2, oi.getMenuId());
			pstmt.setInt(3, oi.getQuantity());
			pstmt.setDouble(4, oi.getItemTotal());
			
			status = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
		
		
	}
	
	public int getMenuIdByOrderId(int orderId) {
	    int menuId = -1; // Default value in case no result is found
	    String query = "SELECT menuId FROM orderitems WHERE orderId = ?";
	    
	    try (PreparedStatement pstmt = con.prepareStatement(query)) {
	        pstmt.setInt(1, orderId); // Set the orderId parameter
	        var rs = pstmt.executeQuery();
	        if (rs.next()) {
	            menuId = rs.getInt("menuId");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return menuId; // Returns the menuId or -1 if not found
	}


}
