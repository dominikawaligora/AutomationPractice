## Overview
This test project aims to automate the testing of a web application using Java as the programming language with maven support, Playwright as the browser automation tool, Cucumber for behavior-driven development (BDD), JUnit for test execution, and the Page Object pattern for better code organization and maintainability. The application under test is http://www.automationpractice.pl/

## Test Scenarios
For login and signup functionality, automated tests will verify user authentication and registration processes. Using Playwright, Java, and the Page Object pattern, tests will cover scenarios like valid and invalid credentials, error handling, and secure password storage, ensuring a seamless user experience.

## Project's Structure
> rc/main/java/pages

Folder containing Page Object classes 

> src/main/java/utils

Folder with auxiliary classes

> src/test/java/features

Folder with Cucumber scenario feature files

> src/test/java/stepdefinitions

Folder containing definitions of steps used in Cucumber feature files

> src/test/java/testrunner

Test runner class

## Browsers support
Playwritght is supporting multi-browsers but on behalf of this project I decided to target Chrome specifically.

## Running tests
To run the tests you can use the `mvn test` command

## Test reports
To generate test reports in HTML format, Cucumber's HTML reporting plugin was integrated into the test framework. The plugin can be configured in the Cucumber options (`CucumberRunnerTest.java` class), specifying the output directory as "target" and the desired file name. After test execution, Cucumber generates an HTML report containing detailed test results, accessible at the specified location.
