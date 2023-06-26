package com.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admission")
public class AdmissionController {
	
	@GetMapping("/status")
	@ResponseBody
	public String getStatus() {
		return "Admission is open!";
	}
	
	@GetMapping("/details")
	@ResponseBody
	public String getDetails() {
		return "Admission details will be provided soon.";
	}
}
