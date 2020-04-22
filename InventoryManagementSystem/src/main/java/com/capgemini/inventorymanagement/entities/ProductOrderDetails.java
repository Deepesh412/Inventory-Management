package com.capgemini.inventorymanagement.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;



@Entity
@Table(name = "productOrderDetails")
public class ProductOrderDetails {
	
	@Id
	private int order_id;	
	private String Item_name;
	private int quantity_unit;
	private double price_per_unit;
	private double total_price;
	

	private Date order_date;
	
	
	private Date delivery_date;
	

	private String delivery_status;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "supplier_id")
	private DistributorDetails distributordetails;
	
	public double getPrice_per_unit() {
		return price_per_unit;
	}
	public void setPrice_per_unit(double price_per_unit) {
		this.price_per_unit = price_per_unit;
	}

	
	public DistributorDetails getDistributordetails() {
		return distributordetails;
	}
	public void setDistributordetails(DistributorDetails distributordetails) {
		this.distributordetails = distributordetails;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getItem_name() {
		return Item_name;
	}
	public void setItem_name(String item_name) {
		Item_name = item_name;
	}
	public int getQuantity_unit() {
		return quantity_unit;
	}
	public void setQuantity_unit(int quantity_unit) {
		this.quantity_unit = quantity_unit;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public Date getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}
	public String getDelivery_status() {
		return delivery_status;
	}
	public void setDelivery_status(String delivery_status) {
		this.delivery_status = delivery_status;
	}
	}
