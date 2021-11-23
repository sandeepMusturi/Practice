package com.hcl.foodorder.search.RestaurantSearch.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hcl.foodorder.domain.restaurant.MenuItem;
import com.hcl.foodorder.domain.restaurant.RestMenu;
import com.hcl.foodorder.domain.restaurant.Restaurant;

@Service
public class SearchService {

	// private List<Restaurant> restauranta;

	@Autowired
	private RestTemplate restTemplate;

	public Restaurant getRestaurantByName(String name) {
		Restaurant res = restTemplate.getForObject("http://localhost:8083/restaurants/v1/get/byName/" + name,
				Restaurant.class);
		System.out.println("in restaurant search");
		return res;
	}

	public List<Restaurant> getAll() {
		
//		List<RestMenu> resList = new ArrayList<>();

		Restaurant[] restauranta = restTemplate.getForObject("http://localhost:8083/restaurants/v1/all",
				Restaurant[].class);
		
		List<Restaurant> res = Arrays.asList(restauranta);

//		for (int i = 0; i <= restauranta.length - 1; i++) {
//			RestMenu re = new RestMenu();
//			long resid = restauranta[i].getId();
//			MenuItem[] Menu = restTemplate
//					.getForObject("http://restaurant-service/restaurants/v1/get/" + resid + "/menu", MenuItem[].class);
//			List<MenuItem> prodmenu = Arrays.asList(Menu);
//
//			re.setMenuItem(prodmenu);
//			re.setRestaurant(restauranta[i]);
//			System.out.println(resid);
//
//			resList.add(re);
//			System.out.println(resList);
//		}
//		System.out.println(resList);
		return res;
	}

}
