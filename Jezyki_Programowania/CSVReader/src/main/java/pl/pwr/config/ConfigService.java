package pl.pwr.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by SQUIER on 2015-11-19.
 */
public class ConfigService {

    private Properties properties;

    public ConfigService(String url) {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ConfigService(Properties properties) {
        setProperties(properties);
    }

    public String getProperty(String key) {
        if (properties.getProperty(key) != null) return properties.getProperty(key);
        else throw new IllegalArgumentException("Key " + "\"" + key + "\" not found!");
    }

    private void setProperties(Properties properties) {
        this.properties = properties;
    }
}
