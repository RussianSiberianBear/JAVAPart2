import org.skypro.content.Article;
import org.skypro.exeption.BestResultNotFound;
import org.skypro.search.Searchable;
import org.skypro.skyshop.*;
import org.skypro.search.SearchEngine;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        System.out.println("JAVA часть 2. Домашняя работа №5");

        // 1 Реализация проверок в конструкторе класса Product
        // Давно сделано, еще в предыдущих ДЗ


        //2  Демонстрация проверки данных в классе main
        System.out.println();
        System.out.println("2. Демонстрация попытки создать продукт с неправильным именем " +
                "(null, пустым или из пробелов) или ценой меньше 0");
        // имя - null
        try {
            Product[] productsArr = {
                    new DiscountedProduct(null, 100, 10),
                    new SimpleProduct("2-й продукт", 200),
                    new DiscountedProduct("3-й продукт", 300, 20),
                    new FixPriceProduct("4-й продукт"),
                    new SimpleProduct("5-й продукт", 500)
            };
        } catch (Exception e) {
            System.out.println("Ошибка ! " + e.getMessage());
        }

        // имя - пустая строка
        try {
            Product[] productsArr = {
                    new DiscountedProduct("", 100, 10),
                    new SimpleProduct("2-й продукт", 200),
                    new DiscountedProduct("3-й продукт", 300, 20),
                    new FixPriceProduct("4-й продукт"),
                    new SimpleProduct("5-й продукт", 500)
            };
        } catch (Exception e) {
            System.out.println("Ошибка ! " + e.getMessage());
        }

        // имя только из пробелов
        try {
            Product[] productsArr = {
                    new DiscountedProduct("1-й продукт", 100, 10),
                    new SimpleProduct("   ", 200),
                    new DiscountedProduct("3-й продукт", 300, 20),
                    new FixPriceProduct("4-й продукт"),
                    new SimpleProduct("5-й продукт", 500)
            };
        } catch (Exception e) {
            System.out.println("Ошибка ! " + e.getMessage());
        }

        // Попытка создать продукт с ценой меньше или равной 0
        try {
            Product[] productsArr = {
                    new DiscountedProduct("1-й продукт", -100, 10),
                    new SimpleProduct("2-й продукт", 200),
                    new DiscountedProduct("3-й продукт", 300, 20),
                    new FixPriceProduct("4-й продукт"),
                    new SimpleProduct("5-й продукт", 500)
            };
        } catch (Exception e) {
            System.out.println("Ошибка ! " + e.getMessage());
        }

        // Создаем  нормальные продукты
        System.out.println();
        System.out.println("Создаем продукты без ошибок в имени и цене");
        Product[] productsArr = null;
        try {
            productsArr = new Product[]{
                    new DiscountedProduct("1-й продукт", 100, 10),
                    new SimpleProduct("2-й продукт", 200),
                    new DiscountedProduct("3-й продукт", 300, 20),
                    new FixPriceProduct("4-й продукт"),
                    new SimpleProduct("5-й продукт", 500)
            };
        } catch (Exception e) {
            System.out.println("Ошибка ! " + e.getMessage());
        }

        if (productsArr != null) {
            System.out.println(Arrays.toString(productsArr));
            System.out.println("Создано " + productsArr.length + " продуктов!");
        }

        // 3 Реализация метода поиска самого подходящего элемента
        System.out.println();
        System.out.println("3. Реализация метода поиска самого подходящего элемента");

        SearchEngine searchEngine = new SearchEngine(5);
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

        // 3 Реализация метода поиска самого подходящего элемента
        System.out.println();
        System.out.println("3. Реализация метода поиска самого подходящего элемента");

        System.out.println("Ищем объект, в котором есть строка поиска");
        Searchable obj;

        try {
            obj = searchEngine.getSearchTerm("кош");
            if (obj != null) {
                System.out.println("Самый подходящий объект для строки поиска \"кош\" \"" + obj.getName() + "\"");
            }
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка ! " + e.getMessage());
        }

        System.out.println("Ищем объект, в котором нет строки поиска");
        obj = null;
        try {
            obj = searchEngine.getSearchTerm("55jhgjgjg");
            if (obj != null) {
                System.out.println("Самый подходящий объект \"" + obj.getName() + "\"");
            }
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка ! " + e.getMessage());
        }


    }

    // ******************** Конец main *********************************
    // JAVA часть 2. Домашняя работа №3
    public static void homeWork3() {

        try {
            App.main();
        } catch (Exception e) {
            System.out.println("Ошибка ! " + e.getMessage());
        }
    }

    // JAVA часть 2. Домашняя работа №4
    public static void homeWork4() {

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