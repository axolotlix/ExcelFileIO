package testutils;

import config.DriverType;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

import static config.DriverType.FIREFOX;
import static config.DriverType.valueOf;

public class WebDriverThread {

    private WebDriver webdriver;
    private DriverType selectedDriver;

    private final DriverType defaultDriver = FIREFOX;
    private final String browser = System.getProperty("browser").toUpperCase();
    private final String operatingSystem = System.getProperty("os.name").toUpperCase();
    private final String systemArchitecture = System.getProperty("os.arch");

    public WebDriver getDriver() throws Exception {
        if (null == webdriver) {
            selectedDriver = determineEffectiveDriver();
            instantiateWebDriver(selectedDriver.getDesiredCapabilities());
        }

        return webdriver;
    }

    private void instantiateWebDriver(MutableCapabilities desiredCapabilities) throws MalformedURLException {
        System.out.println();
        System.out.println("Current Operating System: " + systemArchitecture);
        System.out.println("Current Architecture: " + systemArchitecture);
        System.out.println("Current Browser Selection: " + browser);
        webdriver = selectedDriver.getWebDriverObject(desiredCapabilities);
    }

    private DriverType determineEffectiveDriver() {
        DriverType driverType = defaultDriver;
        try {
            driverType = valueOf(browser);
        } catch (IllegalArgumentException ignored) {
            System.err.println("Unknown driver specified, defaulting to '" + driverType + "'...");
        } catch (NullPointerException ignored) {
            System.err.println("No driver specified, defaulting to '" + driverType + "'...");
        }
        return driverType;
    }

    public void quitDriver() {
        if (null != webdriver) {
            webdriver.quit();
            webdriver = null;
        }
    }
}