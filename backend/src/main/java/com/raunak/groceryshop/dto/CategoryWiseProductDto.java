package com.raunak.groceryshop.dto;

import java.util.List;


public class CategoryWiseProductDto {
	
	private Integer id;
	
	private String categoryName;
	
	private List<ProductDto> products;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}
}
