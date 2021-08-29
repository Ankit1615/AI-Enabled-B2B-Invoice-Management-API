package com.higradius;

import java.sql.Date;

public class CorrespondencePojo {
	private Long invoice_number;
	private Long po_number;
	private Date invoice_date;
	private Date due_date;
	private Double total_open_amount;
	private String currency;
	
	public Long getInvoice_number() {
		return invoice_number;
	}
	public void setInvoice_number(Long invoice_number) {
		this.invoice_number = invoice_number;
	}
	public Long getPo_number() {
		return po_number;
	}
	public void setPo_number(Long po_number) {
		this.po_number = po_number;
	}
	public Date getInvoice_date() {
		return invoice_date;
	}
	public void setInvoice_date(Date invoice_date) {
		this.invoice_date = invoice_date;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public Double getTotal_open_amount() {
		return total_open_amount;
	}
	public void setTotal_open_amount(Double total_open_amount) {
		this.total_open_amount = total_open_amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}