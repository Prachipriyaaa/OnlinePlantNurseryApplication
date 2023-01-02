package com.cg.opna.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.opna.entity.Order;
import com.cg.opna.exceptions.OrderIdNotFoundException;
import com.cg.opna.repository.IOrderRepository;
import com.cg.opna.repository.IPlantRepository;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

	@Autowired
	IOrderRepository orderRepository;

	@Autowired
	IPlantService plantService;

	@Autowired
	IPlantRepository plantRepository;

	@Autowired
	IPlanterService planterService;

	@Autowired
	ISeedService seedService;

	@Autowired
	IProductService productService;

	@Override
	public Order addOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order patchOrder(Order order) {
		Optional<Order> orderToBePatched = orderRepository.findById(order.getBookingId());
		if (orderToBePatched.isPresent() && order.getTransactionMode() != null) {
			orderToBePatched.get().setTransactionMode(order.getTransactionMode());
			orderRepository.save(orderToBePatched.get());
		}
		return orderToBePatched.orElseThrow(
				() -> new OrderIdNotFoundException("Order with id: " + order.getBookingId() + " is not found"));
	}

	@Override
	public Order deleteOrder(int bookingId) {
		Optional<Order> orderToBeRemoved = orderRepository.findById(bookingId);
		orderRepository.deleteById(bookingId);
		return orderToBeRemoved
				.orElseThrow(() -> new OrderIdNotFoundException("Order with id: " + bookingId + " is not found"));
	}

	@Override
	public Order viewOrder(int bookingId) {
		Optional<Order> orderOptional = orderRepository.findById(bookingId);
		return orderOptional
				.orElseThrow(() -> new OrderIdNotFoundException("Order with id: " + bookingId + " is not found"));
	}

	@Override
	public List<Order> viewAllOrders() {
		return orderRepository.findAll();
	}

}