package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bankcustomerss")
public class Customer {

	/*@ManyToOne
	Account account;*/
	
	@Id
	@Column(name="customerid")
	private long customerId;
	@Column(name="customername",nullable=false)
	private String customerName;
	@Column(name="accountno",nullable=false,unique=true)
	private long accountNo;
	@Column(name="phonno",nullable=false)
	private long phoneNo;
	@Column(name="mailid",nullable=false)
	private String mailId;
	
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	
}
