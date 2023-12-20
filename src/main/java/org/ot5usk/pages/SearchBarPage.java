package org.ot5usk.pages;

import org.openqa.selenium.WebElement;

public abstract class SearchBarPage extends Page {

    public WebElement searchBar;
    public WebElement cross;

    public SearchBarPage(String url) {
        super(url);
    }
}
