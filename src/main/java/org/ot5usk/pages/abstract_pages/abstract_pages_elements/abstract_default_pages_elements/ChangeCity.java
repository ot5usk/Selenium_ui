package org.ot5usk.pages.abstract_pages.abstract_pages_elements.abstract_default_pages_elements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.ot5usk.pages.abstract_pages.methods.ChangeCityMethods;

public abstract class ChangeCity implements ChangeCityMethods {

    public WebElement menu;
    public WebElement searchBar;
    public WebElement firstAddress;
    public WebElement infoBlock;
    public WebElement infoBlockAddress;
    public WebElement selectBtn;
    public WebElement resultAddress;

    @Override
    public void clickOnTheChangeCityBtn() {
        menu.click();
    }

    @Override
    public void enterQueryInChangeCitySearchBar(String searchQuery) {
        searchBar.sendKeys(searchQuery + Keys.ENTER);
    }

    @Override
    public void selectFirstAddress() {
        firstAddress.click();
    }

    @Override
    public void clickSelectBtn() {
        selectBtn.click();
    }
}
