package com.sg.restaurantdao;

import java.util.List;

import com.sg.restaurantpojo.Restaurant;

public interface RestaurantDAO {

	List<Restaurant> fetchAll();
	
}
