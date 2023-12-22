package org.ot5usk.steps.search_data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchVacuumsNdCleaners {

    @FindBy(xpath = "//ul[@class='menu-burger__main-list']//a[text()='Бытовая техника']")
    public WebElement householdAppliances;

    @FindBy(xpath = "//div[@data-menu-id='16107']//span[text()='Техника для дома']")
    public WebElement homeAppliances;

    @FindBy(xpath = "//span[text()='Пылесосы и пароочистители']")
    public WebElement vacuumNdSteamCleaners;

    @FindBy(xpath = "//div[@data-menu-id='16107']//a[text()='Пылесосы и пароочистители']")
    public WebElement vacuumNdSteamCleaners2;

    public SearchVacuumsNdCleaners(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public List<WebElement> getSearchPathFilters() {
        return List.of(householdAppliances, homeAppliances, vacuumNdSteamCleaners, vacuumNdSteamCleaners2);
    }
}
