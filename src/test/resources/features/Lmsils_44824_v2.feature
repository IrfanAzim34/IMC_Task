Feature: LMSILS-44824-V2

  Background: LogIn
    Given User login as "QAAutomation1!" and "QAAutomation1!"

  Scenario:
    When User navigate to Client Manager
    And User find "Clients" to edit it
    And User verify Warning of time conflicts is unchecked
    And User login as "warninguser1" and "warninguser1"
    And User search "#warntiming" in catalogue page
    Then User verify "TD #Course #WarnTiming #LongAvailability" enrolment button

  @wip
  Scenario:
    When User navigate to Client Manager
    And User find "Clients" to edit it
    And User activate Warning of time conflicts checkbox
    And User login as "warninguser1" and "warninguser1"
    And User search "#warntiming" in catalogue page
    And User enrol "TD #Course #WarnTiming #LongAvailability" course