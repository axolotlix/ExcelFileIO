package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

class HRMMenuBar {

    private WebDriver driver;
    private List<WebElement> menuBar;

    @FindBy(css = "ul")
    private WebElement parentMenu;

    HRMMenuBar(WebDriver driver) {
        this.driver = driver;
        this.menuBar = parentMenu.findElements(By.tagName("//*"));
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
