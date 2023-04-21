package com.denovo.factories;

import com.denovo.Config.ReadPropertyFile;
import com.denovo.enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class DriverFactory {

    private DriverFactory() {

    }

    public static WebDriver getDriver(String browser) throws MalformedURLException {

        WebDriver driver = null;

        String runmode = ReadPropertyFile.getValue(ConfigProperties.RUNMODE);

        if (browser.equalsIgnoreCase("chrome")) {
            if(runmode.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                cap.setBrowserName(BrowserType.CHROME);
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            }
            else{
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        }

        else if (browser.equalsIgnoreCase("edge")) {
            if (runmode.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(BrowserType.EDGE);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
            }
            else {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        }
        return driver;
    }
}