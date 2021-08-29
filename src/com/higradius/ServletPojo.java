package com.higradius;

import java.sql.Date;

public class ServletPojo {
	private String cust_number;
	private String name_customer;
	private Long doc_id;
	private Date due_in_date;
	private Double total_open_amount;
	private String notes;
	

	public String getCust_number() {
		return cust_number;
	}

	public void setCust_number(String cust_number) {
		this.cust_number = cust_number;
	}

	public String getName_customer() {
		return name_customer;
	}

	public void setName_customer(String name_customer) {
		this.name_customer = name_customer;
	}

	public Long getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(Long doc_id) {
		this.doc_id = doc_id;
	}

	public Date getDue_in_date() {
		return due_in_date;
	}

	public void setDue_in_date(Date due_in_date) {
		this.due_in_date = due_in_date;
	}

	public Double getTotal_open_amount() {
		return total_open_amount;
	}

	public void setTotal_open_amount(Double total_open_amount) {
		
		this.total_open_amount = total_open_amount;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
