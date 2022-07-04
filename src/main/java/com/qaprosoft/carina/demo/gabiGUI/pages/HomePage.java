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
package com.qaprosoft.carina.demo.gabiGUI.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gabiGUI.components.NavigateMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;


public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//input[@data-action-type='DISMISS']")
    private ExtendedWebElement dontChangeButton;

    @FindBy(id = "nav-belt")
    private NavigateMenu navigateMenu;

    @FindBy(xpath = "//a[@href='https://www.amazon.jobs']")
    private ExtendedWebElement workWithUs;

    @FindBy(xpath = "//a[@data-csa-c-content-id='nav_cs_gb']")
    private ExtendedWebElement todayDealsButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageURL("");
    }

    //    This pop-up appears when browser does not open native language page, when this happens this method closes it
    public void clickDontChangeButtonIfPresent() {
        if (dontChangeButton.isElementPresent()) {
            dontChangeButton.click();
        }
    }

    public NavigateMenu getNavigateMenu() {
        return navigateMenu;
    }

    public WorkWithUsPage clickWorkWithUs() {
        workWithUs.assertElementPresent();
        workWithUs.click();
        return new WorkWithUsPage(driver);
    }

    public TodaysDealsPage clickTodayDealsButton() {
        todayDealsButton.assertElementWithTextPresent("Ofertas del Día", 5);
        todayDealsButton.click();
        return new TodaysDealsPage(driver);
    }

}