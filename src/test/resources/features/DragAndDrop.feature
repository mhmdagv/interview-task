@drag-and-drop
Feature: Drag and Drop

  Scenario: Verify that Box A can be dragged and dropped onto Box B
    Given Navigate to "https://practice.expandtesting.com/drag-and-drop"
    When Drag the "boxA" element and drop it onto "boxB"
    And Wait for 1 second
    Then Verify that element "boxB" have text "A"

  Scenario: Verify that Box B can be dragged and dropped onto Box A
    Given Navigate to "https://practice.expandtesting.com/drag-and-drop"
    When Drag the "boxB" element and drop it onto "boxA"
    And Wait for 1 second
    Then Verify that element "boxA" have text "B"

  Scenario: Verify that Box A can be dragged to Box B and then moved back
    Given Navigate to "https://practice.expandtesting.com/drag-and-drop"
    When Drag the "boxA" element and drop it onto "boxB"
    And Wait for 1 second
    When Drag the "boxB" element and drop it onto "boxA"
    And Wait for 1 second
    Then Verify that element "boxA" have text "A"