package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class Login {

    private WebDriver driver;

    private By uName = By.name("uid");
    private By uPassword = By.name("password");
    private By titleText = By.className("barone");
    private By btLogin = By.name("btnLogin");

public Login(WebDriver driver) {
    this.driver = driver;
}

    // Set username in set box
    private void setUsername(String strUserName) {
        driver.findElement(uName).sendKeys(strUserName);
    }

    // Set password in password box
    private void setPassword(String strPassword) {
        driver.findElement(uPassword).sendKeys(strPassword);
    }

    // Submit form
    private void siteLogin() {
        driver.findElement(btLogin).click();
    }

    // Get the title of the login page
    public String getPageTitle() {
        return driver.findElement(titleText).getText();
    }

    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return

     */

    public void loginToSite(String strUser, String strPassword) {
        // Fill username
        this.setUsername(strUser);
        // Fill password
        this.setPassword(strPassword);
        // Click login button
        this.siteLogin();
    }

}
