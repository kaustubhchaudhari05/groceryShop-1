import { Component, Inject} from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA} from  '@angular/material/dialog';
import { CategoryService } from '../service/category.service';
import { Category} from '../model/category';
import { FormControl, FormGroup } from '@angular/forms';
@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css']
})
export class AddCategoryComponent{
  categories! : Category[];
  categoryNameControl = new FormControl('');
  constructor(private  dialogRef:  MatDialogRef<AddCategoryComponent>, @Inject(MAT_DIALOG_DATA) public  data:  any, private CategoryService : CategoryService) {
  }

  public  closeMe() {
      this.dialogRef.close();
  }

  public addCategory() {  
    
    const categoryName1 = this.categoryNameControl.value;

    if (categoryName1!.trim() !== '') {

      const newCategory: Category = {
        id: '0',
        categoryName : categoryName1!
      };
      //console.log(newCategory);
      this.CategoryService.addCategory(newCategory).subscribe(
        
      );
      alert('Category Created');
      this.dialogRef.close();
    } else {
      alert('Category name cannot be empty.');
    }
  }
}
