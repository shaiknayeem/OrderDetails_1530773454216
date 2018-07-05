package com.orderdetails.db.orderdetails_db.service.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.orderdetails.db.orderdetails_db.entity.Order;
import com.orderdetails.db.orderdetails_db.service.OrderService;

//IMPORT RELATIONS
import com.orderdetails.db.orderdetails_db.entity.Item;
import com.orderdetails.db.orderdetails_db.entity.Order;

@Service
public class OrderBaseService {

	private static NamedParameterJdbcTemplate jdbcTemplate;
	
		@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	


    //CRUD METHODS
    
    //CRUD - CREATE
    	
	public Order insert(Order obj) {
		Long id = jdbcTemplate.queryForObject("select max(_id) from `order`", new MapSqlParameterSource(), Long.class);
		obj.set_id(id == null ? 1 : id + 1);
		String sql = "INSERT INTO `order` (`_id`, `OrderDate`,`OrderTotal`,`Qty`,`Items`) VALUES (:id,:OrderDate,:OrderTotal,:Qty, :Items )";
			SqlParameterSource parameters = new MapSqlParameterSource()
		    .addValue("id", obj.get_id())
			.addValue("OrderDate", obj.getOrderDate())
			.addValue("OrderTotal", obj.getOrderTotal())
			.addValue("Qty", obj.getQty())
			.addValue("Items", obj.getItems());
		
		jdbcTemplate.update(sql, parameters);
		return obj;
	}
	
    	
    //CRUD - REMOVE
    
	public void delete(Long id) {
		String sql = "DELETE FROM `Order` WHERE `_id`=:id";
		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
		
		jdbcTemplate.update(sql, parameters);
	}

    	
    //CRUD - FIND BY Items
    	
	public List<Order> findByItems(Long idItems) {
		
		String sql = "select * from `Order` WHERE `Items` = :idItems";
		
	    SqlParameterSource parameters = new MapSqlParameterSource()
		.addValue("idItems", idItems);
	    
	    return jdbcTemplate.query(sql, parameters, new BeanPropertyRowMapper(Order.class));
	}
    	
    //CRUD - GET ONE
    	
	public Order get(Long id) {
	    
		String sql = "select * from `Order` where `_id` = :id";
		
	    SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
	    
	    return (Order) jdbcTemplate.queryForObject(sql, parameters, new BeanPropertyRowMapper(Order.class));
	}


    	
        	
    //CRUD - GET LIST
    	
	public List<Order> getList() {
	    
		String sql = "select * from `Order`";
		
	    SqlParameterSource parameters = new MapSqlParameterSource();
	    return jdbcTemplate.query(sql, parameters, new BeanPropertyRowMapper(Order.class));
	    
	    
	}

    	
    //CRUD - EDIT
    	
	public Order update(Order obj, Long id) {

		String sql = "UPDATE `Order` SET `OrderDate` = :OrderDate,`OrderTotal` = :OrderTotal,`Qty` = :Qty , `Items` = :Items  WHERE `_id`=:id";
		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id)
			.addValue("OrderDate", obj.getOrderDate())
			.addValue("OrderTotal", obj.getOrderTotal())
			.addValue("Qty", obj.getQty())
			.addValue("Items", obj.getItems());
		jdbcTemplate.update(sql, parameters);
	    return obj;
	}
	
    	
    
    
    
        
    

    
    /*
     * CUSTOM SERVICES
     * 
     *	These services will be overwritten and implemented in OrderService.java
     */
    

}
