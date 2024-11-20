package com.sg.restaurantpojo;

public class Restaurant {
	
	private int restaurantId;
	private String name;
	private String cuisineType;
	private String address;
	private double ratings;
	private int deliverTime;
	private boolean isActive;
	private String image;
	
	public Restaurant() {
		super();
	}

	public Restaurant(int restaurantId, String name, String cuisineType, String address, double ratings,
			int deliverTime, boolean isActive, String image) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.cuisineType = cuisineType;
		this.address = address;
		this.ratings = ratings;
		this.deliverTime = deliverTime;
		this.isActive = isActive;
		this.image = image;
	}

	public Restaurant(String name, String cuisineType, String address, double ratings, int deliverTime,
			boolean isActive, String image) {
		super();
		this.name = name;
		this.cuisineType = cuisineType;
		this.address = address;
		this.ratings = ratings;
		this.deliverTime = deliverTime;
		this.isActive = isActive;
		this.image = image;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getRatings() {
		return ratings;
	}

	public void setRatings(double ratings) {
		this.ratings = ratings;
	}

	public int getDeliverTime() {
		return deliverTime;
	}

	public void setDeliverTime(int deliverTime) {
		this.deliverTime = deliverTime;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", name=" + name + ", cuisineType=" + cuisineType
				+ ", address=" + address + ", ratings=" + ratings + ", deliverTime=" + deliverTime + ", isActive="
				+ isActive + ", image=" + image + "]";
	}
	
	
	
	

}
