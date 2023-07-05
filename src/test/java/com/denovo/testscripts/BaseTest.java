package com.denovo.testscripts;


import com.denovo.Driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

public class BaseTest {
    protected BaseTest(){

    }

    @SuppressWarnings("unchecked")
    @BeforeMethod
    protected void setUp(Object[]data) throws Exception {
       Map<String,String>map=(Map<String,String>)data[0];
        Driver.initDriver(map.get("Browser"),map.get("TestName"));
    }

    @AfterMethod
    protected void teardown(){
        Driver.quitDriver();
    }

}