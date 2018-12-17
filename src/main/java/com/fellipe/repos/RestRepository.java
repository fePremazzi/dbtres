package com.fellipe.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fellipe.entities.Restaurant;

public interface RestRepository extends JpaRepository<Restaurant, Long> {

}
