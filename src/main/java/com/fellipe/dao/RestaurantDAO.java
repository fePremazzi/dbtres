package com.fellipe.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fellipe.entities.Restaurant;

public interface RestaurantDAO{
	
	Restaurant addRestaurant(Restaurant rest);
	Restaurant deleteRestaurant(Long id);
	List<Restaurant> listRestaurant();

}
