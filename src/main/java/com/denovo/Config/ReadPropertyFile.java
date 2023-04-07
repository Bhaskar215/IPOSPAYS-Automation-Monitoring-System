package com.denovo.Config;

import com.denovo.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public final class ReadPropertyFile {

    private ReadPropertyFile() {
    }

    public static Properties pro = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();


    static {
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Config/config.properties");
            pro.load(fis);

           /*
           * Approach 1
           for (Object key : pro.keySet()) {
                CONFIGMAP.put(String.valueOf(key), String.valueOf(pro.get(key)));
            }
            */

            //Approach 2
            for (Map.Entry<Object, Object> entry : pro.entrySet()) {
                CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Hashmap is Faster compare to Hashtable
    //HashMap Method
    public static String getValue(ConfigProperties key) throws Exception {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
            throw new Exception("Property Name " + key + " is not Found.Please Check Config.Properties");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }

    //Normal Method
    /*
    *
    public static String getValue(String key) throws Exception {
        if(Objects.isNull(pro.getProperty(key)) || Objects.isNull(key)){
            throw new Exception("Property Name " + key + " is not Found.Please Check Config.Properties" );
        }
        return pro.getProperty(key);
    }
    *
    */

}