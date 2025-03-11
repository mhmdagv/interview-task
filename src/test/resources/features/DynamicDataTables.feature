@dynamic-data-table
Feature: Dynamic Data Table

  Scenario Outline: Verify that the <column> column in the first table is sorted correctly
    Given Navigate to "https://practice.expandtesting.com/tables"
     When Click on the "<header>" element
     Then Column "<column>" should be sorted correctly
     Examples:
       | column          | header          |
       | lastNameColumn  | lastNameHeader  |
       | firstNameColumn | firstNameHeader |
       | emailColumn     | emailHeader     |
       | websiteColumn   | websiteHeader   |

  Scenario: Verify that the Due column in the first table is sorted correctly
    Given Navigate to "https://practice.expandtesting.com/tables"
    When Click on the "dueHeader" element
    Then "dueColumn" should be sorted correctly

  Scenario: Verify that clicking the Delete button updates the URL
    Given Navigate to "https://practice.expandtesting.com/tables"
    When Click on the "deleteBtn" element
    Then Verify that the current URL contains the value "#delete"

  Scenario: Verify that clicking the Edit button updates the URL
    Given Navigate to "https://practice.expandtesting.com/tables"
    When Click on the "editBtn" element
    Then Verify that the current URL contains the value "#edit"

