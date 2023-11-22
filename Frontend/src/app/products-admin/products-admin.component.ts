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
import { AddCategoryComponent } from '../add-category/add-category.component';
import { ProductEditComponent } from '../product-edit/product-edit.component';
import { ProductAddComponent } from '../product-add/product-add.component';
import { EditCategoryComponent } from '../edit-category/edit-category.component';

@Component({
  selector: 'app-products-admin',
  templateUrl: './Products-admin.component.html',
  styleUrls: ['./Products-admin.component.css'],
  standalone: true,
  imports: [CommonModule, MatBadgeModule, MatExpansionModule, MatButtonModule],
})

export class ProductsAdminComponent implements OnInit {

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
  addCategory() {
    const dialogRef = this.dialog.open(AddCategoryComponent, { 
      data: this.cartPurchase, 
      width: '40%'
    });
    dialogRef.afterClosed().subscribe((data) => {
      this.ngOnInit();
    });
  }

  addProd(){
    const dialogRef = this.dialog.open(ProductAddComponent, { 
      data: this.cartPurchase, 
      width: '40%'
    });
    dialogRef.afterClosed().subscribe((data) => {
      this.ngOnInit();
    });
  }
  editCat(catId: number){
    const dialogRef =this.dialog.open(EditCategoryComponent, { 
      data: catId, 
      width: '40%'
    });
    dialogRef.afterClosed().subscribe((data) => {
      this.ngOnInit() ;
    });

  }
  editProd(prodId: number){
    console.log(prodId);
    const dialogRef = this.dialog.open(ProductEditComponent, { 
      data: prodId, 
      width: '40%'
    });
    dialogRef.afterClosed().subscribe((data) => {
      this.ngOnInit() ;
    });
  }

  }

