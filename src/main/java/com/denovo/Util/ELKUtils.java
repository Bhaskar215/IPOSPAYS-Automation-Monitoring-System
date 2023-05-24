package com.denovo.Util;

import com.denovo.Config.ReadPropertyFile;
import com.denovo.enums.ConfigProperties;
import io.restassured.response.Response;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;



public class ELKUtils {

    //If class method contians only Static methods so we can create private constructors
    //private constructor restrict creating a object.

    private ELKUtils(){

    }

    public static void sendResultToELK(String testname,String status) {
        boolean elk = ReadPropertyFile.getValue(ConfigProperties.SENDRESULTTOELK).equalsIgnoreCase("yes");
        if (elk) {
            Map<String, String> map = new HashMap<>();
            map.put("testName", testname);
            map.put("status", status);
            map.put("ExecutionTime", LocalDateTime.now().toString());//LocalDateTime.now().toString()
            Response response = given().headers("Content-Type", "application/json")
                    .log()
                    .all()
                    .body(map)
                    .post("http://localhost:9200/regression/result");

            response.prettyPrint();
        }
    }
}