package com.sg.menudaoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sg.dbutil.MyConnection;
import com.sg.menudao.MenuDAO;
import com.sg.menupojo.Menu;

public class MenuDAOImpl implements MenuDAO{
	
	List<Menu> menuList = new ArrayList<Menu>();
	private Connection con;
	String fetchOnIdQuery = "select * from `menu` where `restaurantId` = ?";
	String getMenuQuery = "select * from `menu` where `menuId` = ?";
	private PreparedStatement pstmt;
	private ResultSet resultSet;
	private Menu menu;

	public MenuDAOImpl() {

		con = MyConnection.connect();
	}
	
	@Override
	public List<Menu> fetchOnId(int id) {
	    try {
	        pstmt = con.prepareStatement(fetchOnIdQuery);
	        pstmt.setInt(1, id);
	        resultSet = pstmt.executeQuery();
	        
	        // Extract the list of menu items from the result set
	        menuList = extractMenuListFromResultSet(resultSet);
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    // Check if the list is not empty before accessing the first element
	    if (!menuList.isEmpty()) {
	        return menuList; // Return the first menu item
	    } else {
	        return null; // Return null if no menu items are found
	    }
	}
	
	
	@Override
	public Menu getMenu(int id) {
	    try {
	        pstmt = con.prepareStatement(getMenuQuery);
	        pstmt.setInt(1, id);
	        resultSet = pstmt.executeQuery();
	        
	        // Extract the list of menu items from the result set
	        menuList =  extractMenuListFromResultSet(resultSet);
	        if(!(menuList.isEmpty()))
	        {
	        	menu = menuList.get(0);
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    // Check if the list is not empty before accessing the first element
	    return menu;
	}

	private List<Menu> extractMenuListFromResultSet(ResultSet resultSet) {
	    try {
	        while (resultSet.next()) {
	            // Adding menu items to the list
	            menuList.add(new Menu(
	                resultSet.getInt("menuId"),
	                resultSet.getInt("restaurantId"),
	                resultSet.getString("name"),
	                resultSet.getString("description"),
	                resultSet.getDouble("price"),
	                resultSet.getDouble("rating"),
	                resultSet.getBoolean("isAvailable"),
	                resultSet.getString("image")
	            ));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return menuList;
	}

		
	
}
