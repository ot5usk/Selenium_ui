package org.ot5usk.pages.wb_pages.wb_pages_elements.wb_default_pages_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.ot5usk.pages.abstract_pages.abstract_pages_elements.abstract_default_pages_elements.Filters;
import org.ot5usk.pages.abstract_pages.Page;

import java.util.List;

public class WbFilters extends Filters {

    @FindBy(xpath = "//button[contains(@class, 'dropdown-filter__btn dropdown-filter__btn--burger')]")
    public WebElement firstTopFilter;

    @FindBy(xpath = "//button[contains(@class, 'dropdown-filter__btn dropdown-filter__btn--sorter')]")
    public WebElement secondTopFilter;

    @FindBy(xpath = "//button[@class='dropdown-filter__btn dropdown-filter__btn--all']")
    public WebElement bottomFiltersMenuBtn;

    @FindBy(xpath = "//p[@class='filters-desktop__count-goods']")
    public WebElement productsCounterInBFMenu;

    @FindBy(xpath = "//button[@class='filters-desktop__btn-main btn-main']")
    public WebElement showBtn;

    public By choiceBottomFilters = By.xpath("//span[@class='your-choice__btn']");

    @FindBy(xpath = "//button[contains(text(), 'Сбросить все')]")
    public WebElement resetBtn;

    public WbFilters(WebDriver webDriver, Page page) {
        super(webDriver, page.url);
        PageFactory.initElements(page.webDriver, this);
        super.topFilters = List.of(firstTopFilter, secondTopFilter);
        super.choiceBottomFilters = choiceBottomFilters;
        super.bottomFiltersMenuBtn = bottomFiltersMenuBtn;
        super.productsCounterInBFMenu = productsCounterInBFMenu;
        super.applyBottomFiltersBtn = showBtn;
        super.resetBtn = resetBtn;
    }

    public WbFilters(WebDriver webDriver, Page page, List<WebElement> bottomFilters, List<WebElement> inputBottomFilters) {
        this(webDriver, page);
        super.bottomInputFilters = inputBottomFilters;
        super.bottomFilters = bottomFilters;
    }
}
