package com.denovo.Util;

import com.denovo.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestUtil extends TestBase {

    public static void maximize() {
        driver.manage().window().maximize();
    }

    public static void implicitWait() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }



    public static void Selectcountrydropdown(String countryname)
    {
        try {
            List<WebElement> listofcountry = driver.findElements(By.xpath("//ul[@class='iti__country-list']/li"));
            for (int i = 0; i < listofcountry.size(); i++) {
                //System.out.println(listofcountry.get(i).getText());
                if (listofcountry.get(i).getText().contains(countryname)) {
                    listofcountry.get(i).click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void SelectRoleDropdown(WebElement element,String Role){
        Select select = new Select(element);
        List<WebElement> listofOption = select.getOptions();
        boolean flag= false;
        for (WebElement option : listofOption)
        {
            String list = option.getText().trim();
            if (list.equalsIgnoreCase(Role.trim()))
            {
                flag=true;
                select.selectByVisibleText(list);
            }
        }
        if(flag==false){
            System.out.println("element not found");
        }
    }
}