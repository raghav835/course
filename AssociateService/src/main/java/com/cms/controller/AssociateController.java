package com.cms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/associates")
public class AssociateController {
	
	@GetMapping
	public String getAllAssociates() {
		// Logic to retrieve all associates from the database or service
		return "All associates";
	}
	
	// Add more controller methods for handling associate-related operations
	
}
