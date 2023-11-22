package com.raunak.groceryshop.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.raunak.groceryshop.Entity.PurchaseProduct;
import com.raunak.groceryshop.Repo.PurchaseProductRepo;

@Service
public class PurchaseProductsService {

	private final PurchaseProductRepo purchaseProductRepo;

    public PurchaseProductsService(PurchaseProductRepo purchaseProductRepo) {
        this.purchaseProductRepo = purchaseProductRepo;
    }
    
    public List<PurchaseProduct> getAllPurchaseProducts() {
        return (List<PurchaseProduct>) purchaseProductRepo.findAll();
    }
}
