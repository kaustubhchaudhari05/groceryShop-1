package com.raunak.groceryshop.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raunak.groceryshop.Entity.AllPurchase;
import com.raunak.groceryshop.Entity.Discounts;
import com.raunak.groceryshop.Entity.Products;
import com.raunak.groceryshop.Entity.PurchaseProduct;
import com.raunak.groceryshop.Entity.Purchases;
import com.raunak.groceryshop.Entity.User;
import com.raunak.groceryshop.Repo.AllPurchaseRepo;
import com.raunak.groceryshop.Repo.DiscountsRepository;
import com.raunak.groceryshop.Repo.ProductsRepository;
import com.raunak.groceryshop.Repo.PurchaseProductRepo;
import com.raunak.groceryshop.Repo.PurchasesRepository;
import com.raunak.groceryshop.Repo.UserRepository;
import com.raunak.groceryshop.dto.PurchaseDto;
import com.raunak.groceryshop.dto.PurchaseDto.productsCalled;

@Service
public class PurchasesService {
    private final AllPurchaseRepo allPurchaseRepo;
    private final PurchasesRepository purchaseRepo;
    private final PurchaseProductRepo purproductRepo;
    private final DiscountsRepository discountRepo;
    private final ProductsRepository productRepo;
    private final UserRepository userRepository;

    public PurchasesService(AllPurchaseRepo allPurchaseRepo, PurchasesRepository purchaseRepo, PurchaseProductRepo purproductRepo, DiscountsRepository discountRepo, ProductsRepository productRepo, UserRepository userRepository ) {
        this.allPurchaseRepo = allPurchaseRepo;
        this.purchaseRepo =purchaseRepo;
        this.purproductRepo =purproductRepo;
        this.discountRepo = discountRepo;
        this.productRepo = productRepo;
        this.userRepository = userRepository;
    }

    public List<AllPurchase> findAllPurchase() {
    	List<AllPurchase> allPurchases= allPurchaseRepo.findAll();
    	 return allPurchases;
    }
    private AllPurchase mapToAllPurchase(PurchaseDto purchaseDto, productsCalled product) {
        AllPurchase allPurchase = new AllPurchase();
        @SuppressWarnings("deprecation")
        Products product1 = productRepo.getById(product.getProductId());
        allPurchase.setPurchaseProduct(product1.getProductName());
        allPurchase.setPurchaseRate(product1.getSellPrice());
        @SuppressWarnings("deprecation")
        User user = userRepository.getById(purchaseDto.getUserId());
        String fullName = user.getFirstName()+ user.getLastName();
        allPurchase.setGender(user.getGender());
        allPurchase.setPurchaseUser(fullName);
        
        allPurchase.setPurchaseQuantity(product.getProductQuantity());
        allPurchase.setPurchaseDiscount(purchaseDto.getDiscount());
        allPurchase.setPurchaseDate(LocalDate.now().toString());
        return allPurchase;
    }
    
    @Transactional
    public String addPurchase(PurchaseDto purchase) {
    	Purchases p = new Purchases();
    	p.setPurchseUser(purchase.getUserId());
    	Purchases purchaseSaved = this.purchaseRepo.save(p);

    	List<Products> products = (List<Products>) productRepo.findAll();
    	Integer[] ProductIds = new Integer[products.size()];
    	
    	for (int i = 0; i < products.size(); i++) {
    		ProductIds[i] = products.get(i).getId();
        }
    	
    	for (productsCalled product : purchase.getProduct()) {
    		boolean found = false;
    		for (int n : ProductIds) {
		      if (n == product.getProductId()) {
		        found = true;
		        break;
		      }
    		}
    		if(found) {
    	    	PurchaseProduct pp = new PurchaseProduct();
    	    	pp.setProductId(product.getProductId());
    	    	pp.setProductQuantity(product.getProductQuantity());
    	    	pp.setPurchseId(purchaseSaved.getId());
    	    	this.purproductRepo.save(pp);
    		}
    		@SuppressWarnings("deprecation")
			Products product1 = productRepo.getById(product.getProductId());
    		product1.setQuantity(product1.getQuantity() - product.getProductQuantity());
    		productRepo.save(product1);
    	}

    	
    	Discounts d = new Discounts();
    	d.setDiscountPercent(purchase.getDiscount());
    	d.setPurchseId(purchaseSaved.getId());
    	this.discountRepo.save(d);
    	
    	for (productsCalled product : purchase.getProduct()) {
            AllPurchase allPurchase = mapToAllPurchase(purchase, product);
            allPurchase.setPurchaseId(purchaseSaved.getId());
            allPurchaseRepo.save(allPurchase);
        }
    	return "Saved";
    }
}
