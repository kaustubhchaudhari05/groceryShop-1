import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Category, CatWiseProducts} from '../model/category';
import { cartpurchase } from '../model/cartpurchase';
import { purchaseDetails } from '../model/purchaseDetails';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PurchaseService {
  private addpurchasesUrl: string;
  private getpurchasesUrl: string;

  constructor(private http: HttpClient) {
    this.addpurchasesUrl = 'http://localhost:8080/addpurchases';
    this.getpurchasesUrl = 'http://localhost:8080/purchases';

  }
  public addpurchase(cartpurchase : cartpurchase) {
    return this.http.post<Category>(this.addpurchasesUrl, cartpurchase);
  }
  public getpurchase(): Observable<purchaseDetails[]> {
    return this.http.get<purchaseDetails[]>(this.getpurchasesUrl);
  }
}
