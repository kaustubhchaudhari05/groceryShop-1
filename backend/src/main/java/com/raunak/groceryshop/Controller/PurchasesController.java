package com.raunak.groceryshop.Controller;

import com.raunak.groceryshop.Entity.AllPurchase;
import com.raunak.groceryshop.Service.PurchasesService;
import com.raunak.groceryshop.dto.PurchaseDto;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PurchasesController {
    private final PurchasesService purchaseService;

    public PurchasesController(PurchasesService purchaseService) {
        this.purchaseService = purchaseService;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/purchases")
    public List<AllPurchase> getAllPurchases() {
        return purchaseService.findAllPurchase();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addpurchases")
    public String getAllPurchases(@RequestBody PurchaseDto purchaseDto) {
        return purchaseService.addPurchase(purchaseDto);
    }
}
