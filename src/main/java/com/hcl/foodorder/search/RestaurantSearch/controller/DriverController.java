package com.hcl.foodorder.search.RestaurantSearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.foodorder.domain.driver.Driver;
import com.hcl.foodorder.search.RestaurantSearch.service.DriverService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	private DriverService driverService;

	@GetMapping("/mobile/{mobileNumber}")
	public Driver getDriverByMobileNumber(@PathVariable("mobileNumber") String mobileNumber) {

		return driverService.getDriverByMobileNumber(mobileNumber);
	}

	@GetMapping("/getavailable")
	public List<Driver> getAvailableDrivers() {
		return driverService.getAvailableDrivers();
	}

	@PutMapping("/update/mobileNumber")
	public Driver updateDriverStatus(@RequestBody Driver driver, @PathVariable("mobileNumber") String mobileNumber) {
		// driver.setMobileNumber(mobileNumber);
		return driverService.updateDriveStatus(driver, mobileNumber);

	}

	@PostMapping("/createDriver")
	public ResponseEntity<Driver> createDriver(@RequestBody Driver driver) {

		return driverService.createDriver(driver);
	}
}
















