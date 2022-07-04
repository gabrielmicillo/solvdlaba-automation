package com.qaprosoft.carina.demo.gabiGUI.pages;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    @FindBy(css = "#productTitle")
    private ExtendedWebElement productTitle;

    @FindBy(xpath = ".//span[starts-with(@class, 'a-price a-text-price a')]")
    private ExtendedWebElement productPrice;

    @FindBy(id = "dropdown_selected_size_name")
    private ExtendedWebElement selectSizeButton;

    @FindBy(id = "native_dropdown_selected_size_name_1")
    private ExtendedWebElement selectSButton;

    @FindBy(id = "add-to-cart-button")
    private ExtendedWebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(productTitle);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public AddedToCartPage clickAddToCartButton() {
        selectSizeButton.click();
        selectSButton.click();
        addToCartButton.assertElementPresent(5);
        addToCartButton.click();
        return new AddedToCartPage(driver);
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public String getWantedProductPrice(String wantedProductPrice) {
        String wantedPrice = R.TESTDATA.get(wantedProductPrice);
        return wantedPrice;
    }
}
