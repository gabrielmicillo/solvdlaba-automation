package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.mobile.gabiGUI.pages.common.GoogleTranslatePageBase;
import com.qaprosoft.carina.demo.mobile.gabiGUI.pages.common.LanguagesPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileGabiTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "gabi")
    public void TranslateSomething() {
        GoogleTranslatePageBase googleTranslatePage = initPage(getDriver(), GoogleTranslatePageBase.class);
        Assert.assertTrue(googleTranslatePage.isPageOpened());
        googleTranslatePage.enterTextToTranslate();
        Assert.assertEquals(googleTranslatePage.compareTranslation(), googleTranslatePage.getCorrectTranslation("translated_text"), "Translation is not correct.");
    }

    @Test()
    @MethodOwner(owner = "gabi")
    public void changeLanguages() {
        GoogleTranslatePageBase googleTranslatePage = initPage(getDriver(), GoogleTranslatePageBase.class);
        googleTranslatePage.isPageOpened();
        LanguagesPageBase languagesPageBase = googleTranslatePage.changeLanguageFrom();
        languagesPageBase.isPageOpened();
        googleTranslatePage = languagesPageBase.chooseFrench();
        googleTranslatePage.isPageOpened();
        languagesPageBase = googleTranslatePage.changeLanguageTo();
        languagesPageBase.isPageOpened();
        googleTranslatePage = languagesPageBase.chooseGreek();
        Assert.assertTrue(googleTranslatePage.isPageOpened());
    }

}
