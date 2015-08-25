package com.digo.beans;

public class AddressBean {
	private String receiveAddrId;
	private String username;
	private String receiveName;
	private String city;
	private String street;
	private String phone;
	private String zipCode;
	private String email;
	private char deliveryType;
	private char payType;
	
	public String getReceiveAddrId() {
		return receiveAddrId;
	}
	public void setReceiveAddrId(String receiveAddrId) {
		this.receiveAddrId = receiveAddrId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public char getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(char deliveryType) {
		this.deliveryType = deliveryType;
	}
	public char getPayType() {
		return payType;
	}
	public void setPayType(char payType) {
		this.payType = payType;
	}
}
