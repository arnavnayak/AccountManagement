package com.example.demo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public Customer addCustomer(Customer customer) {
	
		Customer customers=customerRepository.save(customer);
		return customers;
	}

	public ArrayList<Customer> viewCustomer() {
		ArrayList<Customer> customerList=(ArrayList<Customer>) customerRepository.findAll();
		return customerList;
	}

	public Customer viewCustomerById(long customerId) {
		Optional customer=customerRepository.findById(customerId);
		if(customer!=null)
		{
			return (Customer) customer.get();
		}
		return null;
	}

	public Customer editCustomer(Customer customer) {
		
		Customer customers=customerRepository.save(customer);
		if(customers!=null)
		{
			return customers;
		}
		return null;
	}

	public Boolean deleteCustomer(long customerId) {
	
		Optional<Customer> customersId=customerRepository.findById(customerId);
		if(customersId.isPresent())
		{
			customerRepository.deleteById(customerId);
			return true;
		}
		return false;
	}

}
