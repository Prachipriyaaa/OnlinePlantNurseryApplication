package com.cg.opna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.opna.entity.Plant;
import com.cg.opna.entity.Planter;
import com.cg.opna.entity.Product;
import com.cg.opna.entity.Seed;
import com.cg.opna.entity.Type;
import com.cg.opna.service.IProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	IProductService productService;	
	
	@PostMapping("admin/plantertype")
	public ResponseEntity<Product> addProduct(@RequestBody Planter planter) {
		Product product =  productService.addProduct(planter);
			return new ResponseEntity<Product>(product,HttpStatus.CREATED);
	}
	
	@PostMapping("admin/planttype")
	public ResponseEntity<Product> addProduct(@RequestBody Plant plant) {
		Product product =  productService.addProduct(plant);
			return new ResponseEntity<Product>(product,HttpStatus.CREATED);
	}
	
	@PostMapping("admin/seedtype")
	public ResponseEntity<Product> addProduct(@RequestBody Seed seed) {
		Product product =  productService.addProduct(seed);
			return new ResponseEntity<Product>(product,HttpStatus.CREATED);
	}
	
	@GetMapping({"admin/products", "customers/products"})
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> products =  productService.getProducts();
			return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	


}
