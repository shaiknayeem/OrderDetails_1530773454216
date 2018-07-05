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
 *  FOR CUSTOMIZE OrderBase PLEASE EDIT ../Order.java
 * 
 *  -- THIS FILE WILL BE OVERWRITTEN ON THE NEXT SKAFFOLDER CODE GENERATION --
 * 
 */
 

/**
 * This is the model of Order object
 * 
 */
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;
import com.orderdetails.db.orderdetails_db.entity.Order;

public class OrderBase implements RowMapper<Order>{
	
	private Long _id;
	
	// Attributes
    private Date OrderDate;
    private Number OrderTotal;
    private Number Qty;
	
	// Relations Items
	private String Items;
	
	
	
	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Order obj = new Order();
		try {
			obj.set_id(rs.getLong("id"));
			obj.setOrderDate(rs.getDate("OrderDate"));
			obj.setOrderTotal(rs.getBigDecimal("OrderTotal"));
			obj.setQty(rs.getBigDecimal("Qty"));
			
        	
        	// Relations 1:m Items
			obj.setItems(rs.getString("Items"));
        	
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
	
	public Date getOrderDate() {
		return OrderDate;
	}


	public void setOrderDate(Date OrderDate) {
		this.OrderDate = OrderDate;
	}
	public Number getOrderTotal() {
		return OrderTotal;
	}


	public void setOrderTotal(Number OrderTotal) {
		this.OrderTotal = OrderTotal;
	}
	public Number getQty() {
		return Qty;
	}


	public void setQty(Number Qty) {
		this.Qty = Qty;
	}
	
    
    // Relations 1:m Items
	public String getItems() {
		return Items;
	}

	public void setItems(String Items) {
		this.Items = Items;
	}
    
    
    
    
}