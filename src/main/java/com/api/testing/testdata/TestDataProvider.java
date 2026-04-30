package com.api.testing.testdata;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "userData")
    public static Object[][] userData() {
        return new Object[][]{
                {"Aida", "aida+dev@example.com"},
                {"StagingUser", "stage.user@example.com"},
                {"ProdUser", "prod.user@example.com"}
        };
    }
}
