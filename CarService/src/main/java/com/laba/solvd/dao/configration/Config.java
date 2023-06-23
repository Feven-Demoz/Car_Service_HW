package com.laba.solvd.dao.configration;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public enum Config {
    DRIVER("driver"),
    URL("url"),
    USERNAME("username"),
    PASSWORD("password"),
    POOL_SIZE("poolSize", "5");

    private static final String CONFIG_FILE_NAME = "config.properties";
    private static final Properties PROPERTIES;

    static {
        PROPERTIES = loadProperties();
    }

    private final String key;
    private final String defaultValue;

    Config(String key, String defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
    }

    Config(String key) {
        this(key, null);
    }

    public String getValue() {
        return PROPERTIES.getProperty(key, defaultValue);
    }

    private static Properties loadProperties() {
        Properties config = new Properties();
        try (InputStream is = Config.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME)) {
            if (is != null) {
                config.load(is);
            } else {
                throw new RuntimeException("Unable to find config.properties file");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading config properties", e);
        }
        return config;
    }
}