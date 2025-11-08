package org.skypro.search;

import org.skypro.exeption.BestResultNotFound;

import java.util.*;

import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> searchables = new HashSet<>();

    public SearchEngine(Searchable[] search) {
        Collections.addAll(searchables, search);
    }

    public Set<Searchable> search(String search) throws BestResultNotFound {

        if (search == null || search.isEmpty()) {
            throw new IllegalArgumentException("Строка для поиска не может быть пуста!");
        }

        Set<Searchable> result = searchables.stream()
                .filter(Objects::nonNull)
                .filter(obj -> obj.searchTerm().toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toCollection(
                        () -> new TreeSet<>(Searchable.getInverseComparator())
                ));

        if (result.isEmpty()) {
            throw new BestResultNotFound("При поиске \"" + search + "\" подходящий объект не найден!");
        }
        return result;
    }

}
