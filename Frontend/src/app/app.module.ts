import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AccordionModule } from 'primeng/accordion';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserService } from './service/user.service';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProductsComponent } from './products/products.component';
import { ProductsEmployeeComponent } from './products-employee/products-employee.component';
import { ProductsAdminComponent } from './products-admin/products-admin.component';
import { CartComponent } from './cart/cart.component';
import { ReportsComponent } from './reports/reports.component';
import { MatInputModule} from '@angular/material/input';
import { MatButtonModule} from '@angular/material/button';
import { MatCardModule} from '@angular/material/card';
import { MatFormFieldModule} from '@angular/material/form-field';
import { MatDialogModule } from '@angular/material/dialog';
import { AddCategoryComponent } from './add-category/add-category.component';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatBadgeModule } from '@angular/material/badge';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { ProductEditComponent } from './product-edit/product-edit.component';
import { ProductAddComponent } from './product-add/product-add.component';
import { EditCategoryComponent } from './edit-category/edit-category.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    LoginComponent,
    SignupComponent,
    DashboardComponent,
    CartComponent,
    ReportsComponent,
    AddCategoryComponent,
    ProductEditComponent,
    ProductAddComponent,
    EditCategoryComponent
  ],
  imports: [
    BrowserModule, AppRoutingModule, HttpClientModule, BrowserAnimationsModule, ProductsComponent,
    ProductsEmployeeComponent, MatTableModule, MatIconModule, MatBadgeModule, MatListModule,
    ProductsAdminComponent,AccordionModule, CommonModule, MatDialogModule, MatInputModule, 
    MatButtonModule, MatCardModule, MatFormFieldModule,ReactiveFormsModule, MatNativeDateModule, 
    MatDatepickerModule, MatRadioModule, MatSelectModule, MatSnackBarModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
