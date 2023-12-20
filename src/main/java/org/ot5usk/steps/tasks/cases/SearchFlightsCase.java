package org.ot5usk.steps.tasks.cases;

import org.openqa.selenium.WebElement;
import java.util.List;

public interface SearchFlightsCase extends Case {

    void clickFiltersBtn();

    void selectFilters();

    void fillFrom(String from);

    void fillTo(String to);

    void fillDate();

    List<WebElement> getSelectBtns();

    WebElement getSearchBtn();
}
