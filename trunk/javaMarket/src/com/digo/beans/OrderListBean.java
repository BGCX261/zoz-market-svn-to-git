package com.digo.beans;

import java.util.List;

public class OrderListBean {
	private String orderId;
	private String receiveName;
	private String total;
	private String orderTime;
	private String orderStatus;
	private List<GoodsBean> goodsList;
	private RecordsBean record;
	public RecordsBean getRecord() {
		return record;
	}
	public void setRecord(RecordsBean record) {
		this.record = record;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public List<GoodsBean> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<GoodsBean> goodsList) {
		this.goodsList = goodsList;
	}
}
