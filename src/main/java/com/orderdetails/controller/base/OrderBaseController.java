package com.orderdetails.controller.base;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import org.springframework.security.access.annotation.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import com.orderdetails.db.orderdetails_db.service.OrderService;
import com.orderdetails.db.orderdetails_db.entity.Order;

//IMPORT RELATIONS
import com.orderdetails.db.orderdetails_db.entity.Item;
import com.orderdetails.db.orderdetails_db.entity.Order;

public class OrderBaseController {
    
    @Autowired
	OrderService orderService;



//CRUD METHODS


    //CRUD - CREATE
    @Secured({ "ROLE_PRIVATE_USER" })
		@RequestMapping(value = "/orders", method = RequestMethod.POST, headers = "Accept=application/json")
	public Order insert(@RequestBody Order obj) {
		Order result = orderService.insert(obj);

	    
		
		return result;
	}

	
    //CRUD - REMOVE
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void delete(@PathVariable("id") Long id) {
		orderService.delete(id);
	}
	

    //CRUD - FIND BY Items
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/orders/findByItems/{key}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Order> findByItems(@PathVariable("key") Long idItems) {
		List<Order> list = orderService.findByItems(idItems);
		return list;
	}
	
    //CRUD - GET ONE
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/orders/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Order get(@PathVariable Long id) {
		Order obj = orderService.get(id);
		
		
		
		return obj;
	}
	
	
    //CRUD - GET LIST
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/orders", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Order> getList() {
		return orderService.getList();
	}
	
	

    //CRUD - EDIT
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/orders/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
	public Order update(@RequestBody Order obj, @PathVariable("id") Long id) {
		Order result = orderService.update(obj, id);

	    
		
		return result;
	}
	


/*
 * CUSTOM SERVICES
 * 
 *	These services will be overwritten and implemented in  Custom.js
 */


	
}
