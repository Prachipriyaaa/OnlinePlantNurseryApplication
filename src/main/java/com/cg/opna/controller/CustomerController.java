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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.opna.entity.Customer;
import com.cg.opna.entity.Order;
import com.cg.opna.entity.Product;
import com.cg.opna.entity.User;
import com.cg.opna.repository.ICustomerRepository;
import com.cg.opna.service.ICustomerService;
import com.cg.opna.service.IProductService;
import com.cg.opna.service.IUserService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;

	@Autowired
	private IUserService userService;

	@Autowired
	IProductService productService;
	
	@Autowired
	private ICustomerRepository customerRepository;


	@PostMapping("/register")
	public ResponseEntity<User> register(@Valid @RequestBody Customer customer) {

		return new ResponseEntity<>(userService.register(customer), HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user) {

		return new ResponseEntity<String>("Welcome " + ((Customer) userService.login(user)).getName(),
				HttpStatus.ACCEPTED);
	}

	@PutMapping("/id/{id}")
	public ResponseEntity<Customer> update(@Valid @PathVariable Integer id, @RequestBody Customer customer) {

		return new ResponseEntity<Customer>((Customer)userService.updateUser(id, customer), HttpStatus.CREATED);
	}

	@DeleteMapping("/id/{id}")
	public ResponseEntity<Customer> deleteById(@PathVariable Integer id) {

		return new ResponseEntity<Customer>(customerService.deleteCustomer(id), HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {

		return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() {

		return new ResponseEntity<List<Product>>(productService.getProducts(), HttpStatus.OK);
	}

	@GetMapping("/getAllCustomers")
	public ResponseEntity<?> getAllCustomers()
	{
		return ResponseEntity.ok(customerRepository.findAll());
	}

}