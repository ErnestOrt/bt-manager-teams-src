package org.ernest.applications.bt.db.manager.teams.ms.controllers;

import org.ernest.applications.bt.db.manager.teams.ct.entities.Team;
import org.ernest.applications.bt.db.manager.teams.ct.exceptions.CreateTeamException;
import org.ernest.applications.bt.db.manager.teams.ct.exceptions.DeleteTeamException;
import org.ernest.applications.bt.db.manager.teams.ct.exceptions.RetrieveTeamException;
import org.ernest.applications.bt.db.manager.teams.ms.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrdController {

	@Autowired
	CrudService crudService;
	
	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public String create() throws CreateTeamException {
		return crudService.create();
	}
	
	@RequestMapping(path = "/retrieve/{teamId}", method = RequestMethod.GET)
	public Team retrieve(@PathVariable("teamId") String teamId) throws RetrieveTeamException {
		return crudService.retrieve(teamId);
	}
	
	@RequestMapping(path = "/delete/{teamId}", method = RequestMethod.GET)
	public void delete(@PathVariable("teamId") String teamId) throws DeleteTeamException {
		crudService.delete(teamId);
	}
}