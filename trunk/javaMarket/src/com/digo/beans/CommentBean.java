package com.digo.beans;

import java.util.Date;

public class CommentBean {
	private String userName;
	private String score;
	private String advantage;
	private String disadvantage;
	private String content;
	public String goodsId;
	private Date commentTime;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getAdvantage() {
		return advantage;
	}
	public void setAdvantage(String advantage) {
		this.advantage = advantage;
	}
	public String getDisadvantage() {
		return disadvantage;
	}
	public void setDisadvantage(String disadvantage) {
		this.disadvantage = disadvantage;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	
}
