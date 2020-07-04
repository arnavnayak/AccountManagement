package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/bank/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	//add customer
	@RequestMapping(value="/add",method=RequestMethod.POST)
	ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
	{
		return new ResponseEntity<Customer>(customerService.addCustomer(customer),HttpStatus.CREATED); 
	}
	
	//view customer
	@RequestMapping(value="/view",method=RequestMethod.GET)
	ResponseEntity<ArrayList<Customer>> viewCustomer()
	{
		return new ResponseEntity<ArrayList<Customer>>(customerService.viewCustomer(),HttpStatus.OK); 
	}
	
	//view customer by id
	@RequestMapping(value="/view/id",method=RequestMethod.GET)
	ResponseEntity<Customer> viewCustomerById(@RequestParam("id") long customerId)
	{
		return new ResponseEntity<Customer>(customerService.viewCustomerById(customerId),HttpStatus.OK); 
	}
	//update customer
	@RequestMapping(value="/edit",method=RequestMethod.PUT)
	ResponseEntity<Customer> editCustomer(@RequestBody Customer customer)
	{
		return new ResponseEntity<Customer>(customerService.editCustomer(customer),HttpStatus.OK); 
	}
	
	//delete customer by id
	@RequestMapping(value="/delete/id",method=RequestMethod.DELETE)
	ResponseEntity<Boolean> deleteCustomer(@RequestParam("id") long customerId)
	{
		return new ResponseEntity<Boolean>(customerService.deleteCustomer(customerId),HttpStatus.OK); 
	}
}
