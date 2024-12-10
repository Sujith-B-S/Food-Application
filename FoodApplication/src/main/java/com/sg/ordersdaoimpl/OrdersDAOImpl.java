package com.sg.ordersdaoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sg.dbutil.MyConnection;
import com.sg.orderspojo.Orders;

public class OrdersDAOImpl {

	ArrayList<Orders> oList = new ArrayList<Orders>();
	String maxOidQuery = "select * from `orders` where `orderId` = (select max(`orderId`) from`orders`)";
	String insertQuery = "insert into `orders`(`userId`,`restaurantId`,`menuId`,`quantity`,`total`,`payment`,`status`) values (?,?,?,?,?,?,?)";
	private Connection con;
	private PreparedStatement pstmt;
	private int status;
	private Statement stmt;
	private ResultSet resultSet;

	public OrdersDAOImpl() {

		con = MyConnection.connect();
	}
	
	public int inserData(Orders o)
	{
		
		try {
			pstmt = con.prepareStatement(insertQuery);
			pstmt.setInt(1, o.getUserId());
			pstmt.setInt(2, o.getRestuarantId());
			pstmt.setInt(3, o.getMenuId());
			pstmt.setInt(4, o.getQuantity());
			pstmt.setDouble(5, o.getTotal());
			pstmt.setString(6, o.getPayment());
			pstmt.setString(7, o.getStatus());
			
			status = pstmt.executeUpdate();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
		return status;
	}
	
	public Orders getMaxOrderId()
	{
		try {
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(maxOidQuery);
			
			while(resultSet.next())
			{
				oList.add(new Orders(resultSet.getInt("orderId"),
						resultSet.getInt("userId"),
						resultSet.getInt("restaurantId"),
						resultSet.getInt("menuId"),
						resultSet.getInt("quantity"),
						resultSet.getDouble("total"),
						resultSet.getString("payment"),
						resultSet.getString("status")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return oList.get(0);
	}
}
