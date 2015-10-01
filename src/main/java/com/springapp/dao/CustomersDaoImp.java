package com.springapp.dao;

import com.heroku.sdk.jdbc.DatabaseUrl;
import com.springapp.model.Address;
import com.springapp.model.Customer;
import com.springapp.model.CustomerImpl;
import sun.security.util.Password;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomersDaoImp implements CustomersDao {

	@Override
	public Customer getCustomerById(int customerId) {
		Connection connection = null;
		CustomerImpl customer;
		try {
			connection = DatabaseUrl.extract().getConnection();
			Statement stmt = connection.createStatement();
			String query = "SELECT * FROM Customer WHERE id = " + customerId;

			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()){
				Address customerAddress = new Address(
						rs.getString("addressLine1"),
						rs.getString("addressLine2"),
						rs.getString("addressLine3"),
						rs.getString("city"),
						rs.getString("postcode"));
				//Password password = rs.getString("password");
				Password password =new Password();
			//	password = rs.getString("password");

				customer = new CustomerImpl(
						rs.getInt("id"),
						rs.getString("title"),
						rs.getString("forename"),
						rs.getString("surname"),
						customerAddress,
						rs.getString("mobileNumber"),
						rs.getString("landlineNumber"),
						rs.getString("email"),
						rs.getString("login"),
						password,
						rs.getBoolean("emailNotifications"),
						rs.getBoolean("smsNotifications"),
						rs.getBoolean("emailSpecialOffers"),
						rs.getBoolean("smsSpecialOffers"),
						rs.getBoolean("postSpecialOffers"));
			}
			else{
				customer = null;
			}

		} catch (Exception e){
			customer = null;
		}
		finally {
			if (connection != null) try{connection.close();} catch(SQLException e){}
		}

		return customer;
	}

	@Override
	public Customer createCustomer(CustomerImpl customer) {
		Connection connection = null;
		try {
			connection = DatabaseUrl.extract().getConnection();
			Statement stmt = connection.createStatement();
			String query = "INSERT INTO Customer "
 					+ "(title, forename, surname, email, addressLine1, addressLine2, addressLine3, city, "
 					+ " postcode, mobileNumber, landlineNumber, login, password, "
					+ " emailNotifications, smsNotifications, emailSpecialOffers, smsSpecialOffers, postSpecialOffers)"
					+ "VALUES ('"
					+ customer.getTitle() + "', '"
					+ customer.getForename() + "', '"
					+ customer.getSurname() + "', '"
					+ customer.getEmail() + "', '"
					+ customer.getAddress().getAddressLine1() + "', '"
					+ customer.getAddress().getAddressLine2()  + "', '"
					+ customer.getAddress().getAddressLine3()  + "', '"
					+ customer.getAddress().getCity()  + "', '"
					+ customer.getAddress().getPostcode()  + "', '"
					+ customer.getMobileNumber()  + "', '"
					+ customer.getLandlineNumber()  + "', '"
					+ customer.getLogin()  + "', '"
					+ customer.getPassword()  + "', "
					+ customer.getEmailNotification()  + ", "
					+ customer.getSmsNotification()  + ", "
					+ customer.getEmailSpecialOffers()  + ", "
					+ customer.getSmsSpecialOffers()  + ", "
					+ customer.getPostSpecialOffers()  + ") ";
			stmt.executeQuery(query);
		} catch (Exception e){
		}
		finally {
			if (connection != null) try{connection.close();} catch(SQLException e){}
		}

		return customer;
	}

	public void deleteCustomer(CustomerImpl customer) {
		Connection connection = null;
		try {
			connection = DatabaseUrl.extract().getConnection();
			Statement stmt = connection.createStatement();
			String query = "DELETE FROM Customer WHERE ID =" + customer.getCustomerId();
			stmt.executeQuery(query);
		} catch (Exception e){

		}
		finally {
			if (connection != null) try{connection.close();} catch(SQLException e){}
		}
	}

	@Override
	public Customer updateCustomer(CustomerImpl customer) {
		Connection connection = null;
		try {
			connection = DatabaseUrl.extract().getConnection();
			Statement stmt = connection.createStatement();
			String query = "UPDATE Customer SET "
					+ "title = '" + customer.getTitle() + "', '"
					+ "forename = '" + customer.getForename() + "', '"
					+ "surname = '" + customer.getSurname() + "', "
					+ "addressLine1 = '" + customer.getAddress().getAddressLine1() + "', "
					+ "addressLine2 = '" + customer.getAddress().getAddressLine2()  + "'', '"
					+ "addressLine3 = '" + customer.getAddress().getAddressLine3()  + "', '"
					+ "city = '" + customer.getAddress().getCity()  + "', '"
					+ "postcode = '" + customer.getAddress().getPostcode()  + "', '"
					+ "mobileNumber = '" + customer.getMobileNumber()  + "', '"
					+ "landlineNumber = '" + customer.getLandlineNumber()  + "', '"
					+ "login = '" + customer.getLogin()  + "', '"
					+ "password = '" + customer.getPassword()  + "', "
					+ "emailNotifications = " + customer.getEmailNotification()  + ", "
					+ "smsNotifications = " + customer.getSmsNotification()  + ", "
					+ "emailSpecialOffers = " + customer.getEmailSpecialOffers()  + ", "
					+ "smsSpecialOffers = " + customer.getSmsSpecialOffers()  + ", "
					+ "postSpecialOffers = " + customer.getPostSpecialOffers()
					+ "WHERE id =" + customer.getCustomerId();
			stmt.executeQuery(query);
		} catch (Exception e){

		}
		finally {
			if (connection != null) try{connection.close();} catch(SQLException e){}
		}

		return customer;
	}
}
