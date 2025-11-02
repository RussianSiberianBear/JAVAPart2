package org.skypro.search;

import org.skypro.exeption.BestResultNotFound;

public class SearchEngine {
    private Searchable[] searchables;
    private int cnt = 0;

    public SearchEngine(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размер не может быть равен нулю или быть отрицательным!");
        }
        this.searchables = new Searchable[size];
    }

    public Searchable[] search(String search) {
        Searchable[] result = new Searchable[5];
        int idx = 0;

        for (Searchable searchable : this.searchables) {
            if (searchable.searchTerm().contains(search)) {
                result[idx++] = searchable;
            }
            if (idx == 5) {
                break;
            }
        }
        return result;
    }

    public boolean add(Searchable obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Добавляемый объект не может быть NULL");
        }

        if (this.isFull()) {
            return false;
        }

        for (int i = 0; i < this.searchables.length; i++) {
            if (this.searchables[i] == null) {
                this.searchables[i] = obj;
                this.cnt++;
                break;
            }
        }
        return true;
    }

    public boolean isFull() {
        return (this.cnt == this.searchables.length);
    }

    public static int countSubstringIgnoreCase(String text, String substring) {

        if (text == null || substring == null || substring.isEmpty()) {
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

    public Searchable getSearchTerm(String search) throws BestResultNotFound {

        int idxObj = -1;
        Searchable result = null;   // возвращаем 1 самый подходящий товар или выбрасываем исключение, если нет его
        int[] cntFound = new int[this.searchables.length]; // кол-во вхождений искомой строки по объектам

        for (int i = 0; i < this.searchables.length; i++) {
            if (this.searchables[i] != null) {
                cntFound[i] = countSubstringIgnoreCase(this.searchables[i].searchTerm(), search);
            }
        }

        for (int j : cntFound) {
            if (j != 0 && j > idxObj) {
                idxObj = j;
            }
        }

        if (idxObj >= 0) {
            result = this.searchables[idxObj];
        }

        if (result != null) {
            return result;
        } else {
            throw new BestResultNotFound("При поиске \"" + search + "\" подходящий объект не найден!");
        }
    }
}
