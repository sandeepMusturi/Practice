package com.hcl.foodorder.search.RestaurantSearch.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hcl.foodorder.domain.driver.Driver;

@Service
public class DriverService {

	@Autowired
	private RestTemplate restemplate;

	public Driver getDriverByMobileNumber(String mobileNumber) {

		Driver driver = restemplate.getForObject("http://driver-service/drivers/v1/get/" + mobileNumber, Driver.class);
		return driver;
	}

	public List<Driver> getAvailableDrivers() {
		Driver[] dr = restemplate.getForObject("http://driver-service/drivers/v1/getavaiabledrivers", Driver[].class);
		List<Driver> driver = Arrays.asList(dr);

		return driver;
	}

	public Driver updateDriveStatus(Driver driver, String mobileNumber) {
		restemplate.put("http://driver-service/drivers/v1/update/" + mobileNumber,driver, Driver.class);
		
		return null;
	}

	public ResponseEntity<Driver> createDriver(Driver driver) {

		ResponseEntity<Driver> cdriver = null;
		try {

			// driver.setId(101L);
			// driver.setName("abc");
			// driver.setMobileNumber("11111111");
			// driver.setEmail("abc@email");
			// driver.setAdress(new Address().setId(1l));

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			// String requestJson = "{\"queriedQuestion\":\"Is there pain in
			// your hand?\"}";

			// HttpEntity<Driver> entity = new HttpEntity<Driver>(driver,
			// headers);
			cdriver = restemplate.postForEntity("http://driver-service/drivers/v1/create", driver, Driver.class);
			// cdriver=restemplate.postFor("http://driver-service/drivers/v1/create",
			// driver, Driver.class);

			// cdriver=restemplate.exchange("http://driver-service/drivers/v1/create",
			// HttpMethod.POST, entity, Driver.class);

			System.out.println("succcess");
		}

		catch (Exception e) {
			System.out.println("error/n" + e);
		}
		return cdriver;
	}

}
