package com.raunak.groceryshop.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raunak.groceryshop.Entity.Products;
import com.raunak.groceryshop.Service.ProductsService;
import com.raunak.groceryshop.dto.CategoryWiseProductDto;
import com.raunak.groceryshop.dto.ProductDto;

@RestController
@RequestMapping("/products")
public class ProductController {
	public final ProductsService productService;
	
	public ProductController(ProductsService productService) {
		this.productService = productService;
	}

//    @GetMapping("/all")
//    public List<Products> getAllProducts() {
//        return (List<Products>) productService.getAllProducts();
//    }
	@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/allProducts")
    public List<ProductDto> getAllProductswithCat() {
        return (List<ProductDto>) productService.getAllProductswithCat();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/allProductWithCat")
    public List<CategoryWiseProductDto> getAllCatWiseProduct() {
        return (List<CategoryWiseProductDto>) productService.catWiseProduct();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/getProductById")
    public Products getProductById(@RequestBody Integer id) {
        return productService.getProductsById(id);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/editProduct")
    public Products editProduct(@RequestBody Products product) {
        return productService.editProduct(product);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addProduct")
    public Products addProduct(@RequestBody Products product) {
        return productService.addProduct(product);
    }
    

}
