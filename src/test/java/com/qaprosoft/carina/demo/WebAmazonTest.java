package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
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
        homePage.clickDontChangeButtonIfPresent();
        NavigateMenu navigateMenu = homePage.getNavigateMenu();
        EmailLoginPage emailLoginPage = navigateMenu.clickLoginButton();
        Assert.assertTrue(emailLoginPage.isPageOpened(), "Email page not opened.");
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
        homePage.clickDontChangeButtonIfPresent();
        NavigateMenu navigateMenu = homePage.getNavigateMenu();
        EmailLoginPage emailLoginPage = navigateMenu.clickLoginButton();
        Assert.assertTrue(emailLoginPage.isPageOpened(), "Email page not opened.");
        emailLoginPage.fillWithEmail();
        PasswordLoginPage passwordLoginPage = emailLoginPage.clickContinueButton();
        Assert.assertTrue(passwordLoginPage.isPageOpened(), "Password page not opened.");
        passwordLoginPage.fillWithPassword();
        passwordLoginPage.clickSubmitButton();
        Assert.assertTrue(navigateMenu.isAccountLoggedIn(), "Account is not logged in.");
        emailLoginPage = navigateMenu.clickSignOutButton();
        Assert.assertTrue(emailLoginPage.isPageOpened(), "Email page not opened.");
    }

    @Test
    @MethodOwner(owner = "gabi")
    public void testAddToCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Page not opened.");
        homePage.clickDontChangeButtonIfPresent();
        NavigateMenu navigateMenu = homePage.getNavigateMenu();
        pause(2);
        EmailLoginPage emailLoginPage = navigateMenu.clickLoginButton();
        Assert.assertTrue(emailLoginPage.isPageOpened(), "Email page not opened.");
        emailLoginPage.fillWithEmail();
        PasswordLoginPage passwordLoginPage = emailLoginPage.clickContinueButton();
        Assert.assertTrue(passwordLoginPage.isPageOpened(), "Password page not opened.");
        passwordLoginPage.fillWithPassword();
        passwordLoginPage.clickSubmitButton();
        Assert.assertTrue(navigateMenu.isAccountLoggedIn(), "Account is not logged in.");
        SearchProductPage searchProductPage = navigateMenu.searchProduct();
        Assert.assertTrue(searchProductPage.isPageOpened(), "Search page not opened.");
        ProductPage productPage = searchProductPage.getProduct(searchProductPage.getWantedProductTitle("expected_search_product_title"));
        Assert.assertTrue(productPage.isPageOpened(), "Product page not opened.");
        Assert.assertEquals(productPage.getProductTitle(), searchProductPage.getWantedProductTitle("expected_search_product_title"), "Invalid title.");
        Assert.assertEquals(productPage.getProductPrice(), productPage.getWantedProductPrice("expected_search_product_price"), "Invalid price.");
        AddedToCartPage addedToCartPage = productPage.clickAddToCartButton();
        Assert.assertTrue(addedToCartPage.isPageOpened());
    }

    @Test(dataProvider = "DataProvider")
    @MethodOwner(owner = "gabi")
    @XlsDataSourceParameters(path = "xls/dataprovider.xlsx", sheet = "Jobs", dsUid = "TUID", dsArgs = "jobs", testRailColumn = "jobs")
    public void testSearchJobs(String jobs) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Page not opened.");
        WorkWithUsPage workWithUsPage = homePage.clickWorkWithUs();
        Assert.assertTrue(workWithUsPage.isPageOpened());
        JobResultsPage jobResultsPage = workWithUsPage.searchJob(jobs);
        Assert.assertTrue(jobResultsPage.isPageOpened());
    }

    @Test
    @MethodOwner(owner = "gabi")
    public void testSearchOutletProducts() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Page not opened.");
        homePage.clickDontChangeButtonIfPresent();
        TodaysDealsPage todaysDealsPage = homePage.clickTodayDealsButton();
        Assert.assertTrue(todaysDealsPage.isPageOpened(), "Today's deals page is not opened.");
        OutletPage outletPage = todaysDealsPage.clickOutletButton();
        Assert.assertTrue(outletPage.isPageOpened(), "Outlet page is not opened.");
        SearchOutletProductPage searchOutletProductPage = outletPage.getNavigateMenu().searchProductOutlet();
        Assert.assertTrue(searchOutletProductPage.isPageOpened(), "Search Outlet Product Page is not opened.");

    }
}
