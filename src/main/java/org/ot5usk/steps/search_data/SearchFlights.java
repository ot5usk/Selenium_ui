package org.ot5usk.steps.search_data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchFlights {

    @FindBy(xpath = "//li[@data-menu-id='61037']//a[text()='Путешествия']")
    public WebElement travels;

    @FindBy(xpath = "//div[@data-menu-id='61037']//a[text()='Авиабилеты']")
    public WebElement flights;

    public SearchFlights(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public List<WebElement> getSearchPathFilters() {
        return List.of(travels, flights);
    }
}
