package com.denovo.Listeners;

import com.denovo.Reports.ExtentLogger;
import com.denovo.Reports.ExtentReport;
import com.denovo.Util.ELKUtils;
import org.testng.*;

import java.io.IOException;

public class ListenerClass implements ITestListener, ISuiteListener {


    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        try {
            ExtentReport.flushReport();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " is Passed ");
        ELKUtils.sendResultToELK(result.getMethod().getMethodName(),"pass");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            ExtentLogger.fail(result.getMethod().getMethodName() + " is Failed",true);

            ExtentLogger.fail(result.getThrowable().toString());

            ELKUtils.sendResultToELK(result.getMethod().getDescription(),"fail");

            ELKUtils.sendfailureMessageToElk(result.getThrowable().toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " is Skiped");
        ELKUtils.sendResultToELK(result.getMethod().getDescription(),"skip");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
