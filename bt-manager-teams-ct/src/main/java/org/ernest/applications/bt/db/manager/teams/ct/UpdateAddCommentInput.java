package org.ernest.applications.bt.db.manager.teams.ct;

public class UpdateAddCommentInput {
	
	private String teamId;
	private String commentId;
	
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
}