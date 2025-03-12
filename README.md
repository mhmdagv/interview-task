# Automated Testing Framework

This project is an automated testing framework built using Cucumber, Java, TestNG, and Spring. It integrates Selenium WebDriver for browser automation and uses Extent Reports for reporting. The framework reads page elements from a JSON-based Page Object Model (POM) and utilizes dependency injection for the WebDriver.

## Features

- **Cucumber & TestNG Integration**: Uses TestNG as the test runner for Cucumber scenarios.
- **Spring Dependency Injection**: Manages driver instances and configurations using Spring.
- **JSON-based POM**: Reads element locators from JSON.
- **Selenium WebDriver**: Automates browser interactions.
- **Extent Reporting**: Captures test execution results and screenshots on failure.
- **BaseSteps & Step Definitions**: Provides reusable base methods and step definitions for better test organization.
- **Log4j Logging**: Implements Log4j for logging test execution details and debugging information.

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

You can also filter tests using specific Cucumber tags:

```sh
mvn test -Dcucumber.filter.tags="@smoke"
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

### Viewing the Test Report

Once the tests are executed, the Extent Report will be generated at:

```
target/report-output/report.html
```

To view the report, open `report.html` in a web browser.

Screenshots of failed test cases will be stored in:

```
target/report-output/screenshots/
```

### Extent Reports XML Configuration

Below is the configuration file (`extent-config.xml`) for customizing the Extent Reports:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<extentreports>
    <configuration>
        <theme>standard</theme>
        <encoding>UTF-8</encoding>
        <protocol>https</protocol>
        <documentTitle>Interview Task</documentTitle>
        <reportName>Interview Task</reportName>
        <testViewChartLocation>top</testViewChartLocation>
        <css>
            .step {
            background-color: #f7f7f9;
            padding: 10px;
            border-radius: 10px;
            margin-bottom: 5px;
            border: 1px solid #e0e0e0;
            }
        </css>
    </configuration>
</extentreports>
```

## Troubleshooting

### JSON Element Not Found

- Verify that the JSON element key exists in `jsonpom`.
- Ensure correct locator type (css, xpath, id, etc.).

