package com.orderdetails.controller.base;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import org.springframework.security.access.annotation.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import com.orderdetails.db.orderdetails_db.service.ItemService;
import com.orderdetails.db.orderdetails_db.entity.Item;

//IMPORT RELATIONS
import com.orderdetails.db.orderdetails_db.entity.Item;

public class ItemBaseController {
    
    @Autowired
	ItemService itemService;



//CRUD METHODS


    //CRUD - CREATE
    @Secured({ "ROLE_PRIVATE_USER" })
		@RequestMapping(value = "/items", method = RequestMethod.POST, headers = "Accept=application/json")
	public Item insert(@RequestBody Item obj) {
		Item result = itemService.insert(obj);

	    
		
		return result;
	}

	
    //CRUD - REMOVE
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/items/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void delete(@PathVariable("id") Long id) {
		itemService.delete(id);
	}
	
	
    //CRUD - GET ONE
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/items/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Item get(@PathVariable Long id) {
		Item obj = itemService.get(id);
		
		
		
		return obj;
	}
	
	
    //CRUD - GET LIST
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/items", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Item> getList() {
		return itemService.getList();
	}
	
	

    //CRUD - EDIT
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/items/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
	public Item update(@RequestBody Item obj, @PathVariable("id") Long id) {
		Item result = itemService.update(obj, id);

	    
		
		return result;
	}
	


/*
 * CUSTOM SERVICES
 * 
 *	These services will be overwritten and implemented in  Custom.js
 */


	
}
