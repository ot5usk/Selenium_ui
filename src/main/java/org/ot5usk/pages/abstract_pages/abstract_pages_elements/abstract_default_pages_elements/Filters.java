package org.ot5usk.pages.abstract_pages.abstract_pages_elements.abstract_default_pages_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.ot5usk.pages.abstract_pages.Page;
import org.ot5usk.pages.abstract_pages.methods.FiltersMethods;

import java.util.List;

public abstract class Filters extends Page implements FiltersMethods {

    public List<WebElement> topFilters;
    public List<WebElement> bottomInputFilters;
    public List<WebElement> bottomFilters;
    public WebElement bottomFiltersMenuBtn;
    public WebElement productsCounterInBFMenu;
    public WebElement applyBottomFiltersBtn;
    public By choiceBottomFilters;
    public WebElement resetBtn;

    public Filters(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    @Override
    public void clickBottomFiltersMenu() {
        clickOnTheElement(bottomFiltersMenuBtn);
    }

    @Override
    public void fillBottomInputFilters(String... values) {
        WebElement inputFilter;
        for (int i = 0; i < bottomInputFilters.size(); i++) {
            inputFilter = bottomInputFilters.get(i);
            waitLoadElement(inputFilter);
            inputFilter.clear();
            enterTextInElement(inputFilter, values[i]);
        }
    }

    @Override
    public void selectBottomFilters() {
        WebElement filter;
        for (WebElement bottomFilter : bottomFilters) {
            filter = bottomFilter;
            waitLoadElement(filter);
            untilVisibilityOf(filter);
            untilToBeClickable(filter);
            moveToElement(filter);
            clickOnTheElement(filter);
        }
    }

    @Override
    public void clickApplyBottomFiltersBtn() {
        clickOnTheElement(applyBottomFiltersBtn);
    }
}
