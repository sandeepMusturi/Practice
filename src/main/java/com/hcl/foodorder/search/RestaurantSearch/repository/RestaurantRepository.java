package com.hcl.foodorder.search.RestaurantSearch.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hcl.foodorder.domain.restaurant.Restaurant;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, Long>{

}
