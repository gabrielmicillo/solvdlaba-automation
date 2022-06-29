package com.qaprosoft.carina.demo.gabiGUI.pages;

import com.mongodb.DBPortPool;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gabiGUI.components.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchProductPage extends AbstractPage {

    @FindBy(xpath = "//div[starts-with(@cel_widget_id, 'MAIN-SEARCH_RESULTS')]")
    private List<Product> searchProducts;

    @FindBy(id = "s-refinements")
    private ExtendedWebElement sideBar;

    public SearchProductPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(sideBar);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public ProductPage getProduct(String productTitle){
        for (Product product : searchProducts){
            String currentProduct = product.getProductTitle();
            System.out.println(currentProduct);
            if (productTitle.equalsIgnoreCase(currentProduct)) {
                return product.clickProductTitle();
            }
        }
        throw new RuntimeException();
    }
}
