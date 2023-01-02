package com.cg.opna.service;

import java.util.List;
import java.util.Map;

import com.cg.opna.entity.BloomTime;
import com.cg.opna.entity.Difficulty;
import com.cg.opna.entity.Seed;
import com.cg.opna.entity.Type;
import com.cg.opna.exceptions.OutOfStockException;
import com.cg.opna.exceptions.SeedIdNotFoundException;


public interface ISeedService {
	
	Seed addSeed(Seed seed);
	Seed updateSeed(Seed seed) throws SeedIdNotFoundException;
	Seed deleteSeed(Seed seed) throws SeedIdNotFoundException;
	Seed getSeed(int id) throws SeedIdNotFoundException;
	Seed getSeed(String commonName) throws SeedIdNotFoundException;
	List<Seed> getSeeds();
	List<Seed> getSeeds(String type);
	Seed addStock(String commonName, int stock) throws SeedIdNotFoundException;
	Seed buySeeds(String commonName,int stock) throws SeedIdNotFoundException, OutOfStockException;
	List<Seed> costLowToHigh();
	List<Seed> costHighToLow();
	List<Seed> filterSeedByType(Type type);
	Seed buySeeds(int id, int stock);
	Seed updateSeed(int id, Map<Object, Object> fields);
	List<Seed> filterSeedByDifficulty(Difficulty difficultyLevel);
	Seed deleteSeedById(int id) throws SeedIdNotFoundException;
	List<Seed> filterSeedByBloomTime(BloomTime bloomTime);
	
	
}