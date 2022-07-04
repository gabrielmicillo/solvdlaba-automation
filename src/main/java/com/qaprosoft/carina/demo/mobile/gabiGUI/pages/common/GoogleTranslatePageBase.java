package com.qaprosoft.carina.demo.mobile.gabiGUI.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class GoogleTranslatePageBase extends AbstractPage {

    public GoogleTranslatePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void enterTextToTranslate();

    public abstract String compareTranslation();

    public abstract String getCorrectTranslation(String correctTranslation);

    public abstract LanguagesPageBase changeLanguageFrom();

    public abstract LanguagesPageBase changeLanguageTo();
}
