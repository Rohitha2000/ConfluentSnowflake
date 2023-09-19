package com.snow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.snow.model.CustomerModel;
import com.snow.service.CustomerService;



@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	  @PostMapping(value = "/save")
	    public ResponseEntity<?> sendCustomerDetails(@RequestBody CustomerModel customerdata){
		 
	      // Method to send the data to kafka topic  
		  service.send(customerdata);
	        return ResponseEntity.ok("Customer Data sent successfully " + customerdata.getCustomername());
	    }

}
