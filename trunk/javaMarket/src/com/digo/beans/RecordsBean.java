package com.digo.beans;

import java.util.Date;

public class RecordsBean {
	private String recordsId;
	public String getRecordsId() {
		return recordsId;
	}
	public void setRecordsId(String recordsId) {
		this.recordsId = recordsId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getRecordsType() {
		return recordsType;
	}
	public void setRecordsType(String recordsType) {
		this.recordsType = recordsType;
	}
	public int getRecordsNumber() {
		return recordsNumber;
	}
	public void setRecordsNumber(int recordsNumber) {
		this.recordsNumber = recordsNumber;
	}
	public Date getRecordsTime() {
		return recordsTime;
	}
	public void setRecordsTime(Date recordsTime) {
		this.recordsTime = recordsTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	private String orderId;
	private String recordsType;
	private int recordsNumber;
	private Date recordsTime;
	private String remark;
}
