package com.denovo.Util.Listeners;

import com.denovo.Base.TestBase;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestAllureListeners extends TestBase implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
    saveScreenshotOnFailure(driver);
    savelogs(result.getMethod().getConstructorOrMethod().getName());

    }

    @Attachment(value = "screenshots" , type = "img/png")
    public byte[] saveScreenshotOnFailure(WebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Stacktrace", type = "text/plain")
    public static String savelogs(String message){
        return message;
    }
}