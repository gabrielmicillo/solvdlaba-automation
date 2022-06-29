/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo.gabiGUI.components;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gabiGUI.pages.EmailLoginPage;
import com.qaprosoft.carina.demo.gabiGUI.pages.SearchProductPage;
import com.qaprosoft.carina.demo.gui.pages.CompareModelsPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NavigateMenu extends AbstractUIObject {

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//a[@data-nav-ref='nav_youraccount_btn']")
    private ExtendedWebElement accountName;

    @FindBy(xpath = "//*[@id='nav-item-signout']/span")
    private ExtendedWebElement signOutButton;

    @FindBy(id = "twotabsearchtextbox")
    private ExtendedWebElement searchField;

    @FindBy(id = "nav-search-submit-text")
    private ExtendedWebElement sendSearch;


    public NavigateMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public EmailLoginPage clickLoginButton(){
        loginButton.click();
        return new EmailLoginPage(driver);
    }

    public boolean isAccountLoggedIn(){
        return accountName.isElementPresent();
    }

    public EmailLoginPage clickSignOutButton(){
        loginButton.hover();
        pause(3);
        signOutButton.click();
        return new EmailLoginPage(driver);
    }

    public SearchProductPage searchProduct(){
        searchField.type(R.TESTDATA.get("searchProduct"));
        sendSearch.click();
        return new SearchProductPage(driver);
    }
}
