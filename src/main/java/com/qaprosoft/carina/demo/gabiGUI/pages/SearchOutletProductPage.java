package com.qaprosoft.carina.demo.gabiGUI.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchOutletProductPage extends AbstractPage {

    @FindBy(xpath = "//span[starts-with(@data-component-type, 's-m')]")
    private ExtendedWebElement resultsHeader;

    public SearchOutletProductPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(resultsHeader);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

}
