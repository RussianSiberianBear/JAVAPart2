package org.skypro.skyshop;

import org.skypro.search.Searchable;

import java.util.*;

public class ProductBasket {

    private Map<String, Searchable> products = new HashMap<>();

    public ProductBasket() {
    }

    public boolean productAdd(Searchable product) {
        if (product == null) {
            throw new IllegalArgumentException("Добавляемый в корзину продукт не может быть NULL");
        }
        products.put(product.getName(), product);
        return true;
    }

    public int getTotalBasketCost() {
        int sum = 0;
        if (isEmpty()) {
            return sum;
        }
        for (Map.Entry<String, Searchable> product : products.entrySet()) {
            if (product != null) {
                sum += product.getValue().getProductPrice();
            }
        }
        return sum;
    }

    public int getCntSpecialProduct() {
        int cnt = 0;
        if (isEmpty()) {
            return 0;     // тут можно принудительно 0 вернуть, так как кол-во товаров в нашем контексте всегда целое
        }
        for (Map.Entry<String, Searchable> product : products.entrySet()) {
            if (product != null && product.getValue().isSpecial()) {
                cnt++;
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
        for (Map.Entry<String, Searchable> product : products.entrySet()) {
            if (product != null) {
                result += "\n" + product.getValue().getStringRepresentation();
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
        this.products = new HashMap<>();
    }

    public List<Searchable> deleteProductByName(String productName) {

        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Наименование удаляемого товара не может быть пустым!");
        }
        if (isEmpty()) {
            return new ArrayList<>();
        }

        List<Searchable> delProducts = new ArrayList<>();
        Iterator<Map.Entry<String, Searchable>> iterator = products.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Searchable> product = iterator.next();
            if (product.getValue().getName().equals(productName)) {
                delProducts.add(product.getValue());
                iterator.remove();
            }
        }
        return delProducts;
    }

    public void printBasket() {
        System.out.println(this);
    }
}
