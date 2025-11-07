package org.skypro.search;

import org.skypro.exeption.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    private Set<Searchable> searchables = new HashSet<>();

    public SearchEngine(Searchable[] search) {
        Collections.addAll(searchables, search);
    }

    public Set<Searchable> search(String search) throws BestResultNotFound {

        Set<Searchable> result = new TreeSet<>(Searchable.getInverseComparator());

        for (Searchable product : searchables) {
            if (product != null && countSubstringIgnoreCase(product.searchTerm(), search) > 0) {
                result.add(product);
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
