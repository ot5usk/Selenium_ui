package org.ot5usk.pages.abstract_pages.abstract_pages_elements.abstract_default_pages_elements;

import org.openqa.selenium.WebElement;
import org.ot5usk.pages.abstract_pages.methods.SearchBarMethods;

public abstract class SearchBar implements SearchBarMethods {

    public WebElement searchInput;
    public WebElement cross;

    @Override
    public void clickOnTheSearchBar() {
        searchInput.click();
    }

    @Override
    public void enterQueryInSearchBar(String searchQuery) {
        searchInput.sendKeys(searchQuery);
    }

    @Override
    public void clickTheCross() {
        cross.click();
    }
}
