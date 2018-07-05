package com.orderdetails.db.orderdetails_db.entity.base;

/**
 * 
 * 
  _____                      _              _ _ _     _   _     _        __ _ _      
 |  __ \                    | |            | (_) |   | | | |   (_)      / _(_) |     
 | |  | | ___    _ __   ___ | |_    ___  __| |_| |_  | |_| |__  _ ___  | |_ _| | ___ 
 | |  | |/ _ \  | '_ \ / _ \| __|  / _ \/ _` | | __| | __| '_ \| / __| |  _| | |/ _ \
 | |__| | (_) | | | | | (_) | |_  |  __/ (_| | | |_  | |_| | | | \__ \ | | | | |  __/
 |_____/ \___/  |_| |_|\___/ \__|  \___|\__,_|_|\__|  \__|_| |_|_|___/ |_| |_|_|\___|
 
                                                                                   
 * DO NOT EDIT THIS FILE!! 
 *
 *  FOR CUSTOMIZE CustomerBase PLEASE EDIT ../Customer.java
 * 
 *  -- THIS FILE WILL BE OVERWRITTEN ON THE NEXT SKAFFOLDER CODE GENERATION --
 * 
 */
 

/**
 * This is the model of Customer object
 * 
 */
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;
import com.orderdetails.db.orderdetails_db.entity.Customer;

public class CustomerBase implements RowMapper<Customer>{
	
	private Long _id;
	
	// Attributes
    private String Contact;
    private String mail;
    private String name;
    private String password;
    private String surname;
    private String username;
	
	// Relations Orders
	private String Orders;
	
	
	
	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Customer obj = new Customer();
		try {
			obj.set_id(rs.getLong("id"));
			obj.setContact(rs.getString("Contact"));
			obj.setMail(rs.getString("mail"));
			obj.setName(rs.getString("name"));
			obj.setPassword(rs.getString("password"));
			obj.setSurname(rs.getString("surname"));
			obj.setUsername(rs.getString("username"));
			
        	
        	// Relations 1:m Orders
			obj.setOrders(rs.getString("Orders"));
        	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public Long get_id() {
		return _id;
	}

	public void set_id(Long _id) {
		this._id = _id;
	}
	
	public String getContact() {
		return Contact;
	}


	public void setContact(String Contact) {
		this.Contact = Contact;
	}
	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}
	
    
    // Relations 1:m Orders
	public String getOrders() {
		return Orders;
	}

	public void setOrders(String Orders) {
		this.Orders = Orders;
	}
    
    
    
    
}