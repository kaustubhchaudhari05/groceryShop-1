import { Component, Inject, OnInit } from '@angular/core';
import { Category } from '../model/category';
import { FormControl } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { CategoryService } from '../service/category.service';
import { Product } from '../model/products';
@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent implements OnInit{
  products! : Product;
  categories!: Category[];
  productName = new FormControl('');
  quantity = new FormControl('');
  sellPrice = new FormControl('');
  category = new FormControl('');
  costPrice = new FormControl('');

  constructor(private  dialogRef:  MatDialogRef<ProductAddComponent>, @Inject(MAT_DIALOG_DATA) public  data:  number, private CategoryService : CategoryService) {
  }
  ngOnInit(): void {
    this.CategoryService.findAllCategory().subscribe((data) => {
      this.categories = data;
    });
  }

  addProduct() {
    const editedProductName= this.productName.value?.trim();
    const editedQuantity = this.quantity.value;
    const editedSellPrice = this.sellPrice.value;
    const editedCategory = this.category.value;
    const costPrice = this.costPrice.value;
    if(editedProductName !== ''|| editedCategory !== null)
    {
      this.products =  
      {
        id : 0,
        category : editedCategory!,
        productName: editedProductName! ,
        quantity : parseInt(editedQuantity!),
        sellPrice: parseInt(editedSellPrice!),
        exipryDate: '',
        costPrice: parseInt(costPrice!)
      }
    console.log(editedCategory);

    if(editedCategory !== '' && editedQuantity !== '' && editedSellPrice !== '' && editedProductName !== '' && costPrice !== '' ){
      this.CategoryService.addProduct(this.products).subscribe((data) => {
      });
      alert("Success");
      this.dialogRef.close();
    }
  else{alert("Please enter all the values");}
    }
  }
}
