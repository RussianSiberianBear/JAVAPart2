package org.skypro.search;

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
}
