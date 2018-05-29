package com.xdht.disease.common.util;

/**
 * Created by lzf on 2017/11/7.
 */
public class Properties {

    private java.util.Properties config = new java.util.Properties();

    Properties(String fileName) throws Exception {
        this.config.load(Properties.class.getClassLoader().getResourceAsStream(fileName));
    }

    public String getValue(String key) {
        String value = null;
        if(this.config != null) {
            value = this.config.getProperty(key);
            if(value != null) {
                value = value.trim();
            }
        }

        return value;
    }
}
