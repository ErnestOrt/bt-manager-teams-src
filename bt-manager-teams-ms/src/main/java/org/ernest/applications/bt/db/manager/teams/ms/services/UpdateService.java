package org.ernest.applications.bt.db.manager.teams.ms.services;

import org.ernest.applications.bt.db.manager.teams.ct.UpdateAddMemberInput;
import org.ernest.applications.bt.db.manager.teams.ct.UpdateAddStageCompletedInput;
import org.ernest.applications.bt.db.manager.teams.ct.UpdateNameInput;
import org.ernest.applications.bt.db.manager.teams.ct.UpdateRemoveMemberInput;
import org.ernest.applications.bt.db.manager.teams.ct.UpdateRemoveStageCompleteInput;
import org.ernest.applications.bt.db.manager.teams.ct.exceptions.RetrieveTeamException;
import org.ernest.applications.bt.db.manager.teams.ct.exceptions.UpdateTeamException;

public interface UpdateService {

	void updateName(UpdateNameInput updateNameInput) throws UpdateTeamException, RetrieveTeamException;

	void addMember(UpdateAddMemberInput updateAddMemberInput) throws UpdateTeamException, RetrieveTeamException;

	void removeMember(UpdateRemoveMemberInput updateRemoveMemberInput) throws UpdateTeamException, RetrieveTeamException;

	void addStageCompleted(UpdateAddStageCompletedInput updateAddStageCompletedInput) throws UpdateTeamException, RetrieveTeamException;

	void removeStageCompleted(UpdateRemoveStageCompleteInput updateRemoveStageCompleteInput) throws UpdateTeamException, RetrieveTeamException;

}
