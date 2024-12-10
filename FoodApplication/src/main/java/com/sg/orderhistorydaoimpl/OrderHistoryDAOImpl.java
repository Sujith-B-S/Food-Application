package com.sg.orderhistorydaoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sg.dbutil.MyConnection;
import com.sg.oderhistorypojo.OrderHistory;

public class OrderHistoryDAOImpl {
	
	ArrayList<OrderHistory> ohList = new ArrayList<OrderHistory>();
	private Connection con;
	String insertQuery = "insert into `orderhistory`(`orderId`,`userId`,`restaurantId`,`total`,`status`) values (?,?,?,?,?)";
	String fetchOnIdQuery = "select * from `orderhistory` where `userId` = ?";
	private PreparedStatement pstmt;
	private int status;
	private ResultSet resultSet;
	public OrderHistoryDAOImpl() {
		con  = MyConnection.connect();
		
	}
	
	public int insertData(OrderHistory oh)
	{
		try {
			
			pstmt = con.prepareStatement(insertQuery);
			pstmt.setInt(1, oh.getOrderId());
			pstmt.setInt(2, oh.getUserId());
			pstmt.setInt(3, oh.getRestaurantId());
			pstmt.setDouble(4, oh.getTotal());
			pstmt.setString(5, oh.getStatus());
			
			status = pstmt.executeUpdate();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		return status;
	}
	
	public ArrayList<OrderHistory> fetchOnId(int id)
	{
		
		try {
			
			pstmt = con.prepareStatement(fetchOnIdQuery);
			pstmt.setInt(1, id);
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next())
			{
				ohList.add(new OrderHistory(resultSet.getInt("orderHistoryId"),
						resultSet.getInt("orderId"),
						resultSet.getInt("userId"),
						resultSet.getInt("restaurantId"),
						resultSet.getDouble("total"),
						resultSet.getString("status")));
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return ohList;
	}
	

}
