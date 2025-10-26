package org.skypro.skyshop;

public class SimpleProduct extends Product {
    private int productPrice;

    public SimpleProduct(String productName,int productPrice) {
        super(productName);
        if (productPrice <= 0) {
            throw new IllegalArgumentException("Цена продукта не может быть 0 или отрицательной!");
        }
        this.productPrice = productPrice;
    }

    @Override
    public boolean isSpecial(){
        return false;
    }

    @Override
    public int getProductPrice() {
        return this.productPrice;
    }

    @Override
    public String toString() {
        return this.productName + ": " + this.getProductPrice();
    }
}
