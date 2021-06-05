package com.denovo.Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StringUtil {


    public static void ClickRadioBtnByValue(String value, List<WebElement> element, WebDriver driver) {
        boolean flag = false;
        for (WebElement ele : element) {
            if (ele.getAttribute("value").equalsIgnoreCase(value)) {
                flag = true;
                JavascriptExecutorUtil.clickElementByJs(driver, ele);
                break;
            }
        }
        if (flag == false) {
            System.out.println("element not found");
        }
    }


    public static void ClickRadioBtnByValue(String value, WebElement element, WebDriver driver) {

        boolean flag = false;
        if (element.getAttribute("value").equalsIgnoreCase(value)) {
            flag = true;
            JavascriptExecutorUtil.clickElementByJs(driver, element);
        }
        if (flag == false) {
            System.out.println("element not found Dti");
        }
    }

    public static void ClicklistofBtnByValue(String value, List<WebElement> element, WebDriver driver) {
        boolean flag = false;
        for (WebElement ele : element) {
            if (ele.getAttribute("value").equalsIgnoreCase(value)) {
                flag = true;
                JavascriptExecutorUtil.clickElementByJs(driver, ele);
                break;
            }
        }
        if (flag == false) {
            System.out.println("element not found");
        }
    }

    public static void ClicklistofBtnByGetText(String value, List<WebElement> element, WebDriver driver) {

        boolean flag = false;
        for (WebElement ele : element) {
            if (ele.getText().equalsIgnoreCase(value)) {
                flag = true;
                JavascriptExecutorUtil.clickElementByJs(driver, ele);
                break;
            }
        }
        if (flag == false) {
            System.out.println("element not found");
        }
    }

    public static void ClickMultiSelectCheckBox(String value, List<WebElement> elements) {

        String arr[] = value.split(",");
        for (int i = 0; i < arr.length; i++) {
            for (WebElement ele : elements) {
                if (ele.getText().equalsIgnoreCase(arr[i])) {
                    //multiselect
                    ele.click();
                    break;
                }
            }
        }

    }

    public static int getBuildNo(WebElement element) {

        String str=element.getText();
        System.out.println(str);
        if(str.equals("No Latest builds")) {
            return 1;
        }
        else {
            String build[] =str.split(" ");

            for(int i=0;i<build.length;i++){
                System.out.println(build[i]);
            }

            String actualbuildno = build[3].trim();

            //convert String value to Integervalue
            int buildnum=Integer.parseInt(actualbuildno);

            int AddPlusOneonbuild =buildnum + 1;
            return AddPlusOneonbuild;
        }
    }
}