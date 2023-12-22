package org.ot5usk.pages.wb_pages.wb_pages_elements.wb_default_pages_elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.ot5usk.pages.abstract_pages.Page;
import org.ot5usk.pages.abstract_pages.abstract_pages_elements.abstract_default_pages_elements.PathFilters;

import java.util.List;

public class WbPathFilters extends PathFilters {

    public Page page;

    @FindBy(xpath = "//button[contains(@aria-label, 'Навигация по сайту')]")
    public WebElement btn;

    public WbPathFilters(Page page, List<WebElement> pathFilters) {
        super(page);
        PageFactory.initElements(page.webDriver, this);
        super.btn = btn;
        super.setPath(pathFilters);
    }

    public WbPathFilters(Page page) {
        super(page);
        PageFactory.initElements(page.webDriver, this);
        super.btn = btn;
    }
}
