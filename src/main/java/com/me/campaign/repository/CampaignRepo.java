package com.me.campaign.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.campaign.entity.Campaign;

public interface CampaignRepo extends JpaRepository<Campaign, Integer> { // table, type of PK

}
