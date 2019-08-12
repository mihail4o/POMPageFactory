package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Login;

import java.util.concurrent.TimeUnit;

public class TestLogin {
    WebDriver driver;
//    final String userName_value = "mngr214692", password_value = "nYrurUd";
    final String userName_value = "mgr123", password_value = "mgr!23";
    static {
        System.setProperty("webdriver.gecko.driver",
//                "C:\\Users\\mihovm.MASCORP\\Downloads\\selenium-java-3.141.59\\geckodriver.exe");
                "/Users/balivo/Downloads/selenium/course/geckodriver");

    }

    Login objLogin;
    HomePage objHomePage;

    @BeforeTest
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/");
    }

    /**

     * This test case will login in http://demo.guru99.com/V4/

     * Verify login page title as guru99 bank

     * Login to application

     * Verify the home page using Dashboard message

     */

    @Test (priority = 0)
    public void test_Homepage_Appear_Correct() {
        // Create login page object
        objLogin = new Login(driver);

        // Verify login page title
        String loginPageTitle = objLogin.getPageTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

        // Login to application
        objLogin.loginToSite(userName_value, password_value);

        // GoTo next page

        objHomePage = new HomePage(driver);

        // Verify home page
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
    }

}
