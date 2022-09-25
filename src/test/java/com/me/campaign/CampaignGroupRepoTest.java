package com.me.campaign;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.me.campaign.entity.CampaignGroup;
import com.me.campaign.repository.CampaignGroupRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE) // if we want to use real database to test, we need this annotation
@Rollback(false)
public class CampaignGroupRepoTest {

	@Autowired
	private CampaignGroupRepo repo;


	@Test
	public void testCreateCampaignGroup() {

		CampaignGroup savedCampaignGroup = repo.save(new CampaignGroup("First","This is First."));
		assertThat(savedCampaignGroup.getId()).isGreaterThan(0);

	}

}
