package ui.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import configs.ConfigReader;
import lombok.extern.slf4j.Slf4j;
import utils.TestGroups;


@Slf4j
public class LoginPageTests extends TestBase
{

    @BeforeTest(alwaysRun = true)
    public void suitSetUp() throws IOException
    {
        log.info("Initalize and launch browser.");
        loginPage.setBrowserAndLaunch();
        log.info("Reading config file ui/urls.");
        ConfigReader.readPropertiesFromFile("ui/urls");
        loginPage.getUrl(configReader.getProperty("swaglabs.url"));
        log.info("Reading config file ui/loginDetails.");
        ConfigReader.readPropertiesFromFile("ui/loginDetails");

    }

    @Test(enabled = true, groups = {TestGroups.LOGIN_PAGE, TestGroups.SANITY, TestGroups.UI}, priority = 1)
    public void enterValidLogin()
    {
        log.info("-------Verify user is able to login when valid login details are entered.--------");
        Assert.assertTrue(loginPage.isLoginLogoDisplayed(), "Login page is not displayed");
        loginPage.enterUsername(configReader.getProperty("username"));
        loginPage.enterPassword(configReader.getProperty("password"));
        loginPage.clickLoginButton();
        Assert.assertTrue(productsPage.isProductsTitleDisplayed(), "Login failed.");

    }

    @Test(enabled = true, groups = {TestGroups.LOGIN_PAGE, TestGroups.REGRESSION, TestGroups.UI}, dependsOnMethods = "enterValidLogin", priority = 2)
    public void enterInvalidUsername_ValidPassword()
    {
        log.info("-------Verify user is not able to login when invalid username and valid password are entered.--------");
        if (productsPage.isProductsTitleDisplayed())
        {
            productsPage.clickMenu();
            productsPage.clickLogoutButton();
        }
        Assert.assertTrue(loginPage.isLoginLogoDisplayed(), "Login page is not displayed");
        loginPage.enterUsername(configReader.getProperty("invalid.username"));
        loginPage.enterPassword(configReader.getProperty("password"));
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getFailedLoginErrorDisplayed(),
            "Epic sadface: Username and password do not match any user in this service",
            "Error message for username mandatory field is not displayed.");

    }

    @Test(enabled = true, groups = {TestGroups.LOGIN_PAGE, TestGroups.REGRESSION, TestGroups.UI}, dependsOnMethods = "enterValidLogin", priority = 3)
    public void enterValidUsername_InvalidPassword()
    {
        log.info("-------Verify user is not able to login when valid username and invalid password are entered.--------");
        loginPage.enterUsername(configReader.getProperty("username"));
        loginPage.enterPassword(configReader.getProperty("invalid.password"));
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getFailedLoginErrorDisplayed(),
            "Epic sadface: Username and password do not match any user in this service",
            "Error message for username mandatory field is not displayed.");

    }

    @AfterTest(alwaysRun = true)
    public void tearDown()
    {
        loginPage.quitBrowser();
    }
}
