package com.hcl.foodorder.search.RestaurantSearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.foodorder.domain.restaurant.RestMenu;
import com.hcl.foodorder.domain.restaurant.Restaurant;
import com.hcl.foodorder.search.RestaurantSearch.service.SearchService;

@RestController
@RequestMapping("/restaurant")
public class SearchController {

	@Autowired
	private SearchService searchservice;

	@GetMapping("/{name}")
	public Restaurant getRestaurant(@PathVariable String name) {
		return searchservice.getRestaurantByName(name);

	}

	@GetMapping("/all")

	public List<Restaurant> getAllRestaurant() {
		return searchservice.getAll();
	}

}
