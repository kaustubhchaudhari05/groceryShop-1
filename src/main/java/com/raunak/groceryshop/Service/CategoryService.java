package com.raunak.groceryshop.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raunak.groceryshop.Entity.Category;
import com.raunak.groceryshop.Repo.CategoryRepository;
import com.raunak.groceryshop.Repo.ProductsRepository;

import ErrorResponce.ResponseHandler;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	private final ProductsRepository productRepository;
	
	public CategoryService(CategoryRepository categoryRepository, ProductsRepository productRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
		
	}
    
    public Iterable<Category> getAllCategory() {
        return categoryRepository.findAll();
    }
    
    public Category createCategory(Category category) {
    	Category c = new Category();
        c.setCategoryName(category.getCategoryName());
        Category savedCategory = categoryRepository.save(c);
        return savedCategory;
    }
    
    public Category getCategorybyId(Integer id) {
		Category category = categoryRepository.findById(id).get();
    	return category;
    }
    @Transactional
    public ResponseEntity<Object> deleteCategorybyId(Integer id) {
		try{
			categoryRepository.deleteById(id);
			productRepository.deleteByCatagory(id);
			return ResponseHandler.generateResponse("Sucessfully Deleted", HttpStatus.OK, null);
		}catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
    }
    
    public Category editCategorybyId(Category category) {
		Category editedCategory = categoryRepository.findById(category.getId()).get();
		editedCategory.setCategoryName(category.getCategoryName());
		Category savedCategory = categoryRepository.save(editedCategory);
    	return savedCategory;
    }
}
