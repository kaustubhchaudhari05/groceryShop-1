import { Component, OnInit, ViewChild } from '@angular/core';
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

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css'],
  standalone: true,
  imports: [CommonModule, MatBadgeModule, MatExpansionModule, MatButtonModule],
})
export class ProductsComponent implements OnInit {
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
    const userDob = new Date(this.loggedInUser?.dob!);
    if(userDob.getDate() == this.today.getDate() && userDob.getMonth() == this.today.getMonth()){
      alert("Happy Birthday "+ this.loggedInUser?.fullName + "! You are eligible for "+ this.loggedInUser?.age+"% Discount");
    }
  }

  addtocart(item: any) {
    const existingProductIndex = this.cartPrdoucts.findIndex((p) => p.productId === item.id);

    if (existingProductIndex !== -1) {
      this.cartPrdoucts[existingProductIndex].productQuantity++;
    } else {
      const product: cartprdoucts = {
        productId: item.id,
        productQuantity: 1,
      };
      this.cartPrdoucts.push(product);
    }

    this.updateCart();
  }

  updateCart() {
    this.cartPurchase.product = this.cartPrdoucts;
    this.cartItemCount = this.cartPurchase.product.length;
    this.cartPurchase.userId = parseInt(this.loggedInUser!.id);
    const userDob = new Date(this.loggedInUser?.dob!);
    if(userDob.getDate() == this.today.getDate() && userDob.getMonth() == this.today.getMonth()){
      this.cartPurchase.discount = this.loggedInUser!.age;
    }
  }

  showCart() {
    const dialogRef = this.dialog.open(CartComponent, { 
      data: this.cartPurchase,
      width: '60%'
    });
    console.log(this.cartPurchase);
    dialogRef.afterClosed().subscribe((data) => {
      console.log(data);
      if(data !== undefined){
      this.cartPrdoucts = [] ;
      this.cartItemCount = 0;
      }
    });
    const sub = dialogRef.componentInstance.callFunctionEventEmitter.subscribe((data: any) => {
      this.removeItem(data);
    });
  }

  removeItem(id: any){
    let filteredProducts = this.cartPrdoucts.filter((item: { productId: any; }) => item.productId !== id )
    this.cartPrdoucts = filteredProducts;
    this.updateCart();
  }
  }