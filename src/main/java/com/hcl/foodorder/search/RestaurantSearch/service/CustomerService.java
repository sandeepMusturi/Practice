package com.hcl.foodorder.search.RestaurantSearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hcl.foodorder.domain.customer.Customer;

@Service
public class CustomerService {

	@Autowired
	private RestTemplate restTemplate;

	public Customer create(Customer customer) {
		Customer cust = restTemplate.postForObject("http://customer-service/customers/v1/creat", customer,
				Customer.class);
		return cust;
	}

	public Customer getByMobileNumber(String mobileNumber) {

		Customer cc= restTemplate.getForObject("http://customer-service/customers/v1/get/" + mobileNumber, Customer.class);
		return cc;
	}

	public void updateCustomerDetails(Customer customer, String mobileNumber) {
		restTemplate.put("https://customer-service/customers/v1/update/"+mobileNumber, customer,Customer.class);
		
	}

}
