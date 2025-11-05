package org.skypro.search;

import org.skypro.exeption.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    private Map<String, Searchable> searchables = new TreeMap<>();

    public SearchEngine(Searchable[] search) {

        for (Searchable s : search) {
            searchables.put(s.getName(), s);
        }
    }

    public Map<String, Searchable> search(String search) throws BestResultNotFound {

        Map<String, Searchable> result = new HashMap<>();
        for (Map.Entry<String, Searchable> product : searchables.entrySet()) {
            if (product != null && countSubstringIgnoreCase(product.getValue().searchTerm(), search) > 0) {
                result.put(product.getValue().getName(), product.getValue());
            }
        }
        if (result.isEmpty()) {
            throw new BestResultNotFound("При поиске \"" + search + "\" подходящий объект не найден!");
        }
        return result;
    }

    public static int countSubstringIgnoreCase(String text, String substring) {

        if (!(text != null && !text.isEmpty() && substring != null && !substring.isEmpty())) {
            return 0;
        }

        text = text.toLowerCase();
        substring = substring.toLowerCase();
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length(); // Перемещаемся после найденной подстроки
        }
        return count;
    }

}
