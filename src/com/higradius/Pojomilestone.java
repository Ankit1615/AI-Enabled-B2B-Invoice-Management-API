package com.higradius;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class Pojomilestone {
	private String business_code;
	private String cust_number;
	private String name_customer;
	private Timestamp clear_date;
	private Short business_year;
	private Long doc_id;
	private Date posting_date;
	private Date document_create_date;
	private Date due_in_date;
	private String invoice_currency;
	private String document_type;
	private Short posting_id; 
	private String area_business;
	private Double total_open_amount;
	private Date baseline_create_date;
	private String cust_payment_terms;
	private Long invoice_id;
	private Short isOpen;
	
	//for Business Code
	public String getBusiness_code() {
		return business_code;
	}
	public void setBusiness_code(String business_code) {
		try {
			if (business_code.isEmpty()) {
				this.business_code = null;
			}
			else {
				this.business_code = business_code;
			}
		} catch (NullPointerException ne) {
			this.business_code = null;
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}
	
	//for  Customer number.
	public String getCust_number() {
		return cust_number;
	}
	public void setCust_number(String cust_number) {
		try {
			if (cust_number.isEmpty()) {
				this.cust_number = null;
			}
			else {
				this.cust_number = cust_number;
			}
		} catch (NullPointerException ne) {
			this.cust_number = null;
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}
	
	//for  Customer Name
	public String getName_customer() {
		return name_customer;
	}
	public void setName_customer(String name_customer) {
		try {
			if (name_customer.isEmpty()) {
				this.name_customer = null;
			}
			else {
				this.name_customer = name_customer;
			}
		} catch (NullPointerException ne) {
			this.name_customer = null;
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}
	
	//for Clear Date
	public java.sql.Timestamp getClear_date() {
		return clear_date;
	}
	public void setClear_date(String clear_date) {
		
	    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-mm-dd hh:mm:ss");
	    java.util.Date parsed = null;
	    java.sql.Timestamp sql_clear_date = null;
		try {
			if (clear_date.isEmpty()) {
				this.clear_date = null;
			}
			else {
				parsed = sdf.parse(clear_date);
				sql_clear_date = new java.sql.Timestamp(parsed.getTime());
				this.clear_date = sql_clear_date;
			}
		} catch (NullPointerException ne) {
			this.cust_number = null;
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}
	
	//for Business Year
	public Short getBusiness_year() {
		return business_year;
	}
	public void setBusiness_year(String business_year) {
		try {
			if(business_year.isEmpty()) {
				this.business_year = null;
			}
			else {
				Short i= new Double(business_year).shortValue();
				this.business_year = i; 				
			}
		} catch (NullPointerException ne) {
			this.business_year= null;
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}
	
	//for Document Id
	public Long getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(String doc_id) {
		try {
			if (doc_id.isEmpty()) {
				this.doc_id = null;
			}
			else {
				Long i= new Double(doc_id).longValue();
				this.doc_id = i; 
			}

		} catch (NullPointerException ne) {
			this.doc_id= null;
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}
	
	//for Posting Date
	public java.sql.Date getPosting_date() {
		return posting_date;
	}
	public void setPosting_date(String posting_date) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	    java.util.Date parsed = null;
	    java.sql.Date sql_posting_date = null;
		try {
			if (posting_date.isEmpty()) {
				this.posting_date = null;
			}
			else {
				parsed = sdf.parse(posting_date);
				sql_posting_date = new java.sql.Date(parsed.getTime());
//				java.sql.Date dt = java.sql.Date.valueOf(posting_date);
				this.posting_date = sql_posting_date;
			}
		} catch (NullPointerException ne) {
			this.posting_date = null;
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}

	//for Document Create Date
	public java.sql.Date getDocument_create_date() {
		return document_create_date;
	}
	public void setDocument_create_date(String document_create_date) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	    java.util.Date parsed = null;
	    java.sql.Date sql_create_date = null;
		try {
			if (document_create_date.isEmpty()) {
				this.document_create_date = null;
			}
			else {
				parsed = sdf.parse(document_create_date);
				sql_create_date = new java.sql.Date(parsed.getTime());
				this.document_create_date = sql_create_date;
			}
		} catch (ParseException pe) {
			pe.printStackTrace();
		} catch (NullPointerException ne) {
			this.document_create_date = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//for Due Date
	public java.sql.Date getDue_in_date() {
		return due_in_date;
	}
	public void setDue_in_date(String due_in_date) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	    java.util.Date parsed1 = null;
	    java.sql.Date sql_due_date = null;
		try {
			if (due_in_date.isEmpty()) {
				this.due_in_date= null;
			}
			else {
				parsed1 = sdf.parse(due_in_date);
				sql_due_date = new java.sql.Date(parsed1.getTime());
				this.due_in_date = sql_due_date;
			}
		} catch (ParseException pe) {
			pe.printStackTrace();
		} catch (NullPointerException ne) {
			this.due_in_date= null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	//for Invoice currency
	public String getInvoice_currency() {
		return invoice_currency;
	}
	public void setInvoice_currency(String invoice_currency) {
		try {
			if (invoice_currency.isEmpty()) {
				this.invoice_currency = null;
			}
			else {
				this.invoice_currency = invoice_currency;
			}
		} catch (NullPointerException ne) {
			this.invoice_currency = null;
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}
	
	//for  Document Type
	public String getDocument_type() {
		return document_type;
	}
	public void setDocument_type(String document_type) {
		try {
			if (document_type.isEmpty()) {
				this.document_type = null;
			}
			else {
				this.document_type = document_type;
			}
		} catch (NullPointerException ne) {
			this.document_type = null;
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}
	
	//for Posting Id
	public Short getPosting_id() {
		return posting_id;
	}
	public void setPosting_id(String posting_id) {
		try {
			if (posting_id.isEmpty()) {
				this.posting_id = null;
			}
			else {
				Short i= new Double(posting_id).shortValue();
				this.posting_id = i; 
			}
		} catch (NullPointerException ne) {
			this.posting_id = null;
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}
	
	//for  Area of business
	public String getArea_business() {
		return area_business;
	}
	public void setArea_business(String area_business) {
		try {
			if (area_business.isEmpty()) {
				this.area_business= null;
			}
			else {
				this.area_business = area_business;
			}
		} catch (NullPointerException ne) {
			this.area_business = null;
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}
	
	//for Total Open Amount
	public Double getTotal_open_amount() {
		return total_open_amount;
	}
	public void setTotal_open_amount(String total_open_amount) {
		try {
			if (total_open_amount.isEmpty()) {
				this.total_open_amount = null;
			}
			else {
				Double parsed_total_open_amount = Double.parseDouble(total_open_amount);
				this.total_open_amount = parsed_total_open_amount; 
			}
		} catch (NullPointerException ne) {
			this.total_open_amount = null;
		} catch (Exception e) {
			e.printStackTrace();		
		}	
	}
	
	//for Baseline Create Date
	public java.sql.Date getBaseline_create_date() {
		return baseline_create_date;
	}
	public void setBaseline_create_date(String baseline_create_date) {
		
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	    java.util.Date parsed2 = null;
	    java.sql.Date sql_baseline_date = null;
		try {
			if (baseline_create_date.isEmpty()) {
				this.baseline_create_date = null;
			}
			else {
				parsed2 = sdf.parse(baseline_create_date);
				sql_baseline_date = new java.sql.Date(parsed2.getTime());
				this.baseline_create_date = sql_baseline_date;
			}
		} catch (ParseException pe) {
			pe.printStackTrace();
		} catch (NullPointerException ne) {
			this.baseline_create_date= null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//for Customer payment Terms
	public String getCust_payment_terms() {
		return cust_payment_terms;
	}
	public void setCust_payment_terms(String cust_payment_terms) {
		try {
			if (cust_payment_terms.isEmpty()) {
				this.cust_payment_terms= null;
			}
			else {
				this.cust_payment_terms = cust_payment_terms;
			}
		} catch (NullPointerException ne) {
			this.cust_payment_terms = null;
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}
	
	//for Invoice ID
	public Long getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(String invoice_id) {
		try {
			if (invoice_id.isEmpty()) {
				this.invoice_id = null;
			}
			else {
				Long i= new Double(invoice_id).longValue();
				this.invoice_id = i; 
			}
		} catch (NullPointerException ne) {
			this.invoice_id = null;
		} catch (Exception e) {
			e.printStackTrace();		
		}		
	}
	
	//for IsOpen
	public Short getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(String isOpen) {
		try {
			if(isOpen.isEmpty()) {
				this.isOpen = null;
			}
			else {
				Short parsed_isOpen = Short.parseShort(isOpen);
				this.isOpen = parsed_isOpen; 
			}
		} catch (Exception e) {
			e.printStackTrace();		
		}	
	}	
}

