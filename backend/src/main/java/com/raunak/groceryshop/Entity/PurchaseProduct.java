package com.raunak.groceryshop.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchase_products")
public class PurchaseProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	@Column(name = "purchase_id", nullable = false)
	private Integer purchseId ;
	
	@Column(name = "product_id", nullable = false)
	private Integer productId ;
	
	@Column(name = "product_quantity", nullable = false)
	private Integer productQuantity ;

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

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

}
