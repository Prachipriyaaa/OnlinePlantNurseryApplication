package com.cg.opna.service;

import java.util.List;

import com.cg.opna.entity.Order;
import com.cg.opna.entity.TransactionMode;



public interface IOrderService {
	
	Order addOrder(Order order);
	Order deleteOrder(int bookingId);
	Order viewOrder(int bookingId);
	List<Order> viewAllOrders();
	Order patchOrder(Order order);

	
}