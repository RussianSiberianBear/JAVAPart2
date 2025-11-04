package org.skypro.search;

import org.skypro.exeption.BestResultNotFound;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchables = new ArrayList<>();

    public SearchEngine(Searchable[] search) {
        Collections.addAll(searchables, search);
    }

    public List<Searchable> search(String search) throws BestResultNotFound {

        List<Searchable> result = new ArrayList<>();
        for (Searchable searchable : searchables) {
            if (countSubstringIgnoreCase(searchable.searchTerm(), search) > 0) {
                result.add(searchable);
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
