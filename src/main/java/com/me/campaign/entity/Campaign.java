package com.me.campaign.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Campaign {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	private String description;
	private String startDate;
	private String endDate;
	
	@ManyToOne()
	@JoinColumn(name = "cg_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private CampaignGroup campaignGroup; // this is referenced in campaign form dropdown

	@Override
	public String toString() {
		return "Campaign [id=" + id + ", name=" + name + ", description=" + description + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", campaignGroup=" + campaignGroup + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public CampaignGroup getCampaignGroup() {
		return campaignGroup;
	}

	public void setCampaignGroup(CampaignGroup campaignGroup) {
		this.campaignGroup = campaignGroup;
	}
	
}
