#Feature: File Upload
#
#  Scenario: Upload file that smaller than 500kb
#    Given Navigate to "https://practice.expandtesting.com/upload"
#    When Upload a file to the "uploadInput" element from the specified "/uploadablefiles/a.docx" path
#    And Click on the "fileSubmitBtn" element
#    Then success message appear
#
#
#
#  Scenario: Upload file that bigger than 500kb
#    Given Navigate to "https://practice.expandtesting.com/upload"
#    When Upload a file to the "uploadInput" element from the specified "/uploadablefiles/a.docx" path
#    And Click on the "fileSubmitBtn" element
#    Then error message appear
#
