package com.me.campaign.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.me.campaign.entity.CampaignGroup;
import com.me.campaign.repository.CampaignGroupRepo;

@Controller
public class CampaignGroupController {
	
	@Autowired
	private CampaignGroupRepo repo;
	
	
	
	@GetMapping("/campaignGroups") // we map these with html
	public String listCampaignGroups(Model model) {
		List<CampaignGroup> campaignGroupsList = repo.findAll();
		model.addAttribute("campaignGroupsList", campaignGroupsList); // use this in html
		
		return "listCampaignGroup"; // invoke this html
	}
	
	
	
	@GetMapping("/campaignGroups/add")
	public String showCampaignGroupsForm(Model model) {
		model.addAttribute("campaignGroup", new CampaignGroup()); // this is passed to th:action		
		return "formCampaignGroup"; // invoke this html
	}
	
	
	@GetMapping("/editCampaignGroup/{id}")
	public String editCampaignGroup(@PathVariable Integer id, Model model) {
		
		Optional<CampaignGroup> candidateGroup = repo.findById(id);
		CampaignGroup campaignGroup = candidateGroup.get();
 		
		model.addAttribute("cg",campaignGroup);
		
		return "editCampaignGroup"; // invoke this html file
	}
	
	
	@GetMapping("/deleteCampaignGroup/{id}")
	public String deleteCampaignGroup(@PathVariable Integer id) {
		
		repo.deleteById(id);
		return "redirect:/campaignGroups";
	}
	
	
	
	
	@PostMapping("/campaignGroups/save")
	public String saveCampaignGroup(CampaignGroup campaignGroup) {
		
		repo.save(campaignGroup);
		
		return "redirect:/campaignGroups"; // redirect to the listCampaignGroup html page
	}
	
	
	@PostMapping("/campaignGroups/update")
	public String updateCampaignGroup(@ModelAttribute CampaignGroup campaignGroup) {
		
		repo.save(campaignGroup);
		
		return "redirect:/campaignGroups";
	}
	
	
	
	
	
}
