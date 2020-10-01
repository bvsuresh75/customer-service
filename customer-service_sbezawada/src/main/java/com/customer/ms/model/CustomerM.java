package com.customer.ms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="customer database")
public class CustomerM {
	
	@Id
	private String cusId;
	private String cusName;
	private String cusAddress;
	
		public CustomerM(String cusId, String cusName, String cusAddress) {
		this.cusId=cusId;
		this.cusName=cusName;
		this.cusAddress=cusAddress;
	}
	
	public String getCusId() {
		return cusId;
	}
	public void setCusId(String cusId) {
		this.cusId = cusId;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCusAddress() {
		return cusAddress;
	}
	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}

	
}
