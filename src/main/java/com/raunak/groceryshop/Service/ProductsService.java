package com.raunak.groceryshop.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.raunak.groceryshop.Entity.Category;
import com.raunak.groceryshop.Entity.Products;
import com.raunak.groceryshop.Repo.CategoryRepository;
import com.raunak.groceryshop.Repo.ProductsRepository;
import com.raunak.groceryshop.dto.CategoryWiseProductDto;
import com.raunak.groceryshop.dto.ProductDto;

@Service
public class ProductsService {
	private final ProductsRepository productRepository;
	private CategoryRepository categoryRepository;
	
	public ProductsService(ProductsRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		
	}
	
	
	
    public Iterable<Products> getAllProducts() {
        return productRepository.findAll();
    }
    
    public Products getProductsById(Integer id ) {
        return productRepository.findById(id).get();
    }
    public Products editProduct(Products product) {
    	Products editedProduct = productRepository.findById(product.getId()).get();
    	editedProduct.setProductName(product.getProductName());
    	editedProduct.setQuantity(product.getQuantity());
    	editedProduct.setSellPrice(product.getSellPrice());
    	editedProduct.setCategory(product.getCategory());
    	productRepository.save(editedProduct);
        return editedProduct;
    }
    public Products addProduct(Products product) {
    	LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = formatter.format(currentDate);
    	Products newProduct = new Products();
    	newProduct.setProductName(product.getProductName());
    	newProduct.setQuantity(product.getQuantity());
    	newProduct.setSellPrice(product.getSellPrice());
    	newProduct.setCategory(product.getCategory());
    	newProduct.setCostPrice(product.getCostPrice());
    	newProduct.setExipryDate(formattedDate);
    	productRepository.save(newProduct);
        return newProduct;
    }
    
    public Iterable<ProductDto> getAllProductswithCat() {
    	Iterable<Products> p = productRepository.findAll();
    	Iterable<Category> c = categoryRepository.findAll();
    	List<ProductDto> productDtos = new ArrayList<>();
    	
    	for (Products products : p) {
    		ProductDto productDto = convertToProductDto(products, c);
    		productDtos.add(productDto);
        }
    	return productDtos;   
    }
    
	    
	    private ProductDto convertToProductDto(Products product, Iterable<Category> c) {
    	ProductDto productsDto = new ProductDto();
    	productsDto.setId(product.getId());
    	productsDto.setProductName(product.getProductName());
    	productsDto.setQuantity(product.getQuantity());
    	productsDto.setSellPrice(product.getSellPrice());
    	productsDto.setExipryDate(product.getExipryDate());
    	
    	for (Category cat : c) {
    		if(product.getCategory() == Math.toIntExact(cat.getId()) ) {
    			productsDto.setCategoryName(cat.getCategoryName());
    			break;
    		}
    		else {
    			productsDto.setCategoryName("NULL");
    		}	
    	}
		return productsDto;
    }
	
	    public Iterable<CategoryWiseProductDto> catWiseProduct() {
	    	Iterable<ProductDto> p = this.getAllProductswithCat();
	    	Iterable<Category> c = categoryRepository.findAll();
	    	
	    	List<CategoryWiseProductDto> catWiseProductDtos = new ArrayList<>();
	    	
	    	for (Category cat : c) {
	    		CategoryWiseProductDto catWiseProductDto = new CategoryWiseProductDto();
	    		List<ProductDto> catProduct = new ArrayList<>();
	    		catWiseProductDto.setId(cat.getId());
	    		catWiseProductDto.setCategoryName(cat.getCategoryName());
		    	for (ProductDto product : p) {
		    		
		    		if(cat.getCategoryName()== product.getCategoryName()) {
		    			catProduct.add(product);
		    		}
		        }
		    	catWiseProductDto.setProducts(catProduct);
		    	catWiseProductDtos.add(catWiseProductDto);
	    	}
	    	return catWiseProductDtos;
	    }
}
