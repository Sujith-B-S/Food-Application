package com.sg.orderspojo;

import java.time.LocalDateTime;

public class Orders {

	private int orderId;
	private int userId;
	private int restuarantId;
	private int menuId;
	private int quantity;
	private double total;
	private String payment;
	private LocalDateTime dateTime;
	private String status;
	
	
	public Orders() {
		super();
	}


	public Orders(int orderId, int userId, int restuarantId, int menuId, int quantity, double total, String payment,
			LocalDateTime dateTime, String status) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restuarantId = restuarantId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.total = total;
		this.payment = payment;
		this.dateTime = dateTime;
		this.status = status;
	}


	public Orders(int userId, int restuarantId, int menuId, int quantity, double total, String payment,
			LocalDateTime dateTime, String status) {
		super();
		this.userId = userId;
		this.restuarantId = restuarantId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.total = total;
		this.payment = payment;
		this.dateTime = dateTime;
		this.status = status;
	}


	public Orders(int userId, int restuarantId, int menuId, int quantity, double total, String payment, String status) {
		super();
		this.userId = userId;
		this.restuarantId = restuarantId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.total = total;
		this.payment = payment;
		this.status = status;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getRestuarantId() {
		return restuarantId;
	}


	public void setRestuarantId(int restuarantId) {
		this.restuarantId = restuarantId;
	}


	public int getMenuId() {
		return menuId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public String getPayment() {
		return payment;
	}


	public void setPayment(String payment) {
		this.payment = payment;
	}


	public LocalDateTime getDateTime() {
		return dateTime;
	}


	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}


	public String getStatus() {
		return status;
	}


	public Orders(int orderId, int userId, int restuarantId, int menuId, int quantity, double total, String payment,
			String status) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restuarantId = restuarantId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.total = total;
		this.payment = payment;
		this.status = status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", userId=" + userId + ", restuarantId=" + restuarantId + ", menuId="
				+ menuId + ", quantity=" + quantity + ", total=" + total + ", payment=" + payment + ", dateTime="
				+ dateTime + ", status=" + status + "]";
	}
	
	
	
	
	
}
