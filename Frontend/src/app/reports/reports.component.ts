import { Component } from '@angular/core';
import { PurchaseService } from '../service/purchase.service';
import { purchaseDetails, purchaseDetailsforTable } from '../model/purchaseDetails';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.css']
})
export class ReportsComponent {
string: any;
  constructor(private PurchaseService: PurchaseService) {}
  purchaseDetails!: purchaseDetails[];
  arrayOfPurchaseDetailsForTable: purchaseDetailsforTable[] = [];
  purchases!: purchaseDetailsforTable[];
  month = new FormControl;
  columnsToDisplay: string[] = [
    'index',
    'purchaseUser',
    'gender',
    'purchaseDiscount',
    'purchaseDate',
    'purchaseProduct',
    'purchaseRate',
    'purchaseQuantity'
  ];
  ngOnInit() {
    this.PurchaseService.getpurchase().subscribe(data => {
    this.purchaseDetails = data;
    console.log(this.purchaseDetails );
    this.purchaseDetails.forEach((purchaseDetail: purchaseDetails) => {
    const existingPurchaseDetailsTable = this.arrayOfPurchaseDetailsForTable.find(tableEntry => tableEntry.purchaseId === purchaseDetail.purchaseId);

    if (existingPurchaseDetailsTable) {
        existingPurchaseDetailsTable.productforTable.push({
            purchaseProduct: purchaseDetail.purchaseProduct,
            purchaseQuantity: purchaseDetail.purchaseQuantity,
            purchaseRate: purchaseDetail.purchaseRate,
        });
    } else {
        const newPurchaseDetailsTable: purchaseDetailsforTable = {
            purchaseDate: purchaseDetail.purchaseDate,
            purchaseDiscount: purchaseDetail.purchaseDiscount,
            purchaseId: purchaseDetail.purchaseId,
            purchaseUser: purchaseDetail.purchaseUser,
            gender: purchaseDetail.gender,
            productforTable: [{
                purchaseProduct: purchaseDetail.purchaseProduct,
                purchaseQuantity: purchaseDetail.purchaseQuantity,
                purchaseRate: purchaseDetail.purchaseRate,
            }],
        };

        this.arrayOfPurchaseDetailsForTable.push(newPurchaseDetailsTable);
        
    }
});
  this.purchases = this.arrayOfPurchaseDetailsForTable
});
}
public last24Hour(){
  this.purchases =  this.filterObjectWithDateInLast24Hours(this.arrayOfPurchaseDetailsForTable);
}
public allPurchases(){
  this.purchases = this.arrayOfPurchaseDetailsForTable
}
public monthwise(){
  let monthYear = new Date(this.month.value);
  const month = monthYear.getMonth() +1;
  const year = monthYear.getFullYear();
  this.purchases = this.filterObjectByMonthAndYear(this.arrayOfPurchaseDetailsForTable, month, year)
  
}

public filterObjectWithDateInLast24Hours(PurchaseDetails: purchaseDetailsforTable[]) {
  const now = new Date();
  const twentyFourHoursAgo = new Date(now.getTime() - 24 * 60 * 60 * 1000);
  const filteredPurchaseDetails = PurchaseDetails.filter(purchase1 => {
    let purchaseDateObject = new Date(purchase1.purchaseDate);
    return purchaseDateObject >= twentyFourHoursAgo;
  });
  return filteredPurchaseDetails
}

public filterObjectByMonthAndYear(PurchaseDetails: purchaseDetailsforTable[], targetMonth: number, targetYear: number) {
  if(!isNaN(targetMonth) || !isNaN(targetYear)){
  const filteredPurchaseDetails = PurchaseDetails.filter(purchase1 => {
    let purchaseDateObject = new Date(purchase1.purchaseDate);
    return (
      purchaseDateObject.getMonth() === targetMonth - 1 && purchaseDateObject.getFullYear() === targetYear
    );
  });
  return filteredPurchaseDetails;
}
else {alert("Please Select Month & Year")}
  return PurchaseDetails;
}
calculateTotal(products: any[]): number {
  return products.reduce((total, product) => total + (product.purchaseRate * product.purchaseQuantity), 0);
}
convertToInteger(value: any): number {
  return parseInt(value);
}
}