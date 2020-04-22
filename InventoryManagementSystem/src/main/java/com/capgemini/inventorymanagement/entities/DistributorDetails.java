package com.capgemini.inventorymanagement.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "distributordetails")
public class DistributorDetails {
	@Id
	private int id;
	private String distributor_name;
	private String product_name;
	private String address;
	private String phonenumber;
	private String email_id;
	
	@OneToOne(mappedBy = "distributordetails")
	
	private ProductOrderDetails productorderdetails;
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDistributor_name() {
		return distributor_name;
	}

	public void setDistributor_name(String distributor_name) {
		this.distributor_name = distributor_name;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public ProductOrderDetails getProductorderdetails() {
		return productorderdetails;
	}

	public void setProductorderdetails(ProductOrderDetails productorderdetails) {
		this.productorderdetails = productorderdetails;
	}

	}
