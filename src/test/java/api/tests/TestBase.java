package api.tests;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;

import configs.ConfigReader;
import lombok.extern.slf4j.Slf4j;
import restapi.RestAssuredUtils;


@Slf4j
public class TestBase
{
    ConfigReader configReader = new ConfigReader();

    @BeforeMethod(alwaysRun = true)
    public void testSetup() throws IOException
    {
        log.info("Setting api configurations.");
        ConfigReader.readPropertiesFromFile("api/apiconfig");
        RestAssuredUtils.setBaseUrl(configReader.getProperty("api.baseurl"));
        ConfigReader.readPropertiesFromFile("api/users");
        RestAssuredUtils.setUsername(configReader.getProperty("api.auth.username"));
        RestAssuredUtils.setPassword(configReader.getProperty("api.auth.password"));
        log.info("Api configurations are set.");
    }

}
