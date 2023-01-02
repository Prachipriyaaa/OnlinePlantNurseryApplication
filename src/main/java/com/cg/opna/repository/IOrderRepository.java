package com.cg.opna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.opna.entity.Order;

@Repository
public interface IOrderRepository  extends JpaRepository<Order, Integer> {
	

}