package com.denovo.Reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.denovo.Config.ReadPropertyFile;
import com.denovo.Driver.DriverManager;
import com.denovo.Util.ScreenshotUtils;
import com.denovo.enums.ConfigProperties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ExtentLogger {

    private ExtentLogger(){

    }

    //Default -->it can be only Accesed within Package or Private Package modifier
    public static void pass(String message){
        ExtentManager.getExtentReport().pass(message);
    }

    public static void fail(String message){
        ExtentManager.getExtentReport().fail(message);
    }

    public static void skip(String message){
        ExtentManager.getExtentReport().skip(message);
    }

    public static void pass(String message,boolean isScreenShotNeeded) throws Exception {
        if(ReadPropertyFile.getValue(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
                && isScreenShotNeeded){
        ExtentManager.getExtentReport().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }
        else{
            pass(message);
        }
    }

    public static void fail(String message,boolean isScreenShotNeeded) throws Exception {
        if(ReadPropertyFile.getValue(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
                && isScreenShotNeeded){
            ExtentManager.getExtentReport().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }
        else{
            fail(message);
        }
    }


    public static void skip(String message,boolean isScreenShotNeeded) throws Exception {
        if(ReadPropertyFile.getValue(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
                && isScreenShotNeeded){
            ExtentManager.getExtentReport().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }
        else{
            skip(message);
        }
    }
}
