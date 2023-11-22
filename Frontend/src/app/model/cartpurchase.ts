export interface cartprdoucts {
    productId: String,
    productQuantity: number,
    }
export interface cartpurchase {
    purchaseId: String,
    product: Array<cartprdoucts>,
    discount: Number,
    userId: Number
}
