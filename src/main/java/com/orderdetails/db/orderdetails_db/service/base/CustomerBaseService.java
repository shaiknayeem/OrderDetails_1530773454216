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

import com.orderdetails.db.orderdetails_db.entity.Customer;
import com.orderdetails.db.orderdetails_db.service.CustomerService;

//IMPORT RELATIONS
import com.orderdetails.db.orderdetails_db.entity.Order;

@Service
public class CustomerBaseService {

	private static NamedParameterJdbcTemplate jdbcTemplate;
	
		@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	


    //CRUD METHODS
    
    	
        //CRUD - CREATE
    	
	public Customer insert(Customer obj) {
		Long id = jdbcTemplate.queryForObject("select max(_id) from `customer`", new MapSqlParameterSource(), Long.class);
		obj.set_id(id == null ? 1 : id + 1);
		String sql = "INSERT INTO `customer` (`_id`, `Contact`,`mail`,`name`,`password`,`surname`,`username`,`Orders`) VALUES (:id,:Contact,:mail,:name,:password,:surname,:username, :Orders )";
			SqlParameterSource parameters = new MapSqlParameterSource()
		    .addValue("id", obj.get_id())
			.addValue("Contact", obj.getContact())
			.addValue("mail", obj.getMail())
			.addValue("name", obj.getName())
			.addValue("password", obj.getPassword())
			.addValue("surname", obj.getSurname())
			.addValue("username", obj.getUsername())
			.addValue("Orders", obj.getOrders());
		
		jdbcTemplate.update(sql, parameters);
		return obj;
	}
	
    	
    //CRUD - REMOVE
    
	public void delete(Long id) {
		String sql = "DELETE FROM `Customer` WHERE `_id`=:id";
		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
		
		jdbcTemplate.update(sql, parameters);
	}

    	
    //CRUD - GET ONE
    	
	public Customer get(Long id) {
	    
		String sql = "select * from `Customer` where `_id` = :id";
		
	    SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
	    
	    return (Customer) jdbcTemplate.queryForObject(sql, parameters, new BeanPropertyRowMapper(Customer.class));
	}


    	
        	
    //CRUD - GET LIST
    	
	public List<Customer> getList() {
	    
		String sql = "select * from `Customer`";
		
	    SqlParameterSource parameters = new MapSqlParameterSource();
	    return jdbcTemplate.query(sql, parameters, new BeanPropertyRowMapper(Customer.class));
	    
	    
	}

    	
    //CRUD - EDIT
    	
	public Customer update(Customer obj, Long id) {

		String sql = "UPDATE `Customer` SET `Contact` = :Contact,`mail` = :mail,`name` = :name,`password` = :password,`surname` = :surname,`username` = :username , `Orders` = :Orders  WHERE `_id`=:id";
		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id)
			.addValue("Contact", obj.getContact())
			.addValue("mail", obj.getMail())
			.addValue("name", obj.getName())
			.addValue("password", obj.getPassword())
			.addValue("surname", obj.getSurname())
			.addValue("username", obj.getUsername())
			.addValue("Orders", obj.getOrders());
		jdbcTemplate.update(sql, parameters);
	    return obj;
	}
	
    	
    
    
    
    

    
    /*
     * CUSTOM SERVICES
     * 
     *	These services will be overwritten and implemented in CustomerService.java
     */
    
    
    /*
    
    YOU CAN COPY AND MODIFY THIS METHOD IN CustomerService.java
    
    Name: changePassword
    Description: Change password of user from admin
    Params: 
    */
	public Object changePassword () {
		
        return null;
        
	}
	
	

}
