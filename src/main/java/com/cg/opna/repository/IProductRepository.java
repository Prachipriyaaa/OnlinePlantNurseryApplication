package com.cg.opna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.opna.entity.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

}
