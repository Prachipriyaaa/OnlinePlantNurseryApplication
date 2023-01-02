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
import org.springframework.web.bind.annotation.RestController;

import com.cg.opna.entity.Plant;
import com.cg.opna.exceptions.PlantIdNotFoundException;
import com.cg.opna.service.IPlantService;


@RestController
@RequestMapping("/products")
public class PlantController {	

	@Autowired
	private IPlantService plantService;

	@PostMapping("/admin/plant") //we're taking input from user and only admin can perform this operation
	public ResponseEntity<Plant> addNewPlant(@Valid @RequestBody Plant plant) {
		plantService.addNewPlant(plant);
		return new ResponseEntity<Plant>(plant, HttpStatus.CREATED);
	}
	
	@PutMapping({"/admin/plant/id/{id}"})
	public ResponseEntity<Plant> updatePlant(@Valid @RequestBody Plant plant, @PathVariable int id) {
		 
		plantService.updatePlant(plant, id);
		return new ResponseEntity<Plant>(plant, HttpStatus.ACCEPTED);
	}
	

	@DeleteMapping("/admin/plant/id/{id}")
	public ResponseEntity<Plant> deletePlant(@PathVariable int id) throws PlantIdNotFoundException{
		return new ResponseEntity<Plant>(plantService.deletePlant(id), HttpStatus.OK);
	}

	@GetMapping({"/admin/plant/id/{id}", "/customers/plant/id/{id}"})
	public ResponseEntity<Plant> viewPlant(@PathVariable Integer id) {
		
		return new ResponseEntity<Plant>(plantService.getPlant(id), HttpStatus.OK);
	}


	@GetMapping({"/admin/plants","/customers/plants"})
	public ResponseEntity<List<Plant>> viewAllPlants() {
	
		return new ResponseEntity<List<Plant>>(plantService.getAllPlants(), HttpStatus.OK);
	}

}