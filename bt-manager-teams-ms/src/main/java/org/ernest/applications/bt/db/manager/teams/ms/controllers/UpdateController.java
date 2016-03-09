package org.ernest.applications.bt.db.manager.teams.ms.controllers;

import org.ernest.applications.bt.db.manager.teams.ct.UpdateAddMemberInput;
import org.ernest.applications.bt.db.manager.teams.ct.UpdateAddStageCompletedInput;
import org.ernest.applications.bt.db.manager.teams.ct.UpdateNameInput;
import org.ernest.applications.bt.db.manager.teams.ct.UpdateRemoveMemberInput;
import org.ernest.applications.bt.db.manager.teams.ct.UpdateRemoveStageCompleteInput;
import org.ernest.applications.bt.db.manager.teams.ct.exceptions.RetrieveTeamException;
import org.ernest.applications.bt.db.manager.teams.ct.exceptions.UpdateTeamException;
import org.ernest.applications.bt.db.manager.teams.ms.services.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateController {
	
	@Autowired
	UpdateService updateService;
	
	@RequestMapping("/update/name")
	public void updateName(@RequestBody UpdateNameInput updateNameInput) throws UpdateTeamException, RetrieveTeamException {
		updateService.updateName(updateNameInput);
	}
	
	@RequestMapping("/update/addmember")
	public void addMember(@RequestBody UpdateAddMemberInput updateAddMemberInput) throws UpdateTeamException, RetrieveTeamException {
		updateService.addMember(updateAddMemberInput);
	}
	
	@RequestMapping("/update/removemember")
	public void removeMember(@RequestBody UpdateRemoveMemberInput updateRemoveMemberInput) throws UpdateTeamException, RetrieveTeamException {
		updateService.removeMember(updateRemoveMemberInput);
	}
	
	@RequestMapping("/update/addstagecompleted")
	public void addStageCompleted(@RequestBody UpdateAddStageCompletedInput updateAddStageCompletedInput) throws UpdateTeamException, RetrieveTeamException {
		updateService.addStageCompleted(updateAddStageCompletedInput);
	}
	
	@RequestMapping("/update/removestagecompleted")
	public void removeStageCompleted(@RequestBody UpdateRemoveStageCompleteInput updateRemoveStageCompleteInput) throws UpdateTeamException, RetrieveTeamException {
		updateService.removeStageCompleted(updateRemoveStageCompleteInput);
	}

}