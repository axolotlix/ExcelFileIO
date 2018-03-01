package config;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.Arrays;
import java.util.HashMap;

public enum DriverType implements DriverSetup {
    FIREFOX {
        @Override
        public WebDriver getWebDriverObject(MutableCapabilities capabilities) {
            return new FirefoxDriver((FirefoxOptions) capabilities);
        }
        @Override
        public MutableCapabilities getDesiredCapabilities() {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setCapability("marionette", true);
            return firefoxOptions;
        }
    },
    CHROME {
        @Override
        public WebDriver getWebDriverObject(MutableCapabilities capabilities) {
            return new ChromeDriver((ChromeOptions) capabilities);
        }
        @Override
        public MutableCapabilities getDesiredCapabilities() {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setCapability("chrome.switches",
                    Arrays.asList("--no-default-browser-check"));
            HashMap<String, String> chromePreferences = new HashMap<>();
            chromePreferences.put("profile.password_manager_enabled", "false");
            chromeOptions.setCapability("chrome.prefs", chromePreferences);
            return chromeOptions;
        }
    },
    IE {
        @Override
        public WebDriver getWebDriverObject(MutableCapabilities capabilities) {
            return new InternetExplorerDriver((InternetExplorerOptions) capabilities);
        }
        @Override
        public MutableCapabilities getDesiredCapabilities() {
            InternetExplorerOptions ieOptions = new InternetExplorerOptions();
            ieOptions.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
            ieOptions.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
            ieOptions.setCapability("requireWindowFocus",true);
            return ieOptions;
        }
    },
    SAFARI {
        @Override
        public WebDriver getWebDriverObject(MutableCapabilities capabilities) {
            return new SafariDriver((SafariOptions) capabilities);
        }
        @Override
        public MutableCapabilities getDesiredCapabilities() {
            SafariOptions safariOptions = new SafariOptions();
            safariOptions.setCapability("safari.cleanSession", true);
            return safariOptions;
        }
    },
    OPERA {
        @Override
        public WebDriver getWebDriverObject(MutableCapabilities capabilities) {
            return new OperaDriver((OperaOptions) capabilities);
        }
        @Override
        public MutableCapabilities getDesiredCapabilities() {
            OperaOptions operaOptions = new OperaOptions();
            //operaOptions.setCapability("opera.blink", true);
            return operaOptions;
        }
    },
    EDGE {
        @Override
        public WebDriver getWebDriverObject(MutableCapabilities capabilities) {
            return new EdgeDriver((EdgeOptions) capabilities);
        }

        @Override
        public MutableCapabilities getDesiredCapabilities() {
            return null;
        }
    }
}
