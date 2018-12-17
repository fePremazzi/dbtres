package com.fellipe.dao;

import java.util.List;
import java.util.Optional;

import com.fellipe.entities.Rating;
import com.fellipe.entities.Restaurant;

public interface RestaurantDAO{
	
	Restaurant addRestaurant(Restaurant rest);
	Optional<Restaurant> deleteRestaurant(Long id);
	List<Restaurant> listAllRestaurant();
	Restaurant addStar(long id, Rating rate);

}
