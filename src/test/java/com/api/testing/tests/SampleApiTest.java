package com.api.testing.tests;

import com.api.testing.base.BaseTest;
import com.api.testing.body.PayloadBuilder;
import com.api.testing.request.ApiRequestManager;
import com.api.testing.testdata.TestDataProvider;
import com.api.testing.validation.ResponseValidator;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class SampleApiTest extends BaseTest {

    @Test(dataProvider = "userData", dataProviderClass = TestDataProvider.class)
    @Description("Create a new user and verify the response status is 201")
    public void createNewUser_shouldReturnCreatedStatus(String name, String email) {
        String endpoint = config.getProperty("create.user.endpoint");
        String payload = PayloadBuilder.createUser(name, email);

        ApiRequestManager apiRequestManager = new ApiRequestManager(requestSpecification);
        var response = apiRequestManager.post(endpoint, payload);

        ResponseValidator.assertStatusCode(response, 201);
    }
}
