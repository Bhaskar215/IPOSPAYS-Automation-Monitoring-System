package com.denovo.Driver;

import com.denovo.Config.ReadPropertyFile;
import com.denovo.enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public final class Driver {

    private Driver(){

    }

    public static void initDriver() throws Exception {
        if(Objects.isNull(DriverManager.getDriver())){
            WebDriverManager.chromedriver().setup();
           // WebDriver driver= new ChromeDriver();
            DriverManager.SetDriver(new ChromeDriver());
            DriverManager.getDriver().get(ReadPropertyFile.getValue(ConfigProperties.DEVURL));
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