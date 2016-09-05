package com.eshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.eshop.model.User;

public class UserDB {

	static final String DRIVER = "com.mysql.jdbc.Driver";
	static final String URL = "jdbc:mysql://localhost:3306/";  
	static final String DB_NAME = "eshop";  
	static final String USERNAME = "root";  
	static final String PASSWORD = "010101";

	public static void insert(User user) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager  
					.getConnection(URL + DB_NAME, USERNAME, PASSWORD);
			String query
			= "INSERT INTO User (FirstName, LastName, Email, "
					+ "Address, PhoneNumber) "
					+ "VALUES (?, ?, ?, ?, ?)";

			ps = conn.prepareStatement(query);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getAddress());
			ps.setString(5, user.getPhoneNumber());        
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
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

	//    public static void update(User user) {
	//        
	//        Connection connection = pool.getConnection();
	//        PreparedStatement ps = null;
	//        ResultSet rs = null;
	//
	//        String query = "UPDATE User SET "
	//                + "FirstName = ?, "
	//                + "LastName = ?, "
	//                + "CompanyName = ?, "
	//                + "Address1 = ?, "
	//                + "Address2 = ?, "
	//                + "City = ?, "
	//                + "State = ?, "
	//                + "Zip = ?, "
	//                + "Country = ?, "
	//                + "CreditCardType = ?, "
	//                + "CreditCardNumber = ?, "
	//                + "CreditCardExpirationDate = ? "
	//                + "WHERE Email = ?";
	//        try {
	//            ps = connection.prepareStatement(query);
	//            ps.setString(1, user.getFirstName());
	//            ps.setString(2, user.getLastName());
	//            ps.setString(3, user.getCompanyName());
	//            ps.setString(4, user.getAddress1());
	//            ps.setString(5, user.getAddress2());
	//            ps.setString(6, user.getCity());
	//            ps.setString(7, user.getState());
	//            ps.setString(8, user.getZip());
	//            ps.setString(9, user.getCountry());
	//            ps.setString(10, user.getCreditCardType());
	//            ps.setString(11, user.getCreditCardNumber());
	//            ps.setString(12, user.getCreditCardExpirationDate());
	//            ps.setString(13, user.getEmail());
	//
	//            ps.executeUpdate();
	//        } catch (SQLException e) {
	//            System.err.println(e);
	//        } finally {
	//            DBUtil.closeResultSet(rs);
	//            DBUtil.closePreparedStatement(ps);
	//           pool.freeConnection(connection);
	//        }
	//    }
	//
	//    public static User selectUser(String email) {
	//        ConnectionPool pool = ConnectionPool.getInstance();
	//        Connection connection = pool.getConnection();
	//        PreparedStatement ps = null;
	//        ResultSet rs = null;
	//
	//        String query = "SELECT * FROM User "
	//                + "WHERE Email = ?";
	//        try {
	//            ps = connection.prepareStatement(query);
	//            ps.setString(1, email);
	//            rs = ps.executeQuery();
	//            User user = null;
	//            if (rs.next()) {
	//                user = new User();
	//                user.setId(rs.getLong("UserID"));
	//                user.setFirstName(rs.getString("FirstName"));
	//                user.setLastName(rs.getString("LastName"));
	//                user.setEmail(rs.getString("Email"));
	//                user.setCompanyName(rs.getString("CompanyName"));
	//                user.setAddress1(rs.getString("Address1"));
	//                user.setAddress2(rs.getString("Address2"));
	//                user.setCity(rs.getString("City"));
	//                user.setState(rs.getString("State"));
	//                user.setZip(rs.getString("Zip"));
	//                user.setCountry(rs.getString("Country"));
	//                user.setCreditCardType(rs.getString("CreditCardType"));
	//                user.setCreditCardNumber(rs.getString("CreditCardNumber"));
	//                user.setCreditCardExpirationDate(rs.getString("CreditCardExpirationDate"));
	//            }
	//            return user;
	//        } catch (Exception e) {
	//            System.err.println(e);
	//            return null;
	//        } finally {
	//           
	//        }
	//    }

}    
