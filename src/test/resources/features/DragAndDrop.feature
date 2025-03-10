Feature: Drag and Drop

  Scenario: Validate dragging a box to b
    Given Navigate to "https://practice.expandtesting.com/drag-and-drop"
    When Drag the "boxA" element and drop it onto "boxB"
    And Wait for 1 seconds
    Then Verify that element "boxB" have text "A"

#  Scenario: Validate dragging b box to a
#    Given Navigate to "https://practice.expandtesting.com/drag-and-drop"
#    When Drag the "boxB" element and drop it onto "boxA"
#    And Wait for 1 seconds
#    Then Verify that element "boxA" have text "B"
#
#  Scenario: Validate dragging a box to b then return
#    Given Navigate to "https://practice.expandtesting.com/drag-and-drop"
#    When Drag the "boxA" element and drop it onto "boxB"
#    And Wait for 1 seconds
#    When Drag the "boxB" element and drop it onto "boxA"
#    And Wait for 1 seconds
#    Then Verify that element "boxA" have text "A"