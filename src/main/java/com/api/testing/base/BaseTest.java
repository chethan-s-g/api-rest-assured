package com.api.testing.base;

import com.api.testing.logger.LoggerUtil;
import com.api.testing.utilities.ConfigLoader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Properties;

public abstract class BaseTest {

    protected Properties config;
    protected RequestSpecification requestSpecification;

    @BeforeClass(alwaysRun = true)
    @Parameters({"env"})
    public void setUp(@Optional("dev") String env) {
        LoggerUtil.info("Initializing test base for environment: " + env);
        config = ConfigLoader.loadConfig(env);
        String baseUri = config.getProperty("base.uri");
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setContentType("application/json")
                .build();
    }
}
