package org.skypro.skyshop;

public class ProductBasket {

    private int cntProductBasket;
    private Product[] products;

    public ProductBasket(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размер корзины не может быть равен нулю или быть отрицательным!");
        }
        this.products = new Product[size];
        this.cntProductBasket = 0;
    }

    public boolean isProductExistsByName(String productName) {
        if (productName == null || productName.isEmpty()) {
            throw new IllegalArgumentException("Наименование искомого товара не может быть пустым!");
        }
        if (isEmpty()) {
            return false;
        }
        for (Product product : this.products) {
            if (product != null && product.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public boolean productAdd(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Добавляемый в корзину продукт не может быть NULL");
        }

        if (this.isFull()) {
            return false;
        }

        for (int i = 0; i < this.products.length; i++) {
            if (this.products[i] == null) {
                this.products[i] = product;
                this.cntProductBasket++;
                break;
            }
        }
        return true;
    }

    public int getTotalBasketCost() {
        int sum = 0;
        if (isEmpty()) {
            return sum;    // Принудительно просто 0 не возвращаем, так как можем переопределить тип возвращаемого значения и
            // в таком случае не надо искать где еще что исправлять
        }
        for (Product product : this.products) {
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
        for (Product product : this.products) {
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

        for (Product product : this.products) {
            if (product != null) {
                result += "\n" + product;
            }
        }
        result += "\nИтого: " + this.getTotalBasketCost();
        result += "\nСпециальных товаров: " + this.getCntSpecialProduct();
        return result;
    }

    public boolean isFull() {
        return (this.cntProductBasket == this.products.length);
    }

    public boolean isEmpty() {
        return this.cntProductBasket == 0;
    }

    public void empty() {
        this.products = new Product[this.products.length];
        this.cntProductBasket = 0;
    }
}
