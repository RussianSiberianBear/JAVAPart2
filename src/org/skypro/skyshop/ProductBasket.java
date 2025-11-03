package org.skypro.skyshop;


import org.skypro.search.Searchable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket <T extends Searchable>{

    private List<Searchable> products = new ArrayList<>();

    public ProductBasket() {
    }

    public boolean productAdd(Searchable product) {
        if (product == null) {
            throw new IllegalArgumentException("Добавляемый в корзину продукт не может быть NULL");
        }
        products.add(product);
        return true;
    }

    public int getTotalBasketCost() {
        int sum = 0;
        if (isEmpty()) {
            return sum;    // Принудительно просто 0 не возвращаем, так как можем переопределить тип возвращаемого значения и
            // в таком случае не надо искать где еще что исправлять
        }

        for (Searchable product : products) {
            if (product != null) {
                sum += product.getProductPrice();
            }
        }

        return sum;
    }

    public int getCntSpecialProduct() {
        int cnt = 0;
        if (isEmpty()) {
            return 0;     // тут можно принудительно 0 вернуть, так как кол-во товаров в нашем контексте всегда целое
        }

        for (Searchable product : products) {
            if (product != null && product.isSpecial()) {
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

        for (Searchable product : products) {
            if (product != null) {
                result += "\n" + product.getStringRepresentation();
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
        this.products = new ArrayList<>();
    }

    public ArrayList<Searchable> deleteProductByName(String productName) {

        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Наименование удаляемого товара не может быть пустым!");
        }

        ArrayList<Searchable> delProducts = new ArrayList<>();
        Iterator<Searchable> iterator = this.products.iterator();

        if (isEmpty()) {
            return  new ArrayList<>();
        }
         while (iterator.hasNext()) {
            Searchable product = iterator.next();
            if (product.getName().equals(productName)) {
                delProducts.add(product);
                iterator.remove();
            }
        }
        return delProducts;
    }

    public void printBasket() {
        System.out.println(this);
    }
}
