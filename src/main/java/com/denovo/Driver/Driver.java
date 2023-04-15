package com.denovo.Driver;

import com.denovo.Config.ReadPropertyFile;
import com.denovo.enums.ConfigProperties;
import com.denovo.exceptions.BrowserInvocationFailedException;
import com.denovo.factories.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public final class Driver {

    private Driver(){

    }

    public static void initDriver(String browser) {
        if(Objects.isNull(DriverManager.getDriver())){
            try {
                DriverManager.SetDriver(DriverFactory.getDriver(browser));
            }  catch (MalformedURLException e) {
                throw new BrowserInvocationFailedException("Please check the capabilities of the Browser");
            }
            DriverManager.getDriver().get(ReadPropertyFile.getValue(ConfigProperties.URL));
            DriverManager.getDriver().manage().window().maximize();
        }
    }

    public static void quitDriver(){
        if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}