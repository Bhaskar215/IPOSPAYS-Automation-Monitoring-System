package com.denovo.constants;

import com.denovo.Config.ReadPropertyFile;
import com.denovo.enums.ConfigProperties;

import java.time.Duration;

public final class FrameWorkConstants {

    private FrameWorkConstants(){

    }
    private static final int EXPLICITWAIT = 15;
    private static final String RESOURCESPATH = System.getProperty("user.dir")+"/src/test/resources";
    private static final String ExcelPATH =RESOURCESPATH +"/Excel/CloudPos.xlsx";
    private static final String EXTENTREPORTFOLDERPATH =System.getProperty("user.dir")+"/extent-test-output/";
    private static String extentReportFilePath ="";


    public static String getExtentReportFilePath() throws Exception {
        if(extentReportFilePath.isEmpty()){
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }

    public static String createReportPath() throws Exception {
        if(ReadPropertyFile.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("No")){
            return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/index.html";
        }
        else{
            return EXTENTREPORTFOLDERPATH+"/index.html";
        }
    }

    public static int getExplicitWait(){
        return EXPLICITWAIT;
    }


    public static String getExcelPATH() {
        return ExcelPATH;
    }


}
