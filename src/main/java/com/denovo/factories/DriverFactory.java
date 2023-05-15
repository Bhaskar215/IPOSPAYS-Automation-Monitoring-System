package com.denovo.factories;

import com.denovo.Config.ReadPropertyFile;
import com.denovo.Driver.DriverManager;
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
import java.util.ArrayList;
import java.util.HashMap;

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
               /* options.addArguments("--headless");
                options.addArguments("no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                cap.setBrowserName(BrowserType.CHROME);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
                driver.manage().window().fullscreen();*/

                options.setCapability("selenoid:options", new HashMap() {{
                    put("name", "Test badge...");
                    put("sessionTimeout", "5m");
                    put("screenResolution","1920x1080x24");
                    put("headless",true);
                    put("enableVNC", true); // if true While exection test case we will see video
                    put("enableVideo", false); //if true while execution it will save the video
                    put("env", new ArrayList<String>() {{add("TZ=UTC"); }});
                    put("labels", new HashMap<String, Object>()
                    {{put("manual", "true");}});
                }});
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
                driver.manage().window().fullscreen();

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
