package org.ernest.applications.bt.db.manager.teams.ms.services;

import org.ernest.applications.bt.db.manager.teams.ct.entities.Team;
import org.ernest.applications.bt.db.manager.teams.ct.exceptions.CreateTeamException;
import org.ernest.applications.bt.db.manager.teams.ct.exceptions.DeleteTeamException;
import org.ernest.applications.bt.db.manager.teams.ct.exceptions.RetrieveTeamException;
import org.ernest.applications.bt.db.manager.teams.ct.exceptions.UpdateTeamException;

public interface CrudService {

	String create() throws CreateTeamException;
	void update(Team user) throws UpdateTeamException;
	Team retrieve(String teamId) throws RetrieveTeamException;
	void delete(String teamId) throws DeleteTeamException;
	
}
