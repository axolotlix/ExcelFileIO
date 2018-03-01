package testutils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverFactory {

    private static ThreadLocal<WebDriverThread> driverThread;
    private static List<WebDriverThread> webDriverThreadPool = Collections.synchronizedList(new ArrayList<>());

    @BeforeClass
    public static void instantiateDriverObject() {
        driverThread = new ThreadLocal<WebDriverThread>() {
            @Override
            protected WebDriverThread initialValue() {
                WebDriverThread webDriverThread = new WebDriverThread();
                webDriverThreadPool.add(webDriverThread);
                return webDriverThread;
            }
        };
    }
    public static WebDriver getDriver() throws Exception {
        return driverThread.get().getDriver();
    }
    @After
    public void clearCookies() throws Exception {
        getDriver().manage().deleteAllCookies();
    }
    @AfterClass
    public static void closeDriverObjects() throws Exception{
        for (WebDriverThread webDriverThread : webDriverThreadPool) {
            webDriverThread.quitDriver();
        }
    }
}