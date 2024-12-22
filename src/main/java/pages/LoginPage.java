package pages;

import org.openqa.selenium.By;

import lombok.extern.slf4j.Slf4j;
import selenium.utils.ElementOperations;


@Slf4j
public class LoginPage extends ElementOperations
{
    private final By usernameLocator = By.id("user-name");
    private final By passwordLocator = By.id("password");
    private final By loginBtnLocator = By.id("login-button");
    private final By loginLogoLocator = By.className("login_logo");
    private final By usernameRequiredErrorLocator = By.className("error-message-container");

    /**
     * Method to enter username in login page.
     *
     * @param username
     */
    public void enterUsername(final String username)
    {
        type(usernameLocator, username);
        log.info("Username entered in login page.");
    }

    /**
     * Method to enter password in login page.
     *
     * @param password
     */
    public void enterPassword(final String password)
    {
        type(passwordLocator, password);
        log.info("Password entered in login page.");

    }

    /**
     * Method to click login button in login page.
     */
    public void clickLoginButton()
    {
        fluentwaitForPresenceOfElementLocated(loginBtnLocator, DEFAULT_TIMEOUT, DEFAULT_POLLING);
        click(loginBtnLocator);
        log.info("Login button is clicked.");

    }

    /**
     * Method to verify if logo is displayed in login page.
     */
    public Boolean isLoginLogoDisplayed()
    {
        return isDisplayed(loginLogoLocator);

    }

    /**
     * Method to get error messages when username and password fields are invalid in login page.
     */
    public String getFailedLoginErrorDisplayed()
    {
        fluentwaitForPresenceOfElementLocated(usernameRequiredErrorLocator, DEFAULT_TIMEOUT, DEFAULT_POLLING);
        return getText(usernameRequiredErrorLocator);
    }

}
