import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Category, CatWiseProducts} from '../model/category';
import { Observable } from 'rxjs';
import { Product } from '../model/products';

@Injectable({
  providedIn: 'root'
})

export class CategoryService {
  private getcategorysUrl: string;
  private addcategorysUrl: string;
  private getcatwiseProductUrl: string;
  private getallProductUrl: string;
  private getCategoryByIdUrl: string;
  private editCategoryUrl: string;
  private editProductUrl: string;
  private getProductByIdUrl: string;
  private addProductUrl: string;

  constructor(private http: HttpClient) {
    this.getcategorysUrl = 'http://localhost:8080/category/all';
    this.addcategorysUrl = 'http://localhost:8080/category/create';
    this.getcatwiseProductUrl = 'http://localhost:8080//products/allProductWithCat';
    this.getallProductUrl = 'http://localhost:8080//products/allProducts';
    this.getCategoryByIdUrl = 'http://localhost:8080/category/byid';
    this.editCategoryUrl = 'http://localhost:8080/category/editById';
    this.getProductByIdUrl = 'http://localhost:8080/products/getProductById';
    this.editProductUrl = 'http://localhost:8080/products/editProduct';
    this.addProductUrl = 'http://localhost:8080/products/addProduct';
  }

  public findAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.getallProductUrl);
  }
  public findAllCategory(): Observable<Category[]> {
    return this.http.get<Category[]>(this.getcategorysUrl);
  }
  public findAllCatWiseProduct(): Observable<CatWiseProducts[]> {
    return this.http.get<CatWiseProducts[]>(this.getcatwiseProductUrl);
  }
  public addCategory(category : Category) {
    return this.http.post<Category>(this.addcategorysUrl, category);
  }
  public getCategoryById(id: number) {
    return this.http.post<Category>(this.getCategoryByIdUrl, id);
  }
  public editCategory(category: Category) {
    return this.http.put<Category>(this.editCategoryUrl, category );
  }
  public getProductById(id: number) {
    return this.http.post<Product>(this.getProductByIdUrl, id );
  }
  public editProduct(product: Product) {
    return this.http.put<Product>(this.editProductUrl, product );
  }
  public addProduct(product: Product) {
    return this.http.post<Product>(this.addProductUrl, product );
  }
}
