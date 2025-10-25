package org.skypro.skyshop;

public class App {

    public static void main() {

        System.out.println("JAVA часть 2. Домашняя работа №2");

        ProductBasket basket = new ProductBasket(5);
        Product[] productsArr = {
                new Product("1-й продукт", 100),
                new Product("2-й продукт", 200),
                new Product("3-й продукт", 300),
                new Product("4-й продукт", 400),
                new Product("5-й продукт", 500)
        };

//1  Добавление продукта в корзину.
        for (Product p : productsArr) {
            if (basket.productAdd(p)){
                System.out.println(p.getProductName() + "добавлен в корзину");
            }
        }

//2      Добавление продукта в заполненную корзину, в которой нет свободного места.
        if (basket.productAdd(new Product("6-продукт", 600))){
            System.out.println("6-й продукт добавлен в корзину");
        }else{
            System.out.println("Невозможно добавить продукт!");
        }


//3     Печать содержимого корзины с несколькими товарами.
        System.out.println(basket);


//4      Получение стоимости корзины с несколькими товарами.
        System.out.println("Стоимость товаров в корзине " + basket.getTotalBasketCost());


//5     Поиск товара, который есть в корзине
        if (basket.isProductExistsByName("1-й продукт")) {
            System.out.println("\"1-й продукт\" в корзине есть!");
        } else {
            System.out.println("В корзине такого продукта нет!");
        }


//6     Поиск товара, которого нет в корзине.
        if (basket.isProductExistsByName("10-й продукт")) {
            System.out.println("10-й продукт в корзине есть!");
        } else {
            System.out.println("В корзине такого продукта \"10-й продукт\" нет!");
        }


//7     Очистка корзины.
        basket.empty();


//8     Печать содержимого пустой корзины.
        System.out.println(basket);


//9     Получение стоимости пустой корзины.
        System.out.println("Стоимость товаров в корзине " + basket.getTotalBasketCost());


//10    Поиск товара по имени в пустой корзине.
        if (basket.isProductExistsByName("1-й продукт")) {
            System.out.println("\"1-й продукт\" в корзине есть!");
        } else {
            System.out.println("В корзине такого продукта нет!");
        }
    }


}
