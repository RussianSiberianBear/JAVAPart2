package org.skypro.skyshop;

import org.skypro.search.Searchable;

public abstract class Product implements Searchable {

    protected String name;

    public Product(String productName) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Имя продукта не может быть пустым!");
        }
        this.name = productName.trim();
    }

    public String getName() {
        return this.name;
    }

 //   public abstract int getProductPrice();

    public abstract boolean isSpecial();

    public String getContentType() {
        return "PRODUCT";
    }

    public String searchTerm() {
        return this.getContentType() + "  " + this.name;
    }
}
