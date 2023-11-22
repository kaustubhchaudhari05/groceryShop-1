package com.raunak.groceryshop.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raunak.groceryshop.Entity.AllPurchase;
import com.raunak.groceryshop.Entity.Purchases;

public interface AllPurchaseRepo extends JpaRepository<AllPurchase, Long>{
	//@Query("SELECT new com.raunak.groceryshop.Entity.AllPurchase(p.id as purchaseId, concat(u.fname, ' ', u.Lname) as purchaseUser, pd.product_name as purchaseProduct, pd.sell_price as purchaseRate, pp.product_quantity as purchaseQuantity, d.discount_percentage as purchaseDiscount, p.purchase_date as purchaseDate, u.gender as gender) " +
//		       "From purchase p " +
//		       "inner Join purchase_products pp on p.id = pp.purchase_id " +
//		       "Inner Join discounts d on p.id = d.purchase_id " +
//		       "Inner Join users u on u.id = p.purchase_user " +
//		       "Inner join products pd on pd.id = pp.product_id")
	@Query(value= "Select p.id as purchaseId, concat(u.fname, ' ', u.Lname) as purchaseUser, pd.product_name as purchaseProduct, pd.sell_price as purchaseRate, pp.product_quantity as purchaseQuantity, d.discount_percentage as purchaseDiscount, p.purchase_date as purchaseDate, u.gender as gender From purchase p inner Join purchase_products pp on p.id = pp.purchase_id Inner Join discounts d on p.id = d.purchase_id Inner Join users u on u.id = p.purchase_user Inner join products pd on pd.id = pp.product_id", nativeQuery = true)
	public List<AllPurchase> findAllPurchase();
	
}
