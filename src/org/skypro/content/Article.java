package org.skypro.content;

import org.skypro.search.Searchable;

public class Article implements Searchable {
    private String name;
    private String content;

    public Article(String name, String content) {
        this.name = name;
        this.content = content;
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
}
