package com.snow.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class CustomerModel {
	
	@Id
	private int customerid;
	private String customername;
    private int customeramount;
    private String paymenttype;
	@Override
	public String toString() {
		return "CustomerModel [customerid=" + customerid + ", customername=" + customername + ", customeramount="
				+ customeramount + ", paymenttype=" + paymenttype + "]";
	}
	
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public int getCustomeramount() {
		return customeramount;
	}
	public void setCustomeramount(int customeramount) {
		this.customeramount = customeramount;
	}
	public String getPaymenttype() {
		return paymenttype;
	}
	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}
	

}
