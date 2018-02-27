package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends HRMMenuBar{
    private static final String URL = "http://opensource.demo.orangehrmlive.com/index.php/dashboard";
    //private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        super(driver);
        //this.driver = driver;
    }

    public String getPageTitle() {
        return super.getDriver().getTitle();
    }
}
