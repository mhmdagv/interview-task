@file-upload
Feature: File Upload

  Scenario: Verify uploading a file smaller than 500KB
    Given Navigate to "https://practice.expandtesting.com/upload"
    When Upload a file to the "uploadInput" element from the specified "/uploadablefiles/a.docx" path
    And Click on the "fileSubmitBtn" element
    Then Verify that element "pageHeader" have text "File Uploaded!"


  Scenario: Verify uploading a file larger than 500KB
    Given Navigate to "https://practice.expandtesting.com/upload"
    When Upload a file to the "uploadInput" element from the specified "/uploadablefiles/b.txt" path
    And Wait for 1 second
    Then Verify that element "alertText" have text "File too large, please select a file less than 500KB"

