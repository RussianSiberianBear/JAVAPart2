package org.skypro.content;

import org.skypro.search.Searchable;

import java.util.Objects;

public class Article implements Searchable {
    private String name;
    private String content;

    public Article(String name, String content) {
        this.name = name;
        this.content = content;
    }

    @Override
    public int getProductPrice() {
        return 0;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\n" + this.name + "\n" + this.content;
    }

    public String getContentType() {
        return "ARTICLE";
    }

    public String searchTerm() {
        return this.toString();
    }

    @Override
    public boolean equals(Searchable o) {
        if (this == o) return true;
        if (o == null) return false;
        return o.getName().equals(this.getName());
    }

    @Override
    public int hashCode() {
        return 97 + Objects.hashCode(this.getName());
    }

}
