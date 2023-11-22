package com.raunak.groceryshop.dto;

import java.util.List;

public class PurchaseDto {
	private Integer purchaseId;
	
	private Integer userId;
	
	private List<productsCalled> product;
	
	private Integer discount;
	
	public PurchaseDto() {
		
	}

	public Integer getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public List<productsCalled> getProduct() {
		return product;
	}

	public void setProduct(List<productsCalled> product) {
		this.product = product;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	
	public static class productsCalled {
		Integer productId;
		Integer ProductQuantity;
		
		public Integer getProductId() {
			return productId;
		}
		public void setProductId(Integer productId) {
			this.productId = productId;
		}
		public Integer getProductQuantity() {
			return ProductQuantity;
		}
		public void setProductQuantity(Integer productQuantity) {
			ProductQuantity = productQuantity;
		}
	}
}