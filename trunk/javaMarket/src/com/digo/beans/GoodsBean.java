package com.digo.beans;

import java.util.Date;

public class GoodsBean {
	private int creditLevel;

	private int goodsCount;

	private String goodsDes;

	private String goodsId;

	private String goodsImage;

	private String goodsInfo;

	private String goodsName;

	private Float goodsPrice;

	private String goodsType;

	private String goodsUnit;

	private Date initTime;

	private String merName;
	
	private String merId;

	private String promotionKey;

	private String promotionValue;

	private String remark;
	
	private int commentCount;
	
	private float averageScore;
	
	private int currentPage;
	
	public String getMerId() {
		return merId;
	}

	public void setMerId(String merId) {
		this.merId = merId;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public float getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(float averageScore) {
		this.averageScore = averageScore;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCreditLevel() {
		return creditLevel;
	}

	public void setCreditLevel(int creditLevel) {
		this.creditLevel = creditLevel;
	}

	public int getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}

	public String getGoodsDes() {
		return goodsDes;
	}

	public void setGoodsDes(String goodsDes) {
		this.goodsDes = goodsDes;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsImage() {
		return goodsImage;
	}

	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}

	public String getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Float getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getGoodsUnit() {
		return goodsUnit;
	}

	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit;
	}

	public Date getInitTime() {
		return initTime;
	}

	public void setInitTime(Date initTime) {
		this.initTime = initTime;
	}

	public String getMerName() {
		return merName;
	}

	public void setMerName(String merName) {
		this.merName = merName;
	}

	public String getPromotionKey() {
		return promotionKey;
	}

	public void setPromotionKey(String promotionKey) {
		this.promotionKey = promotionKey;
	}

	public String getPromotionValue() {
		return promotionValue;
	}

	public void setPromotionValue(String promotionValue) {
		this.promotionValue = promotionValue;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
