package com.denovo.Pages;

import com.denovo.enums.WaitStrategy;
import org.openqa.selenium.By;

public class EditParameter extends BasePage {

    private final By clickSteamBtn =By.xpath("//*[contains(text(),'S.T.E.A.M')]/parent::a");

    private final By clickEditParameterBtn =By.xpath("//*[contains(text(),' Edit Parameters ')]//parent::a");


    private final By parameterPageIsLoaded =By.xpath("//*[@class='ps ng-star-inserted ps--active-y']");


    public void clickSteam(){
        click(clickSteamBtn, WaitStrategy.CLICKABLE);
    }
    public void clickEditParameter(){
        click(clickEditParameterBtn, WaitStrategy.CLICKABLE);
    }


}