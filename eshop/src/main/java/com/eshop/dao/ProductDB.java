package com.eshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eshop.model.Product;

public class ProductDB {

	static final String DRIVER = "com.mysql.jdbc.Driver";
	static final String URL = "jdbc:mysql://localhost:3306/";  
	static final String DB_NAME = "eshop";  
	static final String USERNAME = "root";  
	static final String PASSWORD = "010101";


	public static Product selectProduct(String productCode) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager  
					.getConnection(URL + DB_NAME, USERNAME, PASSWORD);

			String query = "SELECT * FROM Product "
					+ "WHERE ProductCode = ?";

			ps = conn.prepareStatement(query);
			ps.setString(1, productCode);
			rs = ps.executeQuery();
			if (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("ProductID"));
				p.setCode(rs.getString("ProductCode"));
				p.setDescription(rs.getString("ProductDescription"));
				p.setDetails(rs.getString("ProductDetails"));
				p.setPrice(rs.getDouble("ProductPrice"));
				return p;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.err.println(e);
			return null;
		} finally {
			if (conn != null) {  
				try {  
					conn.close();  
				} catch (SQLException e) {  
					e.printStackTrace();  
				}  
			}  
			if (ps != null) {  
				try {  
					ps.close();  
				} catch (SQLException e) {  
					e.printStackTrace();  
				}  
			}  
			if (rs != null) {  
				try {  
					rs.close();  
				} catch (SQLException e) {  
					e.printStackTrace();  
				}  
			} 
		}
	}

	//This method returns null if a product isn't found.
	public static Product selectProduct(long productID) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager  
					.getConnection(URL + DB_NAME, USERNAME, PASSWORD);
			String query = "SELECT * FROM Product "
					+ "WHERE ProductID = ?";

			ps = conn.prepareStatement(query);
			ps.setLong(1, productID);
			rs = ps.executeQuery();
			if (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("ProductID"));
				p.setCode(rs.getString("ProductCode"));
				p.setDescription(rs.getString("ProductDescription"));
				p.setDetails(rs.getString("ProductDetails"));
				p.setPrice(rs.getDouble("ProductPrice"));
				return p;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.err.println(e);
			return null;
		} finally {
			if (conn != null) {  
				try {  
					conn.close();  
				} catch (SQLException e) {  
					e.printStackTrace();  
				}  
			}  
			if (ps != null) {  
				try {  
					ps.close();  
				} catch (SQLException e) {  
					e.printStackTrace();  
				}  
			}  
			if (rs != null) {  
				try {  
					rs.close();  
				} catch (SQLException e) {  
					e.printStackTrace();  
				}  
			}
		}
	}

	//This method returns null if a product isn't found.
	public static List<Product> selectProducts() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager  
					.getConnection(URL + DB_NAME, USERNAME, PASSWORD);
			String query = "SELECT * FROM Product";

			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			ArrayList<Product> products = new ArrayList<>();
			while (rs.next()) {
				Product p = new Product();
				p.setCode(rs.getString("ProductCode"));
				p.setDescription(rs.getString("ProductDescription"));
				p.setDetails(rs.getString("ProductDetails"));
				p.setPrice(rs.getDouble("ProductPrice"));
				products.add(p);
			}
			return products;
		} catch (Exception e) {
			System.err.println(e);
			return null;
		} finally {
			if (conn != null) {  
				try {  
					conn.close();  
				} catch (SQLException e) {  
					e.printStackTrace();  
				}  
			}  
			if (ps != null) {  
				try {  
					ps.close();  
				} catch (SQLException e) {  
					e.printStackTrace();  
				}  
			}  
			if (rs != null) {  
				try {  
					rs.close();  
				} catch (SQLException e) {  
					e.printStackTrace();  
				}  
			}
		}
	}
}