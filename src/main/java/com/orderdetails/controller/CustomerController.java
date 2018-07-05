package com.orderdetails.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.annotation.PropertySource;

import com.orderdetails.controller.base.CustomerBaseController;

@RestController
@PropertySource("classpath:${configfile.path}/OrderDetails.properties")
@RequestMapping(value="${endpoint.api}", headers = "Accept=application/json")
public class CustomerController extends CustomerBaseController {

	//OVERRIDE HERE YOUR CUSTOM CONTROLLER

}
