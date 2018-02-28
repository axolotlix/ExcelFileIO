package testutils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriverThread> driverThread;

    @BeforeClass
    public static void instantiateDriverObject() {
        driverThread = new ThreadLocal<WebDriverThread>() {
            @Override
            protected WebDriverThread initialValue() {
                return new WebDriverThread();
            }
        };
    }

    public static WebDriver getDriver() throws Exception {
        return driverThread.get().getDriver();
    }

    @AfterClass
    public static void quitDriver() throws Exception {
        driverThread.get().quitDriver();
    }
}