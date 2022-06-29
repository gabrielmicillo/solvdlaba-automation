package com.qaprosoft.carina.demo.gabiGUI.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gabiGUI.pages.ProductPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Product extends AbstractUIObject {

    @FindBy(xpath = ".//span[@class='a-size-base-plus a-color-base a-text-normal']")
    private ExtendedWebElement productTitle;

    @FindBy(xpath = ".//div[@class='a-row a-size-base a-color-base']")
    private ExtendedWebElement productPrice;

    public Product(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductTitle(){
        return productTitle.getText();
    }

    public ProductPage clickProductTitle(){
        productTitle.click();
        return new ProductPage(driver);
    }
}
