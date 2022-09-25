package com.me.campaign.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.me.campaign.entity.Campaign;
import com.me.campaign.entity.CampaignGroup;
import com.me.campaign.repository.CampaignGroupRepo;
import com.me.campaign.repository.CampaignRepo;

@Controller
public class CampaignController {

	@Autowired
	private CampaignRepo campaignRepo;
	
	@Autowired
	private CampaignGroupRepo campaignGroupRepo;
	
	@GetMapping("/campaign")
	public String listCampaign(Model model) {
		List<Campaign> campaignList = campaignRepo.findAll();
		model.addAttribute("campaignList", campaignList); // use this in html
		
		return "listCampaign"; // invoke this html
	}
	
	@GetMapping("/campaign/add")
	public String showCampaignForm(Model model) {
		
		List<CampaignGroup> listCampaignGroup = campaignGroupRepo.findAll();
		
		model.addAttribute("campaign", new Campaign()); // this is passed to th:action
		model.addAttribute("listCampaignGroup", listCampaignGroup); // this is referenced in dropdown
		
		return "formCampaign"; // invoke this html
	}
	
	@PostMapping("/campaign/save")
	public String saveCampaign(Campaign campaign) {
		campaignRepo.save(campaign);
		
		return "redirect:/campaign"; // redirect to the listCampaign html page
	}
	
	
	
}
