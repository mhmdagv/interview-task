# Automated Testing Framework

This project is an automated testing framework built using Cucumber, Java, TestNG, and Spring. It integrates Selenium WebDriver for browser automation and uses Allure for reporting. The framework reads page elements from a JSON-based Page Object Model (POM) and utilizes dependency injection for the WebDriver.

## Features

- **Cucumber & TestNG Integration**: Uses TestNG as the test runner for Cucumber scenarios.
- **Spring Dependency Injection**: Manages driver instances and configurations using Spring.
- **JSON-based POM**: Reads element locators from JSON.
- **Selenium WebDriver**: Automates browser interactions.
- **Allure Reporting**: Captures test execution results and screenshots on failure.
- **BaseSteps & Step Definitions**: Provides reusable base methods and step definitions for better test organization.

## Project Structure

```
├── src/main/java
│   ├── config          # Configuration classes (Spring, WebDriver, Hooks)
│   ├── model           # Element model and mapping
│   ├── stepdefinition  # Step definitions and base methods
│   ├── utility         # JSON reading utilities
│
├── src/test/resources
│   ├── features        # Cucumber feature files
│   ├── jsonpom         # JSON files defining element locators
│
├── pom.xml             # Project dependencies and build configuration
├── README.md           # Documentation
```

## Installation

### Prerequisites

Ensure you have the following installed:

- Java 17 or later
- Maven
- Chrome Browser
- ChromeDriver (Ensure compatibility with Chrome version)

### Setup

1. Clone the repository:
   ```sh
   git clone <repository-url>
   cd <repository-folder>
   ```
2. Install dependencies:
   ```sh
   mvn clean install
   ```

## Running Tests

### Using Maven

Run tests with TestNG and Cucumber:

```sh
mvn test
```

### Generating Allure Report

1. Execute tests:
   ```sh
   mvn test
   ```
2. Generate the Allure report:
   ```sh
   mvn allure:serve
   ```

## Writing Tests

### Adding New Steps

- Reuse existing methods from `BaseSteps`.
- If a new step is required, create a new step definition class.

### Creating Feature Files

Define your scenarios in `.feature` files inside `src/test/resources/features`:

```gherkin
Feature: Login Functionality

  Scenario: User logs in successfully
    Given Navigate to "https://example.com/login"
    When Fill the "username" field with "testuser"
    And Fill the "password" field with "password123"
    And Click on the "login-button" element
    Then Verify "Welcome" message is displayed
```

## Troubleshooting

### JSON Element Not Found

- Verify that the JSON element key exists in `jsonpom`.
- Ensure correct locator type (css, xpath, id, etc.).

