package org.skypro.search;

public interface Searchable {

    String getName();

    String searchTerm();

    String getContentType();

    int getProductPrice();

    boolean isSpecial();

    default String getStringRepresentation() {
        return "Имя объекта \"" + this.getName() + "\" Тип \"" + this.getContentType() + "\"";
    }
}
