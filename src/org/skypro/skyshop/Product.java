package org.skypro.skyshop;

public class Product {
    private String productName;
    private int productPrice;

    public Product(String productName, int productPrice) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Имя продукта не может быть пустым!");
        }
        if (productPrice <= 0) {
            throw new IllegalArgumentException("Цена продукта не может быть 0 или отрицательной!");
        }
        this.productName = productName.trim();
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return this.productName;
    }

    public int getProductPrice() {
        return this.productPrice;
    }

    @Override
    public String toString() {
        return this.productName + ": " + productPrice;
    }

}
