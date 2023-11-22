import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CartComponent } from '../cart/cart.component';
import { CategoryService } from '../service/category.service';
import { CatWiseProducts } from '../model/category';
import { cartprdoucts, cartpurchase } from '../model/cartpurchase';
import { MatDialog } from '@angular/material/dialog';
import { MatBadgeModule } from '@angular/material/badge';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatButtonModule } from '@angular/material/button';
import { User } from '../model/user';
import { UserStateService } from '../service/user-state.service';
import { ProductEditComponent } from '../product-edit/product-edit.component';
import { ProductAddComponent } from '../product-add/product-add.component';
@Component({
  selector: 'app-products-employee',
  templateUrl: './products-employee.component.html',
  styleUrls: ['./products-employee.component.css'],
  standalone: true,
  imports: [CommonModule, MatBadgeModule, MatExpansionModule, MatButtonModule],
})
export class ProductsEmployeeComponent implements OnInit {
  categories!: CatWiseProducts[];
  cartPrdoucts: cartprdoucts[] = [];
  cartPurchase: cartpurchase = {
    purchaseId: '',
    product: [],
    discount: 0,
    userId: 0,
  };
  today = new Date();
  loggedInUser: User | null = null;
  cartItemCount: number = 0;

  constructor(private dialog: MatDialog, private categoryService: CategoryService,  private userStateService: UserStateService) {}

  ngOnInit() {
    this.categoryService.findAllCatWiseProduct().subscribe((data) => {
      this.categories = data;
    });
      this.userStateService.loggedInUser$.subscribe(user => {
      this.loggedInUser = user;
    });
    
  }
  editProd(prodId: number){
    console.log(prodId);
    this.dialog.open(ProductEditComponent, { 
      data: this.cartPurchase, 
      width: '40%'
    });
  }
  addProd(){
    this.dialog.open(ProductAddComponent, { 
      data: this.cartPurchase, 
      width: '40%'
    });
  }
  }
