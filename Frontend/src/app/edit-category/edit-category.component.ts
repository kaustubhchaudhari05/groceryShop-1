import { Component, Inject, OnInit } from '@angular/core';
import { Category } from '../model/category';
import { FormControl } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { CategoryService } from '../service/category.service';


@Component({
  selector: 'app-edit-category',
  templateUrl: './edit-category.component.html',
  styleUrls: ['./edit-category.component.css'],
})
export class EditCategoryComponent implements OnInit{
  category! : Category;
  categoryName: String = ''
  categoryNameControl = new FormControl('');
  editedCategory! : Category;
   

  constructor(private  dialogRef:  MatDialogRef<EditCategoryComponent>, @Inject(MAT_DIALOG_DATA) public  data:  number, private CategoryService : CategoryService) {
  }
  ngOnInit(): void {
    this.CategoryService.getCategoryById(this.data).subscribe((data) => {
      this.category = data;
      this.categoryName = this.category.categoryName;
    });
  }

  public editCategory() { 
   
    const editedCatName = this.categoryNameControl.value?.trim();
    //console.log(editedCatName);
    if(editedCatName !== '' )
    {
      this.editedCategory =  
      {
        id: this.category.id,
        categoryName: editedCatName!
      }
      this.CategoryService.editCategory(this.editedCategory).subscribe((data) => {
      });
      alert("Success");
      this.dialogRef.close();
      
    }else {
        alert("Enter Valid Category");
    }
  }
}
