package com.fellipe.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fellipe.entities.Restaurant;
import com.fellipe.repos.RestRepository;

@Repository
public class RestaurantDaoImpl implements RestaurantDAO{
	
	@Autowired
	private RestRepository restRepo;

	@Override
	public Restaurant addRestaurant(Restaurant rest) {
		restRepo.save(rest);
		return rest;
	}

	@Override
	public Restaurant deleteRestaurant(Long id) {
		Restaurant current = null;
		if (restRepo.findById(id) != null) {
			restRepo.deleteById(id);
		}
		return current;		
	}

	@Override
	public List<Restaurant> listRestaurant() {
		return restRepo.findAll();
	}
	

}
