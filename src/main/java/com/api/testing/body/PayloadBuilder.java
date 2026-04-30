package com.api.testing.body;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class PayloadBuilder {

    private static final Gson GSON = new Gson();

    public static String createUser(String name, String email) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("name", name);
        payload.put("email", email);
        payload.put("job", "QA Engineer");
        return GSON.toJson(payload);
    }
}
