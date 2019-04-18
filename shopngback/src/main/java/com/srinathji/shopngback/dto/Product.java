package com.srinathji.shopngback.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnoreProperties(ignoreUnknown = true)
	private int id;
	private String code;
	@NotBlank(message = "Plese Enter Product Name!")
	private String name;
	@NotBlank(message = "Plese Enter Brand Name!")
	private String brand;
	@NotBlank(message = "Plese Enter Descreption!")
	private String descreption;
	@Column(name = "unit_price")
	@Min(value = 1, message = "The Prize is cannot be lesthen 1! ")
	private double unitPrice;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private int quntity;
	@JsonIgnore
	@Column(name = "is_active")
	private boolean active;
	@JsonIgnore
	@Min(value = 1, message = "plese select Category valid categery!! ")
	@Column(name = "category_id")
	private int categoryid;
	@JsonIgnore
	@Column(name = "suplier_id")
	private int suplierid;
	private int purchases;
	private int views;
	@Transient
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Product() {
		this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}

	public Product(String name, String brand, String descreption, double unitPrice, int quntity, boolean active,
			int categoryid, int suplierid, int purchases, int views) {

		this.name = name;
		this.brand = brand;
		this.descreption = descreption;
		this.unitPrice = unitPrice;
		this.quntity = quntity;
		this.active = active;
		this.categoryid = categoryid;
		this.suplierid = suplierid;
		this.purchases = purchases;
		this.views = views;
		this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescreption() {
		return descreption;
	}

	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuntity() {
		return quntity;
	}

	public void setQuntity(int quntity) {
		this.quntity = quntity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public int getSuplierid() {
		return suplierid;
	}

	public void setSuplierid(int suplierid) {
		this.suplierid = suplierid;
	}

	public int getPurchases() {
		return purchases;
	}

	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}

	public int getViews() {
		return views;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setViews(int views) {
		this.views = views;
	}

}
