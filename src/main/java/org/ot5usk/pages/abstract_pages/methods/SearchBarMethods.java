package org.ot5usk.pages.abstract_pages.methods;

import org.ot5usk.pages.abstract_pages.CatalogPage;

public interface SearchBarMethods {

    void clickOnTheSearchBar();

    void enterQueryInSearchBar(String query);

    CatalogPage sendEnterKeyInSearchBar();

    void clickTheCross();
}
