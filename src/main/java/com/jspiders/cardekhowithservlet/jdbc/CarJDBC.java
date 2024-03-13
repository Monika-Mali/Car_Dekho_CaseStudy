package com.jspiders.cardekhowithservlet.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspiders.cardekhowithservlet.object.Car;

public class CarJDBC {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;
	
	private static void closeConnection() throws SQLException {
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null) {
			connection.close();
		}
		if (resultSet != null) {
			resultSet.close();
		}
	}

	private static void openConnection() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4", "root", "root");
	}

	public static int addCar(int id, String name, String color, double price) {
		int res=0;
		
		try {
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			openConnection();
			query = "insert into car values(?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, color);
			preparedStatement.setDouble(4, price);
			
		    res = preparedStatement.executeUpdate();		
			System.out.println(res + "row(s) affected");
			
			closeConnection();
			
			DriverManager.deregisterDriver(driver);
		} catch (Exception e) {
			
		}
		return res;
	}

	public static int deleteCar(String name) {

		int res=0;
		try {
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			openConnection();
			query = "delete from car where name = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			
		    res = preparedStatement.executeUpdate();		
			System.out.println(res + "row(s) deleted");
			
			closeConnection();
			DriverManager.deregisterDriver(driver);
		} catch (Exception e) {
			
		}
		return res;
		
	}
	
	public static int updateCar(String oldName , String newName) {

		int res=0;
		try {
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			openConnection();
			query = "update car set name= ? where name =?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, newName);
			preparedStatement.setString(2, oldName);
		    res = preparedStatement.executeUpdate();		
			System.out.println(res + "row(s) updated");
			
			closeConnection();
			DriverManager.deregisterDriver(driver);
		} catch (Exception e) {
			
		}
		return res;
		
	}
	public static List<Car> searchAllCars() {
		List<Car> cars = new ArrayList<Car>();
		try {
			openConnection();
			query="Select * from car";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Car car =  new Car();
				car.setId(resultSet.getInt(1));
				car.setName(resultSet.getString(2));
				car.setColor(resultSet.getString(3));
				car.setPrice(resultSet.getDouble(4));
				cars.add(car);
				
			}
			closeConnection();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return cars;
		
	}
	
	
	
	

}
