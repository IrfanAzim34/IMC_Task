Feature: LMSILS-46752

  Background: LogIn
    Given User login as "DVuser05" and "DVuser05"

  Scenario: Verify Classifications Panel Features
    When User navigate to dashboard ID 927747
    And User click Search in catalogue
    And User back to Dashboard use breadcrumb navigate
    And User click classification Language skills
    And User remove Language skill filter
    And User back to Dashboard use breadcrumb navigate
    And User click on the MS Office Classification
    And User scroll down and click Show more results button
    Then User Log out
