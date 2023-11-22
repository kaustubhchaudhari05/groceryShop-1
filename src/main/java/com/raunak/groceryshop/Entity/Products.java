package com.raunak.groceryshop.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	@Column(name = "product_name", nullable = false)
	private String productName;
	@Column(name = "quantity", nullable = false)
	private Integer quantity;
	@Column(name = "sell_price", nullable = false)
	private Integer sellPrice;
	@Column(name = "cost_price")
	private Integer costPrice;
	@Column(name = "expiry", nullable = false)
	private String exipryDate;
	@Column(name = "category", nullable = false)
	private Integer category;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(Integer sellPrice) {
		this.sellPrice = sellPrice;
	}
	public Integer getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(Integer costPrice) {
		this.costPrice = costPrice;
	}
	public String getExipryDate() {
		return exipryDate;
	}
	public void setExipryDate(String exipryDate) {
		this.exipryDate = exipryDate;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
}