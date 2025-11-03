import org.skypro.content.Article;
import org.skypro.search.Searchable;
import org.skypro.search.SearchEngine;
import org.skypro.skyshop.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("JAVA часть 2. Домашняя работа №6");

        System.out.println();
        ProductBasket basket;
        basket = new ProductBasket();
        // Создаем нормальные продукты
        System.out.println();
        System.out.println("Создаем продукты");
        Searchable[] productsArr;
        try {
            productsArr = new Searchable[]{
                    new DiscountedProduct("1-й продукт", 100, 10),
                    new SimpleProduct("2-й продукт", 200),
                    new DiscountedProduct("3-й продукт", 300, 20),
                    new FixPriceProduct("4-й продукт"),
                    new SimpleProduct("5-й продукт", 500),
                    new Article("Новости", "Новости дня."),
                    new Article("Корм для животных", "В данной статье рассказывается о видах кормов для домашних животных-кошек и собак."),
                    new Article("Домашние питомцы", "Статья о кошках и собаках. Кошки и собаки давние домашние питомцы."),
                    new Article("Вакансии", "Свежие вакансии на сегодня."),
                    new Article("Женские товары", "Косметика, духи и другие штучки для женщин.")
            };
            // Добавляем продукты в корзину и печатаем список продуктов корзины
            System.out.println("Добавляем продукты в корзину и печатаем список продуктов корзины");
            for (Searchable p : productsArr) {
                basket.productAdd(p);
            }
            basket.printBasket();

            // Удаляем cуществующий продукт из корзины
            System.out.println("Удаляем существующий продукт из корзины");
            List<Product> delProducts;
            delProducts = basket.deleteProductByName("1-й продукт");
            System.out.println("Список удаленных продуктов:\n" + delProducts);
            System.out.println();
            System.out.println("Теперь в корзине следующие продукты:");
            basket.printBasket();

            // Удаляем несуществующий продукт
            System.out.println("Удаляем несуществующий в корзине продукт");
            delProducts = basket.deleteProductByName("100-й продукт");
            if (delProducts.isEmpty()) {
                System.out.println("Список пуст!");
            } else {
                System.out.println("Список удаленных продуктов:\n" + delProducts);
                System.out.println();
            }
            System.out.println("В корзине следующие продукты:");
            basket.printBasket();

            // Ищем имеющийся продукт
            System.out.println();
            System.out.println("Ищем имеющийся продукт");
            SearchEngine searchEngine = new SearchEngine(productsArr);
            ArrayList<Searchable> findProducts = searchEngine.search("кош");
            if (findProducts == null || findProducts.isEmpty()) {
                System.out.println("Список поиска пуст!");
            } else {
                System.out.println("Список найденных продуктов:\n" + findProducts);
            }

            // Ищем продукт, которого точно нет. Будет выброшено исключение и код печати не выполнится
            System.out.println();
            System.out.println("Ищем продукт, которого нет");
            findProducts = searchEngine.search("10000-й продукт");
            if (findProducts == null || findProducts.isEmpty()) {
                System.out.println("Список поиска пуст!");
            } else {
                System.out.println("Список найденных продуктов:\n" + findProducts);
            }

        } catch (Exception e) {
            System.out.println("Ошибка ! " + e.getMessage());
        }


    }

    // ******************** Конец main *********************************

}