package pages;

import org.openqa.selenium.By;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ProductsPage extends LoginPage
{
    private final By productsTitleLocator = By.className("title");
    private final By menuLocator = By.id("react-burger-menu-btn");
    private final By logoutLocator = By.id("logout_sidebar_link");

    /**
     * Method to check if product header title is displayed in products page.
     */
    public Boolean isProductsTitleDisplayed()
    {
        fluentwaitForPresenceOfElementLocated(productsTitleLocator, DEFAULT_TIMEOUT, DEFAULT_POLLING);
        return isDisplayed(productsTitleLocator);
    }

    /**
     * Method to click on menu button in products page.
     */
    public void clickMenu()
    {
        fluentwaitForElementClickable(menuLocator, DEFAULT_TIMEOUT, DEFAULT_POLLING);
        click(menuLocator);
        log.info("Menu is clicked.");

    }

    /**
     * Method to click logout button under menu in products page.
     */
    public void clickLogoutButton()
    {
        fluentwaitForElementClickable(logoutLocator, DEFAULT_TIMEOUT, DEFAULT_POLLING);
        click(logoutLocator);
        log.info("Logout button is clicked.");

    }
}
