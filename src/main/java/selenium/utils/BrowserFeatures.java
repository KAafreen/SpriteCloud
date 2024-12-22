package selenium.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class BrowserFeatures extends WebDriverClass
{

    public WebDriver setBrowserAndLaunch()
    {

        try
        {
            final var options = new ChromeOptions();
            options.addArguments("lang=en-US");
            options.addArguments("disable-infobars");
            final DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(System.getProperty("browser"));
            URL hubUrl = new URL(System.getProperty("seleniumHubUrl"));
            driver = new RemoteWebDriver(hubUrl, capabilities);
            driver.manage().window().maximize();
            return driver;

        }
        catch (MalformedURLException e)
        {
            log.info("Failed to set and launch browser.", e);
        }

        return driver;
    }

    /**
     * Launch url.
     *
     * @param url
     */
    public void getUrl(String url)
    {
        driver.get(url);
        log.info("Url is open in the browser.");
    }

    /**
     * Close browser.
     */
    public void closeBrowser()
    {
        driver.close();
    }

    /**
     * Quit browser.
     */
    public void quitBrowser()
    {
        driver.quit();
        log.info("Browser is closed.");
    }
}
