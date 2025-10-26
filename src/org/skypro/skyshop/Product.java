package org.skypro.skyshop;

public abstract class Product {
    protected String productName;

    public Product(String productName) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Имя продукта не может быть пустым!");
        }

        this.productName = productName.trim();
    }

    public String getProductName() {
        return this.productName;
    }

    public abstract int getProductPrice();

    public abstract boolean isSpecial();
}
