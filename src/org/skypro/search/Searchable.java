package org.skypro.search;

import java.util.Comparator;

public interface Searchable {

    String getName();

    String searchTerm();

    String getContentType();

    int getProductPrice();

    boolean isSpecial();

    default String getStringRepresentation() {
        return "Имя объекта \"" + this.getName() + "\" Тип \"" + this.getContentType() + "\"";
    }

    boolean equals(Searchable o);

    static Comparator<Searchable> getInverseComparator() {

       return  (o1, o2) -> {
            if (o2.getName().length() < o1.getName().length()) {
                return -1;
            } else if (o2.getName().length() > o1.getName().length()) {
                return 1;
            } else return o2.getName().compareTo(o1.getName());
        };
    }
}
