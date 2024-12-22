package ui.tests;

import configs.ConfigReader;
import lombok.extern.slf4j.Slf4j;
import pages.LoginPage;
import pages.ProductsPage;


@Slf4j

public class TestBase
{
    ConfigReader configReader = new ConfigReader();
    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();

}
