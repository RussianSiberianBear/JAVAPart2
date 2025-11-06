package org.skypro.skyshop;

import org.skypro.search.Searchable;

import java.util.*;

public class ProductBasket {

    private Map<String, List<Searchable>> products = new TreeMap<>();

    public ProductBasket() {
    }

    public boolean productAdd(Searchable product) {
        if (product == null) {
            throw new IllegalArgumentException("Добавляемый в корзину продукт не может быть NULL");
        }
        List<Searchable> p = new ArrayList<>();
        if (products.containsKey(product.getName())) {
            p = products.get(product.getName());
        }
        p.add(product);
        products.put(product.getName(), p);
        return true;
    }

    public int getTotalBasketCost() {
        int sum = 0;
        if (isEmpty()) {
            return sum;
        }
        for (Map.Entry<String, List<Searchable>> product : products.entrySet()) {
            if (product != null) {
                for (Searchable p : product.getValue()) {
                    if (p != null) {
                        sum += p.getProductPrice();
                    }
                }
            }
        }
        return sum;
    }

    public int getCntSpecialProduct() {
        int cnt = 0;
        if (isEmpty()) {
            return 0;     // тут можно принудительно 0 вернуть, так как кол-во товаров в нашем контексте всегда целое
        }
        for (Map.Entry<String, List<Searchable>> product : products.entrySet()) {
            if (product != null) {
                for (Searchable p : product.getValue()) {
                    if (p != null && p.isSpecial()) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    @Override
    public String toString() {
        String result = "";
        if (this.isEmpty()) {
            return ("В корзине пусто!");
        }
        for (Map.Entry<String, List<Searchable>> product : products.entrySet()) {
            if (product != null) {
                for (Searchable p : product.getValue()) {
                    if (p != null) {
                        result += "\n" + p.getStringRepresentation();
                    }
                }
            }
        }
        result += "\nИтого: " + this.getTotalBasketCost();
        result += "\nСпециальных товаров: " + this.getCntSpecialProduct();
        return result;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public void empty() {
        this.products = new TreeMap<>();
    }

    public List<Searchable> deleteProductByName(String productName) {

        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Наименование удаляемого товара не может быть пустым!");
        }
        List<Searchable> delProducts = new ArrayList<>();
        if (isEmpty()) {
            return delProducts;
        }
        if (products.containsKey(productName)) {
            delProducts = products.get(productName);
            products.remove(productName);
        }
        return delProducts;
    }

    public void printBasket() {
        System.out.println(this);
    }
}
