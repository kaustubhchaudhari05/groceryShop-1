import { Product } from "./products";

export interface Category {
    id: String,
    categoryName: String;
}
export interface CatWiseProducts {
    id: number,
    categoryName: String;
    products: Array<Product>;
}