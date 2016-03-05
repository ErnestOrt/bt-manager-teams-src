package org.ernest.application.bt.db.manager.teams.test;

import org.ernest.applications.bt.db.manager.teams.ct.UpdateAddMemberInput;
import org.ernest.applications.bt.db.manager.teams.ct.UpdateNameInput;
import org.ernest.applications.bt.db.manager.teams.ct.UpdateRemoveMemberInput;
import org.ernest.applications.bt.db.manager.teams.ct.entities.Team;
import org.ernest.applications.bt.db.manager.teams.ms.Application;
import org.ernest.applications.bt.db.manager.teams.ms.controllers.UpdateAddStageCompletedInput;
import org.ernest.applications.bt.db.manager.teams.ms.controllers.UpdateRemoveStageCompleteInput;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest({"server.port=0"})
public class CrudTest {
	
	@Value("${local.server.port}")
	String port;
	
	String teamIdCreated;
	
	@Before
	public void setUp(){
		teamIdCreated = new RestTemplate().getForObject("http://localhost:"+port+"/create", String.class);
		Assert.assertEquals(teamIdCreated, new RestTemplate().getForObject("http://localhost:"+port+"/retrieve/"+teamIdCreated, Team.class).get_id());
	}
	
	@After
	public void cleanUp(){
		new RestTemplate().getForObject("http://localhost:"+port+"/delete/"+teamIdCreated, String.class);
		teamIdCreated = null;
	}
	
	@Test
	public void updateTeamName(){
		UpdateNameInput updateNameInput = new UpdateNameInput();
		updateNameInput.setTeamId(teamIdCreated);
		updateNameInput.setName("New Name");
		
		new RestTemplate().postForObject("http://localhost:"+port+"/update/name", updateNameInput, String.class);
		Assert.assertEquals(updateNameInput.getName(), new RestTemplate().getForObject("http://localhost:"+port+"/retrieve/"+teamIdCreated, Team.class).getName());
		
	}
	
	@Test
	public void updateTeamMember(){
		String newMemberId = "MEMBER_ID_TEST";
		
		UpdateAddMemberInput updateAddMemberInput = new UpdateAddMemberInput();
		updateAddMemberInput.setTeamId(teamIdCreated);
		updateAddMemberInput.setMemberId(newMemberId);
		
		new RestTemplate().postForObject("http://localhost:"+port+"/update/addmember", updateAddMemberInput, String.class);
		Assert.assertTrue(new RestTemplate().getForObject("http://localhost:"+port+"/retrieve/"+teamIdCreated, Team.class).getMembersIds().contains(newMemberId));
		
		UpdateRemoveMemberInput updateRemoveMemberInput = new UpdateRemoveMemberInput();
		updateRemoveMemberInput.setTeamId(teamIdCreated);
		updateRemoveMemberInput.setMemberId(newMemberId);
		
		new RestTemplate().postForObject("http://localhost:"+port+"/update/removemember", updateRemoveMemberInput, String.class);
		Assert.assertFalse(new RestTemplate().getForObject("http://localhost:"+port+"/retrieve/"+teamIdCreated, Team.class).getMembersIds().contains(newMemberId));
	}
	
	@Test
	public void updateStageCompleted(){
		String stageId = "STAGE_COMPLETED_ID_TEST";
		
		UpdateAddStageCompletedInput updateAddStageCompletedInput = new UpdateAddStageCompletedInput();
		updateAddStageCompletedInput.setTeamId(teamIdCreated);
		updateAddStageCompletedInput.setStageId(stageId);
		
		new RestTemplate().postForObject("http://localhost:"+port+"/update/addstagecompleted", updateAddStageCompletedInput, String.class);
		Assert.assertTrue(new RestTemplate().getForObject("http://localhost:"+port+"/retrieve/"+teamIdCreated, Team.class).getStagesCompletedIds().contains(stageId));
		
		UpdateRemoveStageCompleteInput updateRemoveStageCompleteInput = new UpdateRemoveStageCompleteInput();
		updateRemoveStageCompleteInput.setTeamId(teamIdCreated);
		updateRemoveStageCompleteInput.setStageId(stageId);
		
		new RestTemplate().postForObject("http://localhost:"+port+"/update/removestagecompleted", updateRemoveStageCompleteInput, String.class);
		Assert.assertFalse(new RestTemplate().getForObject("http://localhost:"+port+"/retrieve/"+teamIdCreated, Team.class).getStagesCompletedIds().contains(stageId));
	}

}