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

import com.orderdetails.db.orderdetails_db.entity.Item;
import com.orderdetails.db.orderdetails_db.service.ItemService;

//IMPORT RELATIONS
import com.orderdetails.db.orderdetails_db.entity.Item;

@Service
public class ItemBaseService {

	private static NamedParameterJdbcTemplate jdbcTemplate;
	
		@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	


    //CRUD METHODS
    
    //CRUD - CREATE
    	
	public Item insert(Item obj) {
		Long id = jdbcTemplate.queryForObject("select max(_id) from `item`", new MapSqlParameterSource(), Long.class);
		obj.set_id(id == null ? 1 : id + 1);
		String sql = "INSERT INTO `item` (`_id`, `Description`,`Name`,`Price`) VALUES (:id,:Description,:Name,:Price)";
			SqlParameterSource parameters = new MapSqlParameterSource()
		    .addValue("id", obj.get_id())
			.addValue("Description", obj.getDescription())
			.addValue("Name", obj.getName())
			.addValue("Price", obj.getPrice());
		
		jdbcTemplate.update(sql, parameters);
		return obj;
	}
	
    	
    //CRUD - REMOVE
    
	public void delete(Long id) {
		String sql = "DELETE FROM `Item` WHERE `_id`=:id";
		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
		
		jdbcTemplate.update(sql, parameters);
	}

    	
    //CRUD - GET ONE
    	
	public Item get(Long id) {
	    
		String sql = "select * from `Item` where `_id` = :id";
		
	    SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
	    
	    return (Item) jdbcTemplate.queryForObject(sql, parameters, new BeanPropertyRowMapper(Item.class));
	}


    	
        	
    //CRUD - GET LIST
    	
	public List<Item> getList() {
	    
		String sql = "select * from `Item`";
		
	    SqlParameterSource parameters = new MapSqlParameterSource();
	    return jdbcTemplate.query(sql, parameters, new BeanPropertyRowMapper(Item.class));
	    
	    
	}

    	
    //CRUD - EDIT
    	
	public Item update(Item obj, Long id) {

		String sql = "UPDATE `Item` SET `Description` = :Description,`Name` = :Name,`Price` = :Price  WHERE `_id`=:id";
		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id)
			.addValue("Description", obj.getDescription())
			.addValue("Name", obj.getName())
			.addValue("Price", obj.getPrice());
		jdbcTemplate.update(sql, parameters);
	    return obj;
	}
	
    	
    
    
    
    

    
    /*
     * CUSTOM SERVICES
     * 
     *	These services will be overwritten and implemented in ItemService.java
     */
    

}
