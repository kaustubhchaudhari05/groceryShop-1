package com.raunak.groceryshop.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.raunak.groceryshop.Entity.Products;
public interface ProductsRepository extends JpaRepository<Products, Integer>{
	
	@Modifying
    @Query("delete from Products p where p.category = :categoryId")
    void deleteByCatagory(Integer categoryId);
	
}
