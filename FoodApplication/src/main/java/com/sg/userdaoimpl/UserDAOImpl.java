package com.sg.userdaoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sg.decrypt.Decrypt;
import com.sg.userdao.UserDAO;
import com.sg.userpojo.User;
import com.tap.Encrypt.Encrypt;

public class UserDAOImpl implements UserDAO{
	
	List<User> userList = new ArrayList<User>();
	private final String INSERT_QUERY = "insert into `user`(`userName`,`email`,`password`,`mobile`,`address`) values (?,?,?,?,?)";
	private final String FETCH_ALL_QUERY = "select * from `user`";
	private final String FETCH_SPECIFIC_QUERY = "select * from `user` where `email` = ?";
	private final String UPDATE_QUERY = "update `user` set `address` = ? where `email` = ?";
	private final String DELETE_QUERY = "delete from `user` where `email` = ?";
	

	private String url = "jdbc:mysql://localhost:3306/foodappdb";
	private String nm = "root";
	private String pass = "root";
	private Connection con;

	private PreparedStatement pstmt;

	private int status;
	private Statement stmt;
	private ResultSet resultSet;
	private User u;
	
	public UserDAOImpl()
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, nm, pass);
			
		} catch (Exception e) {

		e.printStackTrace();
		}
	}
	
	@Override
	public int insert(User u) {
		
		try {
			
			pstmt = con.prepareStatement(INSERT_QUERY);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3, u.getPassword());
			pstmt.setString(4, u.getMobile());
			pstmt.setString(5, u.getAddress());
			status = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	@Override
	public List<User> fetchAll() {

		try {
			
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(FETCH_ALL_QUERY);
			extractUserListFromResultSet(resultSet);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
		
	}
	
	List<User> extractUserListFromResultSet(ResultSet resultSet)
	{
		try {
			
			while(resultSet.next())
			{
				userList.add(new User(resultSet.getInt("uId"),
						Decrypt.decrypt(resultSet.getString("userName")),
						Decrypt.decrypt(resultSet.getString("email")),
						Decrypt.decrypt(resultSet.getString("password")),
						Decrypt.decrypt(resultSet.getString("mobile")),
						Decrypt.decrypt(resultSet.getString("address"))));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	@Override
	public User fetchSpecific(String email) {

		try {
			
			pstmt = con.prepareStatement(FETCH_SPECIFIC_QUERY);
			pstmt.setString(1, Encrypt.encrypt(email));
			resultSet = pstmt.executeQuery();
			while(resultSet.next())
			{
				u = new User(resultSet.getInt("uId"),
						Decrypt.decrypt(resultSet.getString("userName")),
						Decrypt.decrypt(resultSet.getString("email")),
						Decrypt.decrypt(resultSet.getString("password")),
						Decrypt.decrypt(resultSet.getString("mobile")),
						Decrypt.decrypt(resultSet.getString("address")));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
		
	}

	@Override
	public int updateUser(User u) {

		try {
			
			pstmt = con.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1, u.getEmail());
			pstmt.setInt(2, u.getUid());
			status = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	@Override
	public int deleteUser(String email) {

		try {
			
			pstmt = con.prepareStatement(DELETE_QUERY);
			pstmt.setString(1,email);
			status = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
		
	}

}
