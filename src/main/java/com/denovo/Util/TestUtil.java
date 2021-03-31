package com.denovo.Util;

import com.denovo.Base.TestBase;

import java.util.concurrent.TimeUnit;

public class TestUtil extends TestBase {

    public static void maximize() {
        driver.manage().window().maximize();
    }

    public static void implicitWait() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

}
