package org.skypro.search;

public interface Searchable {

    String getName();

    String searchTerm();

    String getContentType();

    default String getStringRepresentation() {
        return "Имя объекта \"" + this.getName() + "\" Тип \"" + this.getContentType() + "\"";
    }
}
