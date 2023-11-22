package com.raunak.groceryshop.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.raunak.groceryshop.Entity.Category;

@Component
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
