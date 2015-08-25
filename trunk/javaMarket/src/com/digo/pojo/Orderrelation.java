package com.digo.pojo;

// Generated Mar 10, 2013 2:27:49 PM by Hibernate Tools 3.4.0.CR1

/**
 * Orderrelation generated by hbm2java
 */
public class Orderrelation implements java.io.Serializable {

	private String orderRelationId;
	private Goods goods;
	private Orders orders;
	private float unitPrice;
	private int buyCount;
	private String sendAddrId;

	public Orderrelation() {
	}

	public Orderrelation(String orderRelationId, Goods goods, Orders orders,
			float unitPrice, int buyCount, String sendAddrId) {
		this.orderRelationId = orderRelationId;
		this.goods = goods;
		this.orders = orders;
		this.unitPrice = unitPrice;
		this.buyCount = buyCount;
		this.sendAddrId = sendAddrId;
	}

	public String getOrderRelationId() {
		return this.orderRelationId;
	}

	public void setOrderRelationId(String orderRelationId) {
		this.orderRelationId = orderRelationId;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public float getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getBuyCount() {
		return this.buyCount;
	}

	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}

	public String getSendAddrId() {
		return this.sendAddrId;
	}

	public void setSendAddrId(String sendAddrId) {
		this.sendAddrId = sendAddrId;
	}

}
