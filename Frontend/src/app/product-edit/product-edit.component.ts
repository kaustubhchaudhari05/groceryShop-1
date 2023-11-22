import { Component, Inject, OnInit } from '@angular/core';
import { Category } from '../model/category';
import { FormControl } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { CategoryService } from '../service/category.service';
import { Product } from '../model/products';
@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  products! : Product;
  editedproducts! : Product;
  returnedProductName : String = '';
  returneQuantity: number = 0;
  returnedSellPrice: number = 0;
  returnedId: number = 0;
  returnedExpiryDate: String = '';
  returnedCostPrice: number = 0;
  returnedCatagory: String ='' ;
  categories!: Category[];
  productName = new FormControl('');
  quantity = new FormControl('');
  sellPrice = new FormControl('');
  category = new FormControl('');

  constructor(private  dialogRef:  MatDialogRef<ProductEditComponent>, @Inject(MAT_DIALOG_DATA) public  data:  number, private CategoryService : CategoryService) {
  }
  ngOnInit(): void {
    //console.log(this.data)
    this.CategoryService.getProductById(this.data).subscribe((data) => {
      this.products = data;
      this.returnedProductName = this.products.productName;
      this.returneQuantity = this.products.quantity;
      this.returnedSellPrice = this.products.sellPrice;
      this.returnedId = this.products.id;
      this.returnedExpiryDate = this.products.exipryDate;
      this.returnedCostPrice = this.products.costPrice;
      this.returnedCatagory = this.products.category;
    });
    this.CategoryService.findAllCategory().subscribe((data) => {
      this.categories = data;
      //console.log(this.categories)
    });
  }

  editProduct() {
    const productName = new FormControl(this.returnedProductName);
    const quantity = new FormControl(this.returneQuantity.toString());
    const sellPrice = new FormControl(this.returnedSellPrice.toString());
    const category = new FormControl(this.returnedCatagory);

    const editedProductName= productName.value?.trim();
    const editedQuantity = quantity.value;
    const editedSellPrice = sellPrice.value;
    const editedCategory = category.value;
    //console.log(editedSellPrice);
    //console.log(editedSellPrice);
    if(editedProductName !== ''|| editedCategory !== null)
    {
      this.editedproducts =  
      {
        id: this.returnedId,
        category : editedCategory!,
        productName: editedProductName! ,
        quantity : parseInt(editedQuantity!),
        sellPrice: parseInt(editedSellPrice!),
        costPrice: this.returnedCostPrice,
        exipryDate: this.returnedExpiryDate
      }
      //console.log(this.editedproducts);
      this.CategoryService.editProduct(this.editedproducts).subscribe((data) => {
      });
      alert("Success");
      this.dialogRef.close();
      
    }
  }
}
