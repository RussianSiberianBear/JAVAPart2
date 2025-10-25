package org.skypro.skyshop;

public class ProductBasket {

    private int cntProductBasket;

    private Product[] products;

    public ProductBasket(int size) {
        this.products = new Product[size];
        this.cntProductBasket = 0;
    }


    public boolean isProductExistsByName(String productName) {

        if (this.cntProductBasket == 0) {
            return false;
        }
        for (Product product : this.products) {
            if (product != null && product.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }


    public boolean productAdd(Product product) {
        if (this.cntProductBasket == this.products.length) {
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
        for (Product product : this.products) {
            if (product != null) {
                sum += product.getProductPrice();
            }
        }
        return sum;
    }


    @Override
    public String toString() {
        String result = "";
        if (this.cntProductBasket == 0) {
            return ("В корзине пусто!");
        }

        for (Product product : this.products) {
            if (product != null) {
                result += "\n" + product;
            }
        }
        result += "\nИтого: " + this.getTotalBasketCost();
        return result;
    }

    public void empty() {
        this.products = new Product[this.products.length];
        this.cntProductBasket = 0;
    }


}
