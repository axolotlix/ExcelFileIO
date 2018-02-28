package testutils;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasicTestWD extends DriverFactory {

    private void googleExampleThatSearchesFor(final String searchString) throws Exception {

        WebDriver driver = DriverFactory.getDriver();

        driver.get("http://www.google.com");

        WebElement searchField = driver.findElement(By.name("q"));

        searchField.clear();
        searchField.sendKeys(searchString);

        System.out.println("Page title is: " + driver.getTitle());

        searchField.submit();

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driverObject) {
                return driverObject.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
            }
        });

        System.out.println("Page title is: " + driver.getTitle());

        quitDriver();
    }

    @Test
    public void googleCheeseExample() throws Exception {
        googleExampleThatSearchesFor("Cheese!");
    }

    @Test
    public void googleBreadExample() throws Exception {
        googleExampleThatSearchesFor("Bread!");
    }
    @Test
    public void googleHamExample() throws Exception {
        googleExampleThatSearchesFor("Ham!");
    }
    @Test
    public void googleMilkExample() throws Exception {
        googleExampleThatSearchesFor("Milk!");
    }
}