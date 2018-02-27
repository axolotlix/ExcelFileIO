package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    private static final String URL = "http://opensource.demo.orangehrmlive.com";
    private WebDriver driver;

    @FindBy(css = "#txtUsername")
    private WebElement txtUsername;
    @FindBy(css = "#txtPassword")
    private WebElement txtPassword;
    @FindBy(css = "#btnLogin")
    private WebElement btnLogin;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setTxtUsername(String input) {
        txtUsername.sendKeys(input);
    }
    public void setTxtPassword(String input) {
        txtPassword.sendKeys(input);
    }
    public void clkLogin() {
        btnLogin.click();
    }
    public  DashboardPage loginWithValidCreds(String username, String password) {
        setTxtUsername(username);
        setTxtPassword(password);
        clkLogin();
        return new DashboardPage(driver);
    }
}
