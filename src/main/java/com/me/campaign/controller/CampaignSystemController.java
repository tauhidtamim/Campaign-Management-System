package com.me.campaign.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CampaignSystemController {
	
	@GetMapping("/")
	public String viewHomePage() {
		return "index";
	}
	
}
