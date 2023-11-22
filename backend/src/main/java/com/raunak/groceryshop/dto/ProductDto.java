package com.raunak.groceryshop.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Product Information")
public class ProductDto {
	
	@ApiModelProperty(value = "Product ID", example="1")
    private Integer id;
	@ApiModelProperty(value = "Product Name", example="1")
	private String productName;
	@ApiModelProperty(value = "Product Quantity", example="1")
	private Integer quantity;
	@ApiModelProperty(value = "Product Selling Price", example="1")
	private Integer sellPrice;
	@ApiModelProperty(value = "Product Expiry Date", example="1")
	private String exipryDate;
	@ApiModelProperty(value = "Product Category Name", example="1")
	private String categoryName;
	
	public ProductDto() {}
	public ProductDto(Integer id, String productName, Integer quantity, Integer sellPrice,	String exipryDate, String categoryName) {
		this.id = id;
		this.productName = productName;
		this.quantity = quantity;
		this.sellPrice = sellPrice;
		this.exipryDate = exipryDate;
		this.categoryName = categoryName;
	}

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


	public String getExipryDate() {
		return exipryDate;
	}

	public void setExipryDate(String exipryDate) {
		this.exipryDate = exipryDate;
	}


	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	
	

}
