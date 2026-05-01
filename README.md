# api-rest-assured

This repository contains a Maven-based API automation project using TestNG, Rest Assured, and Allure reporting.

## Project structure

- `src/main/java/com/api/testing/base` - base setup and request specification
- `src/main/java/com/api/testing/request` - API request manager classes
- `src/main/java/com/api/testing/body` - request payload builders
- `src/main/java/com/api/testing/utilities` - configuration and environment helpers
- `src/main/java/com/api/testing/validation` - response validation helpers
- `src/main/java/com/api/testing/logger` - logging utilities
- `src/main/java/com/api/testing/testdata` - test data providers
- `src/test/java/com/api/testing/tests` - TestNG test cases
- `src/test/resources/config` - environment-specific `dev`, `stage`, and `prod` properties
- `.github/workflows/maven.yml` - GitHub Actions workflow for CI

## How to run

1. Install Maven 3.8+ and JDK 17.
2. Run tests locally:
   ```bash
   mvn clean test -Denv=dev
   ```
3. Generate an Allure report:
   ```bash
   mvn allure:report
   ```

## Environment support

This project loads environment-specific values from `src/test/resources/config/{dev,stage,prod}.properties`.
Use `-Denv=dev`, `-Denv=stage`, or `-Denv=prod` to execute against each configuration.

## View Report 
https://chethan-s-g.github.io/api-rest-assured/

## GitHub Actions

The workflow in `.github/workflows/maven.yml` runs the test suite for `dev`, `stage`, and `prod` environments and uploads generated Allure reports as artifacts.
