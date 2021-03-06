package com.digo.pojo;

// Generated Mar 10, 2013 2:27:49 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Comment generated by hbm2java
 */
public class Comment implements java.io.Serializable {

	private String commentId;
	private Goods goods;
	private User user;
	private char commentScore;
	private String advantage;
	private String disadvantage;
	private String commentContent;
	private char commentStatus;
	private Date commentTime;

	public Comment() {
	}

	public Comment(String commentId, Goods goods, User user, char commentScore,
			String advantage, String disadvantage, String commentContent,
			char commentStatus, Date commentTime) {
		this.commentId = commentId;
		this.goods = goods;
		this.user = user;
		this.commentScore = commentScore;
		this.advantage = advantage;
		this.disadvantage = disadvantage;
		this.commentContent = commentContent;
		this.commentStatus = commentStatus;
		this.commentTime = commentTime;
	}

	public String getCommentId() {
		return this.commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public char getCommentScore() {
		return this.commentScore;
	}

	public void setCommentScore(char commentScore) {
		this.commentScore = commentScore;
	}

	public String getAdvantage() {
		return this.advantage;
	}

	public void setAdvantage(String advantage) {
		this.advantage = advantage;
	}

	public String getDisadvantage() {
		return this.disadvantage;
	}

	public void setDisadvantage(String disadvantage) {
		this.disadvantage = disadvantage;
	}

	public String getCommentContent() {
		return this.commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public char getCommentStatus() {
		return this.commentStatus;
	}

	public void setCommentStatus(char commentStatus) {
		this.commentStatus = commentStatus;
	}

	public Date getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

}
