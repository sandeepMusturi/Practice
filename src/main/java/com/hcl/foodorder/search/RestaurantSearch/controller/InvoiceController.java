package com.hcl.foodorder.search.RestaurantSearch.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.foodorder.domain.order.Order;
import com.hcl.foodorder.search.RestaurantSearch.service.PdfGenerated;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	private PdfGenerated pdfGenerated;

	@PostMapping("/createInvoice")

	public Order createInvoice(@RequestBody Order order) {
		return pdfGenerated.createInvoice(order);
	}

}
