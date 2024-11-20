package com.sg.restaurantdaoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sg.dbutil.MyConnection;
import com.sg.restaurantdao.RestaurantDAO;
import com.sg.restaurantpojo.Restaurant;

public class RestaurantDAOImpl implements RestaurantDAO{

	ArrayList<Restaurant> resList = new ArrayList<Restaurant>();
	String fetchAllQuery = "select * from `restaurant`";
	private Connection con;
	private Statement stmt;
	private ResultSet resultSet;

	public RestaurantDAOImpl() {
		
		try {
			
			con = MyConnection.connect();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Restaurant> fetchAll() {
		
		try {
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(fetchAllQuery);
			return extractStudentListFromResultSet(resultSet);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return null;
	}
	
	List<Restaurant> extractStudentListFromResultSet(ResultSet resultSet)
	{
		try {
			
			while(resultSet.next())
			{
				resList.add(new Restaurant(resultSet.getInt("restaurantId"),
						resultSet.getString("name"),
						resultSet.getString("cuisineType"),
						resultSet.getString("address"),
						resultSet.getDouble("ratings"),
						resultSet.getInt("deliverTime"),
						resultSet.getBoolean("isActive"),
						resultSet.getString("image")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resList;
	}
	
	

}