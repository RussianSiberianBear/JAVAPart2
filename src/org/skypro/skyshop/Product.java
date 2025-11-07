package org.skypro.skyshop;

import org.skypro.search.Searchable;

import java.util.Objects;

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

    public abstract boolean isSpecial();

    public String getContentType() {
        return "PRODUCT";
    }

    public String searchTerm() {
        return this.getContentType() + "  " + this.name;
    }

    @Override
    public boolean equals(Searchable o) {
        if (this == o) return true;
        if (o == null) return false;
        return o.getName().equals(this.getName());
    }

    @Override
    public int hashCode() {
        return 97 + Objects.hashCode(this.getName());
    }
}
