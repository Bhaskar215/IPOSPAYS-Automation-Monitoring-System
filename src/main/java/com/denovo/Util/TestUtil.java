package com.denovo.Util;

import com.denovo.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestUtil extends TestBase {

    public static void maximize() {
        driver.manage().window().maximize();
    }

    public static void implicitWait() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }



    public void dropdown() throws InterruptedException {
        //WebElement dropdowncountry = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/div/div/form/div[2]/div[1]/div/ngx-intl-tel-input/div/div/div"));

     /*   WebElement dropdowncountry = driver.findElement(By.xpath("//div[@class='iti__selected-flag dropdown-toggle']"));
        dropdowncountry.click();*/

        List<WebElement> listofcountry=driver.findElements(By.xpath("//ul[@class='iti__country-list']/li"));


        for(int i=0; i<listofcountry.size(); i++) {
            System.out.println(listofcountry.get(i).getText());
            if(listofcountry.get(i).getText().contains("India (भारत)")) {
                listofcountry.get(i).click();
                break;
            }
        }
    }

}
