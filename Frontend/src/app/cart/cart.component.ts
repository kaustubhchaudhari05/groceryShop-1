import { Component, EventEmitter, Inject, OnInit, Output } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA, MatDialog } from '@angular/material/dialog';
import { CategoryService } from '../service/category.service';
import { PurchaseService } from '../service/purchase.service';
import { Product } from '../model/products';
import { ProductsComponent } from '../products/products.component';
@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  @Output() callFunctionEventEmitter = new EventEmitter();

  products!: Product[];
  mergedList!: any[];
  total = 0;
  productsComponent!: ProductsComponent;
  constructor(
    private dialogRef: MatDialogRef<CartComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private categoryService: CategoryService,
    private purchaseService: PurchaseService
  ) {}

  ngOnInit() {
    this.categoryService.findAllProducts().subscribe(data => {
      this.products = data;
      this.mergedList = this.data.product.map((t1: { productId: number; }) => ({
        ...t1,
        ...this.products.find(t2 => t2.id === t1.productId)
      }));

      this.calculateTotal();
    });
  }
  removeItem(id: any){
    this.callFunctionEventEmitter.emit(id);
    let filteredProducts = this.data.product.filter((item: { productId: any; }) => item.productId !== id )
    this.data.product = filteredProducts;
    this.ngOnInit();
  }

  closeMe() {
    this.dialogRef.close();
  }

  pSuccessfull() {
    console.log(this.data);
    this.purchaseService.addpurchase(this.data).subscribe(
    );
    alert('Purchase Successful');
    this.data.product = [];
    this.ngOnInit();
    this.dialogRef.close({data: "Success"});
  }

  private calculateTotal() {
    this.total = this.mergedList.reduce((sum, item) => sum + +item.sellPrice, 0);
  }
  
}
