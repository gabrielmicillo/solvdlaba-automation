package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gabiGUI.components.NavigateMenu;
import com.qaprosoft.carina.demo.gabiGUI.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebAmazonTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "gabi")
    public void testLogin() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Page not opened.");
        homePage.clickDontChangeButton();
        NavigateMenu navigateMenu = homePage.getNavigateMenu();
        pause(2);
        EmailLoginPage emailLoginPage = navigateMenu.clickLoginButton();
        Assert.assertTrue(emailLoginPage.isPageOpened(), "Email page not opened.");
        pause(2);
        emailLoginPage.fillWithEmail();
        PasswordLoginPage passwordLoginPage = emailLoginPage.clickContinueButton();
        Assert.assertTrue(passwordLoginPage.isPageOpened(), "Password page not opened.");
        passwordLoginPage.fillWithPassword();
        passwordLoginPage.clickSubmitButton();
        Assert.assertTrue(navigateMenu.isAccountLoggedIn(), "Account is not logged in.");
    }

    @Test()
    @MethodOwner(owner = "gabi")
    public void testLogOut() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Page not opened.");
        homePage.clickDontChangeButton();
        NavigateMenu navigateMenu = homePage.getNavigateMenu();
        EmailLoginPage emailLoginPage = navigateMenu.clickLoginButton();
        Assert.assertTrue(emailLoginPage.isPageOpened(), "Email page not opened.");
        pause(2);
        emailLoginPage.fillWithEmail();
        PasswordLoginPage passwordLoginPage = emailLoginPage.clickContinueButton();
        Assert.assertTrue(passwordLoginPage.isPageOpened(), "Password page not opened.");
        passwordLoginPage.fillWithPassword();
        passwordLoginPage.clickSubmitButton();
        Assert.assertTrue(navigateMenu.isAccountLoggedIn(), "Account is not logged in.");
//        HomePage homePage = new HomePage(getDriver());
//        homePage.open();
//        Assert.assertTrue(homePage.isPageOpened(), "Page not opened.");
//        homePage.clickDontChangeButton();
//        NavigateMenu navigateMenu = homePage.getNavigateMenu();
//        Assert.assertTrue(navigateMenu.isAccountLoggedIn(), "Account is not logged in.");
        emailLoginPage = navigateMenu.clickSignOutButton();
        Assert.assertTrue(emailLoginPage.isPageOpened(), "Email page not opened.");
    }

    @Test()
    @MethodOwner(owner = "gabi")
    public void testAddToCart(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Page not opened.");
        homePage.clickDontChangeButton();
        NavigateMenu navigateMenu = homePage.getNavigateMenu();
        pause(2);
        EmailLoginPage emailLoginPage = navigateMenu.clickLoginButton();
        Assert.assertTrue(emailLoginPage.isPageOpened(), "Email page not opened.");
        pause(2);
        emailLoginPage.fillWithEmail();
        PasswordLoginPage passwordLoginPage = emailLoginPage.clickContinueButton();
        Assert.assertTrue(passwordLoginPage.isPageOpened(), "Password page not opened.");
        passwordLoginPage.fillWithPassword();
        passwordLoginPage.clickSubmitButton();
        Assert.assertTrue(navigateMenu.isAccountLoggedIn(), "Account is not logged in.");
        SearchProductPage searchProductPage = navigateMenu.searchProduct();
        Assert.assertTrue(searchProductPage.isPageOpened(), "Search page not opened.");
        pause(2);
        ProductPage productPage = searchProductPage.getProduct("adidas Boca Juniors 3rd 22/23 - Camiseta para hombre");
        Assert.assertTrue(productPage.isPageOpened(), "Product page not opened.");
        Assert.assertEquals(productPage.getProductTitle(), "adidas Boca Juniors 3rd 22/23 - Camiseta para hombre", "Invalid title.");
        Assert.assertEquals(productPage.getProductPrice(), "US$89.99", "Invalid price.");
        pause(2);
        AddedToCartPage addedToCartPage = productPage.clickAddToCartButton();
        Assert.assertTrue(addedToCartPage.isPageOpened());
    }

    @Test()
    @MethodOwner(owner = "gabi")
    public void testSearchJobs() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Page not opened.");
        pause(2);
        WorkWithUsPage workWithUsPage = homePage.clickWorkWithUs();
        Assert.assertTrue(workWithUsPage.isPageOpened());
        pause(2);
        JobResultsPage jobResultsPage = workWithUsPage.searchJob();
        Assert.assertTrue(jobResultsPage.isPageOpened());
    }
}
