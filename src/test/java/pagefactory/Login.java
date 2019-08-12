package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    /**

     * All WebElements are identified by @FindBy annotation

     */
    private WebDriver driver;

    @FindBy(name = "uid")
    private WebElement uName;

    @FindBy(name = "password")
    private WebElement uPassword;

    @FindBy(className = "barone")
    private WebElement titleText;

    @FindBy(name = "btnLogin")
    private WebElement bnLogin;

    public Login(WebDriver driver) {
        this.driver = driver;

        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    // Set username in textbox
    private void setUsername(String strUsername) {
        uName.sendKeys(strUsername);
    }

    // Set password in textbox
    private void setPassword(String strPassword) {
        uPassword.sendKeys(strPassword);
    }

    // Submit login
    private void setLogin() {
        bnLogin.click();
    }

    // Get the title of login page
    public String getLoginTitle() {
        return titleText.getText();
    }

    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return

     */

    public void loginToSite(String strUsername, String strPassword) {
        // Fill username
        this.setUsername(strUsername);

        // Fill password
        this.setPassword(strPassword);

        this.setLogin();
    }


}
