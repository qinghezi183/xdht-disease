package com.xdht.disease.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lzf on 2017/11/7.
 */
public class PropertiesFactory {
    private Map<String, Properties> propMap;

    private PropertiesFactory() {
        this.propMap = new HashMap();
    }

    public static PropertiesFactory getInstance() {
        return PropertiesFactory.SingletonHolder.INSTANCE;
    }

    public Properties createProperties(String fileName) throws Exception {
        Properties config = (Properties)this.propMap.get(fileName);
        if(config == null) {
            config = new Properties(fileName);
            this.propMap.put(fileName, config);
        }

        return config;
    }

    private static class SingletonHolder {
        public static final PropertiesFactory INSTANCE = new PropertiesFactory();

        private SingletonHolder() {
        }
    }
}
