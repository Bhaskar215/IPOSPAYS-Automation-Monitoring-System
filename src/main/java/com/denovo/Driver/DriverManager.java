package com.denovo.Driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> dr= new ThreadLocal<>();

    public static WebDriver getDriver(){
        return dr.get();
    }

    public static void SetDriver(WebDriver driverRef){
        dr.set(driverRef);
    }

    public static void unload(){
        dr.remove();
    }

}
