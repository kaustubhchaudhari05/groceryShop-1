package com.raunak.groceryshop.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "discounts")
public class Discounts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	@Column(name = "purchase_id", nullable = false)
	private Integer purchseId ;
	
	@Column(name = "discount_percentage", nullable = false)
	private Integer discountPercent ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPurchseId() {
		return purchseId;
	}

	public void setPurchseId(Integer purchseId) {
		this.purchseId = purchseId;
	}

	public Integer getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Integer discountPercent) {
		this.discountPercent = discountPercent;
	}
	
	
}
