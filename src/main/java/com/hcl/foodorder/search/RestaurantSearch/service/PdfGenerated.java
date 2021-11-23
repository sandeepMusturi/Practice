package com.hcl.foodorder.search.RestaurantSearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hcl.foodorder.domain.order.Order;

@Service
public class PdfGenerated {

	@Autowired
	private RestTemplate restTemplate;

	public Order createInvoice(Order order) {

		return restTemplate.postForObject("http://invoice-service/invoices/v1/generateOrder", order, Order.class);
	}

}
