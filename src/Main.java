import org.skypro.content.Article;
import org.skypro.search.Searchable;
import org.skypro.skyshop.*;
import org.skypro.search.SearchEngine;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        try {
            System.out.println("JAVA часть 2. Домашняя работа №4");
            System.out.println();

            SearchEngine searchEngine = new SearchEngine(10);

            Product[] productsArr = {
                    new DiscountedProduct("1-й продукт", 100, 10),
                    new SimpleProduct("2-й продукт", 200),
                    new DiscountedProduct("3-й продукт", 300, 20),
                    new FixPriceProduct("4-й продукт"),
                    new SimpleProduct("5-й продукт", 500)
            };
            for (Searchable p : productsArr) {
                if (searchEngine.add(p)) {
                    System.out.println("\"" + p.getName() + "\" добавлен для демонстрации поиска");
                } else {
                    System.out.println("Ошибка при добавлении \"" + p.getName() + "\"");
                }
            }

            System.out.println();
            Searchable[] articleArr = {
                    new Article("Новости", "Новости дня."),
                    new Article("Корм для животных", "В данной статье рассказывается о видах кормов для домашних животных-кошек и собак."),
                    new Article("Домашние питомцы", "Статья о кошках и собаках. Кошки и собаки давние домашние питомцы."),
                    new Article("Вакансии", "Свежие вакансии на сегодня."),
                    new Article("Женские товары", "Косметика, духи и другие штучки для женщин.")
            };

            for (Searchable p : articleArr) {
                if (searchEngine.add(p)) {
                    System.out.println("\"" + p.getName() + "\" добавлен для демонстрации поиска");
                } else {
                    System.out.println("Ошибка при добавлении \"" + p.getName() + "\"");
                }
            }

            System.out.println();
            System.out.println("Демонстрация поиска");


            Searchable[] result;

            // Ищем продукт
            System.out.println();
            System.out.println("Найденные продукты:");
            result = searchEngine.search("продукт");
            System.out.println(Arrays.toString(result));

            // Выводим информацию об имени и типе найденных объектах
            System.out.println();
            System.out.println("Информация о названии и типе продуктов");
            for (Searchable obj : result) {
                if (obj != null) {
                    System.out.println(obj.getStringRepresentation());
                }
            }


            // Ищем по статьям
            System.out.println();
            System.out.println("Найденные статьи:");
            result = searchEngine.search("кош");
            System.out.println(Arrays.toString(result));


            // Выводим информацию об имени и типе найденных объектах
            System.out.println();
            System.out.println("Информация о названии и типе статей");
            for (Searchable obj : result) {
                if (obj != null) {
                    System.out.println(obj.getStringRepresentation());
                }
            }


        } catch (Exception e) {
            System.out.println("Ошибка ! " + e.getMessage());
        }

    }
}