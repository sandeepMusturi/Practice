package com.hcl.foodorder.search.RestaurantSearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.foodorder.domain.customer.Customer;
import com.hcl.foodorder.search.RestaurantSearch.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/create")
	public Customer create(@RequestBody Customer customer) {
		return customerService.create(customer);
	}

	@GetMapping("/getbymobile/{mobileNumber}")
	public Customer getByMobileNumber(@PathVariable("mobileNumber") String mobileNumber) {

		return customerService.getByMobileNumber(mobileNumber);

	}
	
	@PutMapping("/update/{customerMobileNumber}")
    public void update(@RequestBody Customer customer,
            @PathVariable("customerMobileNumber") String customerMobileNumber){
       
        customer.setMobileNumber(customerMobileNumber);
        customerService.updateCustomerDetails(customer,customerMobileNumber);
    }
}
