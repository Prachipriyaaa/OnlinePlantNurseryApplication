package com.cg.opna.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.opna.entity.Order;
import com.cg.opna.entity.TransactionMode;
import com.cg.opna.service.IOrderService;

@RestController
public class OrderController{
	
	@Autowired
	private IOrderService orderService;
	
	@PostMapping("/customers/order")
	public ResponseEntity<Order> addOrder(@Valid @RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.addOrder(order), HttpStatus.CREATED);
	}
	
	@PutMapping("/customers/order")
	public ResponseEntity<Order> update(@Valid @RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.patchOrder(order), HttpStatus.OK);
	}
	
	@DeleteMapping("/customers/order/id/{id}")
	public ResponseEntity<String> delete(@PathVariable int id)  {
		orderService.deleteOrder(id);
		return new ResponseEntity<String>("The order with id " + id + " got deleted.", HttpStatus.OK);
	}
	
	@GetMapping("/customers/order/id/{id}")
	public ResponseEntity<Order> viewOrder(@PathVariable int id) {
		return new ResponseEntity<Order>(orderService.viewOrder(id), HttpStatus.OK);
	}
	
	@GetMapping("/customers/orders")
	public ResponseEntity<List<Order>> getAllOrders(){
		return new ResponseEntity<List<Order>>(orderService.viewAllOrders(), HttpStatus.OK);
	}
}