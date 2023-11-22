package com.raunak.groceryshop.Service;

import java.util.List;

import com.raunak.groceryshop.Entity.Discounts;
import com.raunak.groceryshop.Repo.DiscountsRepository;

public class DiscountService {
    
	private final DiscountsRepository discountsRepository;
	
	public DiscountService(DiscountsRepository discountsRepository) {
        this.discountsRepository = discountsRepository;
    }

    public List<Discounts> getAllDiscounts() {
        return (List<Discounts>) discountsRepository.findAll();
    }

}
