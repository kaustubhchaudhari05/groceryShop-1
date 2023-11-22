export interface purchaseDetails {
    purchaseDate : string,
    purchaseDiscount : number,
    purchaseId : string,
    purchaseProduct: string,
    purchaseQuantity: string,
    purchaseRate: string,
    purchaseUser: string,
    gender: String
}

export interface purchaseDetailsforTable {
    purchaseDate : string,
    purchaseDiscount : number,
    purchaseId : string,
    purchaseUser: string,
    gender: String,
    productforTable: Array<productforTable>
}

export interface productforTable {
    purchaseProduct: string,
    purchaseQuantity: string,
    purchaseRate: string,
}