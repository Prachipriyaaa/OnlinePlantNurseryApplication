package com.cg.opna.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.opna.entity.Planter;
import com.cg.opna.service.IPlanterService;


@RestController
@RequestMapping("/products")
public class PlanterController {

	@Autowired
	private IPlanterService planterService;
	
	@PostMapping("admin/planter")
	public ResponseEntity<Planter> addPlanter(@Valid @RequestBody Planter planter) {
		planter =  planterService.addPlanter(planter);
			return new ResponseEntity<Planter>(planter,HttpStatus.CREATED);
	}
	
	@GetMapping({"/customers/planters","/admin/planters"})
	public ResponseEntity<List<Planter>> getAllPlanters(){
		List<Planter> planters = planterService.getPlanters();
		return new ResponseEntity<List<Planter>>(planters,HttpStatus.OK);
	}
	
	@GetMapping({"admin/planter/id/{id}", "customer/planter/id/{id}"})
	public ResponseEntity<Planter> getPlanterById(@PathVariable int id) {
		Planter planter = planterService.getPlanter(id);
		return new ResponseEntity<Planter>(planter,HttpStatus.OK); 
	}
	
	@PutMapping("admin/planter")
	public ResponseEntity<Planter> update(@RequestBody Planter planter) {
		Planter newPlanter =  planterService.updatePlanter(planter);
		return new ResponseEntity<Planter>(newPlanter,HttpStatus.OK);
	}
	
	@PatchMapping("admin/planters/id/{id}")
	public ResponseEntity<Planter> partialUpdate(@RequestBody Map<Object, Object> fields, @PathVariable int id){
		return new ResponseEntity<Planter>(planterService.partialUpdatePlanter(fields, id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "admin/deletePlanter/id/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public ResponseEntity<Planter> deleteById(@PathVariable int id) {
		Planter planter =  planterService.deletePlanterById(id);
		return new ResponseEntity<Planter>(planter,HttpStatus.OK);
		
	}
	
	@GetMapping({"admin/planters/{min}/{max}", "customers/planters/{min}/{max}"})
	public ResponseEntity<List<Planter>> getAllPlantersInRange(@PathVariable double min, @PathVariable double max ){
		List<Planter> planters = planterService.getPlanters(min, max);
		if ( planters.size() != 0)
			return new ResponseEntity <List<Planter>>(planters,HttpStatus.OK);
		return new ResponseEntity <List<Planter>>(planters,HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("admin/planters")
	public ResponseEntity<List<Planter>> deletePlanters() {
		List<Planter> planters =  planterService.deletePlanters();
		return new ResponseEntity<List<Planter>>(planters,HttpStatus.OK);
	}
	
	
	
	

}
