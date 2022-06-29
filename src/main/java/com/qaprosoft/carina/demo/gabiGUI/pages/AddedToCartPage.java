package com.qaprosoft.carina.demo.gabiGUI.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AddedToCartPage extends AbstractPage {

    @FindBy(id = "sc-buy-box-ptc-button")
    private ExtendedWebElement proceedToPyButton;

    public AddedToCartPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(proceedToPyButton);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }
}
