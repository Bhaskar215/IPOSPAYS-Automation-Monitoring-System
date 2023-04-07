package com.denovo.Util;

import org.openqa.selenium.By;

public final class DynamicXpathUtils {

    private DynamicXpathUtils(){

    }


    public static String getXpath(String xpath,String value){
        return String.format(xpath,value);
    }

    public static String getXpath(String xpath,String value1,String value2){
        return String.format(xpath,value1,value2);
    }

    //This method will return list of Button text On Paramter Section
    public static String getSwitchBtnTextXpath(String xpath, String value){
        return String.format(xpath,value);
    }

}
