package com.cg.opna.service;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.opna.entity.Address;
import com.cg.opna.entity.Customer;
import com.cg.opna.entity.Role;
import com.cg.opna.exceptions.UserNotFoundException;
import com.cg.opna.repository.ICustomerRepository;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class CustomerTest {

	@Mock
	ICustomerRepository customerRepositoryMock;

	@InjectMocks
	CustomerServiceImpl customerServiceMock;
	
	 Customer c1, c2, c3;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		c1 = new Customer(1, "saipalli@gmail.com", "Saipalli@123", Role.CUSTOMER, "Sai palli", "9900123123",
				new Address("2-31", "Sai nagar", "Ongole", "Andhra Pradesh", 523279));

		c2 = new Customer(2, "reshmi@gmail.com", "Reshmi@123", Role.CUSTOMER, "Reshmi", "9000123123",
				new Address("3-21", "sarathnagar", "kondepi", "Andhra Pradesh", 523276));

		c3 = new Customer(3, "prachi@gmail.com", "prachi@123", Role.CUSTOMER, "Prachi", "8900123123",
				new Address("3-22", "Jogipet", "Sangareddy", "Telangana", 532456));
	}

	@AfterEach
	void tearDown() throws Exception {
	}



	@Test
	public void deleteCustomerTest() {

		when(customerRepositoryMock.findById(2)).thenReturn(Optional.of(c2));
		assertEquals("kondepi", customerServiceMock.deleteCustomer(2).getAddress().getCity());

		Exception exception = assertThrows(UserNotFoundException.class, () -> customerServiceMock.deleteCustomer(12));
		assertTrue(exception.getMessage().contains("There are no customer having id:12"));

	}

	@Test
	public void getCustomerTest() {

		when(customerRepositoryMock.findById(2)).thenReturn(Optional.of(c2));
		assertEquals("Reshmi", customerServiceMock.getCustomer(2).getName());

		Exception exception = assertThrows(UserNotFoundException.class, () -> customerServiceMock.getCustomer(11));
		assertTrue(exception.getMessage().contains("There are no customer having id:11"));

	}

	@Test
	public void getCustomersTest() {
		List<Customer> customers = new ArrayList<>();
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);

		when(customerRepositoryMock.findAll()).thenReturn(customers);
		assertEquals(3, customerServiceMock.getCustomers().size());

	}

	
}