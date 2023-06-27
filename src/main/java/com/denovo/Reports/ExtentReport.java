package com.denovo.Reports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.denovo.constants.FrameWorkConstants;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport(){

    }

    private static ExtentReports extent;

    public static void initReport()
    {
        if(Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = null;
            try {
                spark = new ExtentSparkReporter(FrameWorkConstants.getExtentReportFilePath());
            } catch (Exception e) {
                e.printStackTrace();
            }
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Ipospays Automation Reports");
            spark.config().setReportName("Regression");
        }
    }

    public static void flushReport() throws IOException {
        if (Objects.nonNull(extent)) {
            extent.flush();
            ExtentManager.unload();
          /*  try {
                Desktop.getDesktop().browse(new File(FrameWorkConstants.getExtentReportFilePath())
                        .toURI());
            } catch (Exception e) {
                e.printStackTrace();
            }*/
        }
    }

    public static void createTest(String testcasename)
    {
        ExtentManager.SetExtentTest(extent.createTest(testcasename).assignAuthor("Bhaskar Murthy").assignCategory("Regression"));
    }
}