package com.denovo.Reports;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public final class ExtentManager {

    private ExtentManager(){

    }

    private static final ThreadLocal<ExtentTest> extTest= new ThreadLocal<>();

    //Default -->it can be only Accesed within Package or Private Package modifier
    static ExtentTest getExtentReport(){
        return extTest.get();
    }

     static void SetExtentTest(ExtentTest test){
        extTest.set(test);
    }

     static void unload(){
        extTest.remove();
    }

}
