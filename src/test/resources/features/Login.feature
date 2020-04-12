# feature file where Cucumber tests/scenarios are written in Gherkin language
  # Using  Cucumber tables for Data-Driven testing.
Feature: Login features

  @Smoke @StageOnly
  Scenario Outline: Login Empty Email
    Given I open login page
    When I add <email> email to the emial field
    And I add <password> password to the password field
    And I clcik login button
    Then I see login successfull message

    Examples:
      |email                  | password        |
      |""                     | "Newjob2020!!"       |


  @Regression
  Scenario: Login Empty Password
    Given I open login page
    When I add "europlatinum@mail.ru" email to the emial field
    And I add "" password to the password field
    And I clcik login button
    Then I see login successfull message


  @Regression
  Scenario: Login Empty Email
    Given I open login page
    When I add "europlatinum@mail.ru" email to the emial field
    And I add "" password to the password field
    And I clcik login button
    Then I see login successfull message
