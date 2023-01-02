package com.cg.opna.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.opna.entity.Customer;
import com.cg.opna.entity.Order;
import com.cg.opna.exceptions.ResourceNotFoundException;
import com.cg.opna.exceptions.UserNotFoundException;


@Service
public interface ICustomerService {
		
	
	Customer deleteCustomer(int customerId) throws UserNotFoundException;
	Customer getCustomer(int customerId) throws UserNotFoundException;
	List<Customer> getCustomers() throws UserNotFoundException;
	List<Order> getOrders(Integer id) throws UserNotFoundException,ResourceNotFoundException;
	Order getOrderDetails(Integer customerId, Integer orderId)throws UserNotFoundException,ResourceNotFoundException;
	
	
	
}