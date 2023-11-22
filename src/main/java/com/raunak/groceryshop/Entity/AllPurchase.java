package com.raunak.groceryshop.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AllPurchase")
public class AllPurchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "prrchase_id")
	private Integer purchaseId;
	
	@Column(name = "fullname")
	private String purchaseUser;
	
	@Column(name = "product_name")
	private String purchaseProduct;
	
	@Column(name = "sell_price")
	private Integer purchaseRate;
	
	@Column(name = "product_quantity")
	private Integer purchaseQuantity;
	
	@Column(name = "discount_percentage")
	private Integer purchaseDiscount;
	
	@Column(name = "purchase_date")
	private String purchaseDate;
	
	@Column(name = "gender")
	private String gender; 

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getPurchaseUser() {
		return purchaseUser;
	}

	public void setPurchaseUser(String purchaseUser) {
		this.purchaseUser = purchaseUser;
	}

	public String getPurchaseProduct() {
		return purchaseProduct;
	}

	public void setPurchaseProduct(String purchaseProduct) {
		this.purchaseProduct = purchaseProduct;
	}

	public Integer getPurchaseRate() {
		return purchaseRate;
	}

	public void setPurchaseRate(Integer purchaseRate) {
		this.purchaseRate = purchaseRate;
	}

	public Integer getPurchaseQuantity() {
		return purchaseQuantity;
	}

	public void setPurchaseQuantity(Integer purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	public Integer getPurchaseDiscount() {
		return purchaseDiscount;
	}

	public void setPurchaseDiscount(Integer purchaseDiscount) {
		this.purchaseDiscount = purchaseDiscount;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
}