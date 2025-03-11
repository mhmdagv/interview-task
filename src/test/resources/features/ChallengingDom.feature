@challenging-pom
Feature: Challenging dom

  Scenario Outline: Verify that the <buttonName> button is clickable
    Given Navigate to "https://practice.expandtesting.com/challenging-dom"
    When Click on the "<buttonName>" element
    Then Verify that element "<buttonName>" is enabled
    Examples:
      | buttonName |
      | successBtn |
      | warningBtn |
      | primaryBtn |

  Scenario Outline: Retrieve and log data from the <columnName> column
    Given Navigate to "https://practice.expandtesting.com/challenging-dom"
    When Log the table "<columnName>" column
    Examples:
      | columnName  |
      | loremColumn |
      | ipsumColumn |
      | dolorColumn |

