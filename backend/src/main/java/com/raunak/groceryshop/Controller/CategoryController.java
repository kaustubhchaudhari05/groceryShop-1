package com.raunak.groceryshop.Controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raunak.groceryshop.Entity.Category;
import com.raunak.groceryshop.Service.CategoryService;


@RestController
@RequestMapping("/category")
public class CategoryController {
	
	private final CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
		
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/all")
    public Iterable<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE )
    public String createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return "Category Created";
    }
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/byid")
    public Category getCategoryById(@RequestBody Integer id) {
        return categoryService.getCategorybyId(id);
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/editById")
    public Category getCategoryById(@RequestBody Category cat) {
        return categoryService.editCategorybyId(cat);
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deleteById")
    public ResponseEntity<Object> deleteCategoryById(@RequestBody Integer id) {
        return categoryService.deleteCategorybyId(id);
    }
	
}
