package org.ernest.applications.bt.db.manager.teams.ct.entities;

import java.util.HashSet;
import java.util.Set;

public class Team {

	private String _id;
	private String _rev;
	
	private String name;
	private Set<String> membersIds;
	
	public Team(){
		membersIds = new HashSet<String>();
	}
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String get_rev() {
		return _rev;
	}
	public void set_rev(String _rev) {
		this._rev = _rev;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<String> getMembersIds() {
		return membersIds;
	}
	public void setMembersIds(Set<String> membersIds) {
		this.membersIds = membersIds;
	} 
	
	
}
