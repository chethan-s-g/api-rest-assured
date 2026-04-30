package com.api.testing.utilities;

public enum Environment {
    DEV("dev"),
    STAGE("stage"),
    PROD("prod");

    private final String key;

    Environment(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static Environment from(String env) {
        if (env == null || env.isBlank()) {
            return DEV;
        }
        return switch (env.trim().toLowerCase()) {
            case "stage" -> STAGE;
            case "prod", "production" -> PROD;
            default -> DEV;
        };
    }
}
