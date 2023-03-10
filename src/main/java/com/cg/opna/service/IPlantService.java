package com.cg.opna.service;

import java.util.List;
import java.util.Map;

import com.cg.opna.entity.BloomTime;
import com.cg.opna.entity.Difficulty;
import com.cg.opna.entity.Plant;



public interface IPlantService {
	Plant addNewPlant(Plant plant);
	
	Plant addPlantStock(String commonName, int stock);
	Plant updatePlant(Plant plant, int id);
	Plant partialUpdatePlant(Map<Object, Object> fields, int id);
	Plant deletePlant(int plantId);
	Plant decreaseStock(int id, int stock);
	Plant getPlant(int plantId);
	Plant getPlant(String commonName);
	List<Plant> getAllPlants();
	List<Plant> getAllPlants(String typeOfPlant);
	List<Plant> costLowToHigh();
	List<Plant> costHighToLow();
	List<Plant> filterPlantByBloomTime(BloomTime type);
	List<Plant> filterPlantByDifficulty(Difficulty difficulty);
	String getBloomingStatus(int id);
}