package com.xdht.disease.common.util;

/**
 * Created by lzf on 2017/11/7.
 */
public class PropertiesUtil {

    public PropertiesUtil() {
    }

    public static String getPropertyValueByKey(String propertyName, String key) {
        String returnValue = "";

        try {
            Properties properties = PropertiesFactory.getInstance().createProperties(propertyName);
            returnValue = properties.getValue(key);
        } catch (Exception var4) {
            ;
        }

        return returnValue;
    }

}
