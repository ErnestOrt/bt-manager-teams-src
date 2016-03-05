package org.ernest.applications.bt.db.manager.teams.ms.services.impl;

import org.ernest.applications.bt.db.manager.teams.ct.UpdateAddMemberInput;
import org.ernest.applications.bt.db.manager.teams.ct.UpdateNameInput;
import org.ernest.applications.bt.db.manager.teams.ct.UpdateRemoveMemberInput;
import org.ernest.applications.bt.db.manager.teams.ct.entities.Team;
import org.ernest.applications.bt.db.manager.teams.ct.exceptions.RetrieveTeamException;
import org.ernest.applications.bt.db.manager.teams.ct.exceptions.UpdateTeamException;
import org.ernest.applications.bt.db.manager.teams.ms.controllers.UpdateAddStageCompletedInput;
import org.ernest.applications.bt.db.manager.teams.ms.controllers.UpdateRemoveStageCompleteInput;
import org.ernest.applications.bt.db.manager.teams.ms.services.CrudService;
import org.ernest.applications.bt.db.manager.teams.ms.services.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateServiceImpl implements UpdateService {
	
	@Autowired
	CrudService crudService;

	@Override
	public void updateName(UpdateNameInput updateNameInput) throws UpdateTeamException, RetrieveTeamException {
		Team team = crudService.retrieve(updateNameInput.getTeamId());
		team.setName(updateNameInput.getName());
		crudService.update(team);
	}

	@Override
	public void addMember(UpdateAddMemberInput updateAddMemberInput) throws UpdateTeamException, RetrieveTeamException {
		Team team = crudService.retrieve(updateAddMemberInput.getTeamId());
		team.getMembersIds().add(updateAddMemberInput.getMemberId());
		crudService.update(team);
		
	}

	@Override
	public void removeMember(UpdateRemoveMemberInput updateRemoveMemberInput) throws UpdateTeamException, RetrieveTeamException {
		Team team = crudService.retrieve(updateRemoveMemberInput.getTeamId());
		team.getMembersIds().remove(updateRemoveMemberInput.getMemberId());
		crudService.update(team);
	}

	@Override
	public void addStageCompleted(UpdateAddStageCompletedInput updateAddStageCompletedInput) throws UpdateTeamException, RetrieveTeamException {
		Team team = crudService.retrieve(updateAddStageCompletedInput.getTeamId());
		team.getStagesCompletedIds().add(updateAddStageCompletedInput.getStageId());
		crudService.update(team);
	}

	@Override
	public void removeStageCompleted(UpdateRemoveStageCompleteInput updateRemoveStageCompleteInput) throws UpdateTeamException, RetrieveTeamException {
		Team team = crudService.retrieve(updateRemoveStageCompleteInput.getTeamId());
		team.getStagesCompletedIds().remove(updateRemoveStageCompleteInput.getStageId());
		crudService.update(team);
	}
}