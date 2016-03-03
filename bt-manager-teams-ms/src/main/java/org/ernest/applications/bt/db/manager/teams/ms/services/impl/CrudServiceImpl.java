package org.ernest.applications.bt.db.manager.teams.ms.services.impl;

import java.util.UUID;

import org.ernest.applications.bt.db.manager.teams.ct.entities.Team;
import org.ernest.applications.bt.db.manager.teams.ct.exceptions.CreateTeamException;
import org.ernest.applications.bt.db.manager.teams.ct.exceptions.DeleteTeamException;
import org.ernest.applications.bt.db.manager.teams.ct.exceptions.RetrieveTeamException;
import org.ernest.applications.bt.db.manager.teams.ct.exceptions.UpdateTeamException;
import org.ernest.applications.bt.db.manager.teams.ms.services.CrudService;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CrudServiceImpl implements CrudService{
	
	@Value("${db.name}")
	private String dbName;
	
	@Value("${db.host}")
	private String dbHost;

	@Override
	public String create() throws CreateTeamException {
		
		Team team = new Team();
		team.set_id(UUID.randomUUID().toString());
		try{
			CouchDbClient dbClient = new CouchDbClient(buildCouchDbProperties());
			dbClient.save(team);
			dbClient.shutdown();
		
			return team.get_id();
			
		}catch(Exception e){
			e.printStackTrace();
			throw new CreateTeamException(e.getMessage());
		}
	}

	@Override
	public Team retrieve(String teamId) throws RetrieveTeamException {
		
		try{
			CouchDbClient dbClient = new CouchDbClient(buildCouchDbProperties());
			Team team = dbClient.find(Team.class, teamId);
			dbClient.shutdown();
			
			return team;
			
		}catch(Exception e){
			e.printStackTrace();
			throw new RetrieveTeamException(e.getMessage());
		}
		
	}

	@Override
	public void delete(String teamId) throws DeleteTeamException {
		try{
			CouchDbClient dbClient = new CouchDbClient(buildCouchDbProperties());
			Team team = dbClient.find(Team.class, teamId);
			dbClient.remove(team);
			dbClient.shutdown();
		}catch(Exception e){
			e.printStackTrace();
			throw new DeleteTeamException(e.getMessage());
		}
	}

	@Override
	public void update(Team team) throws UpdateTeamException {
		try{
			CouchDbClient dbClient = new CouchDbClient(buildCouchDbProperties());
			dbClient.update(team);
			dbClient.shutdown();
		}catch(Exception e){
			e.printStackTrace();
			throw new UpdateTeamException(e.getMessage());
		}
	}
	
	private CouchDbProperties buildCouchDbProperties() {
		CouchDbProperties properties = new CouchDbProperties();
		properties.setDbName(dbName);
		properties.setHost(dbHost);
		properties.setPort(5984);
		properties.setCreateDbIfNotExist(true);
		properties.setProtocol("http");
		return properties;
	}

}
