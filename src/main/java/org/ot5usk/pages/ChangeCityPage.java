package org.ot5usk.pages;

import org.openqa.selenium.WebElement;

public abstract class ChangeCityPage extends Page {

    public WebElement changeCityMenu;
    public WebElement changeCitySearchBar;
    public WebElement firstAddress;
    public WebElement selectBtn;

    public ChangeCityPage(String url) {
        super(url);
    }
}
