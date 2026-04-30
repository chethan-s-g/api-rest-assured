package com.api.testing.utilities;

import com.api.testing.logger.LoggerUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

public class ConfigLoader {

    public static Properties loadConfig(String env) {
        if (env == null || env.isBlank()) {
            env = "dev";
        }
        env = env.toLowerCase(Locale.ENGLISH).trim();
        String fileName = String.format("config/%s.properties", env);
        Properties properties = new Properties();

        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName)) {
            if (inputStream == null) {
                throw new IllegalStateException("Environment properties file not found: " + fileName);
            }
            properties.load(inputStream);
            properties.setProperty("current.env", env);
            LoggerUtil.info("Loaded configuration from " + fileName);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file: " + fileName, e);
        }
        return properties;
    }
}
