package com.fellipe.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fellipe.entities.Restaurant;

public interface RestRepository extends JpaRepository<Restaurant, Long> {

}
