package com.fellipe.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fellipe.entities.Rating;
import com.fellipe.entities.Restaurant;
import com.fellipe.repos.RestRepository;
import com.fellipe.validations.RestaurantValidator;

@Repository
public class RestaurantDaoImpl implements RestaurantDAO{
	
	@Autowired
	private RestRepository restRepo;

	@Override
	public Restaurant addRestaurant(Restaurant restCurrent) throws ServiceException{
		try {
			List<Restaurant> listAll = listRestaurant();
			Boolean check = RestaurantValidator.checkDuplicateRestaurant(listAll, restCurrent);
			
			if (!check) {
				restRepo.save(restCurrent);
				return restCurrent;
			}else
				return null;
		} catch (Exception e) {
			throw new ServiceException("Não foi possível persistir os dados");
		}	
	}

	@Override
	public Optional<Restaurant> deleteRestaurant(Long id_rest) {
		Optional<Restaurant> toDelete = restRepo.findById(id_rest);
		restRepo.deleteById(id_rest);
		return toDelete;		
	}

	@Override
	public List<Restaurant> listAllRestaurant() {
		return listAllRestaurant();
	}

	private List<Restaurant> listRestaurant(){
		return restRepo.findAll();
	}

	@Override
	public Restaurant addStar(long idRest, Rating rate) {
		Optional<Restaurant> filter = restRepo.findById(idRest);
		if (filter != null) {
			filter.get().getRating().add(rate);
		}
		restRepo.saveAndFlush(filter.get());
		return filter.get();
	}

}
