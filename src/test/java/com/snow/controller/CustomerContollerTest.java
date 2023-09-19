package com.snow.controller;

import static org.mockito.Mockito.doNothing;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.snow.model.CustomerModel;
import com.snow.service.CustomerService;

@SpringBootTest
public class CustomerContollerTest {
	
	@InjectMocks
	private CustomerController contoller;
	
	@Mock
	private CustomerService service;
	
	
	
	@Test
	public void sendCustomerDetails() {
		CustomerModel cust= new CustomerModel();
		 cust.setCustomername("customer");
		doNothing().when(service).send(cust);
		ResponseEntity<?> response= contoller.sendCustomerDetails(cust);
		Assertions.assertEquals(response.getStatusCodeValue(), 200);
		
	}

}
