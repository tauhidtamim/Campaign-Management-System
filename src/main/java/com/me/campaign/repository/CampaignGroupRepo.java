package com.me.campaign.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.campaign.entity.CampaignGroup;

public interface CampaignGroupRepo extends JpaRepository<CampaignGroup, Integer> {

}
