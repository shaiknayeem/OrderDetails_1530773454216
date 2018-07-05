package com.orderdetails.controller.base;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import org.springframework.security.access.annotation.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import com.orderdetails.db.orderdetails_db.service.CustomerService;
import com.orderdetails.db.orderdetails_db.entity.Customer;

//IMPORT RELATIONS
import com.orderdetails.db.orderdetails_db.entity.Order;

public class CustomerBaseController {
    
    @Autowired
	CustomerService customerService;



//CRUD METHODS


    //CRUD - CREATE
    @Secured({ "ROLE_PRIVATE_USER" })
		@RequestMapping(value = "/Users", method = RequestMethod.POST, headers = "Accept=application/json")
	public Customer insert(@RequestBody Customer obj) {
		Customer result = customerService.insert(obj);

	    
		
		return result;
	}

	
    //CRUD - REMOVE
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/Users/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void delete(@PathVariable("id") Long id) {
		customerService.delete(id);
	}
	
	
    //CRUD - GET ONE
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/Users/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Customer get(@PathVariable Long id) {
		Customer obj = customerService.get(id);
		
		
		
		return obj;
	}
	
	
    //CRUD - GET LIST
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/Users", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Customer> getList() {
		return customerService.getList();
	}
	
	

    //CRUD - EDIT
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/Users/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
	public Customer update(@RequestBody Customer obj, @PathVariable("id") Long id) {
		Customer result = customerService.update(obj, id);

	    
		
		return result;
	}
	


/*
 * CUSTOM SERVICES
 * 
 *	These services will be overwritten and implemented in  Custom.js
 */


    /*
    Name: changePassword
    Description: Change password of user from admin
    Params: 
    
    
    @RequestMapping(value = "/Users/{id}/changePassword", method = RequestMethod.POST, headers = "Accept=application/json")
    public Object changePassword() {
		return new HashMap<String, String>();
    }
    */
    		

	
}
