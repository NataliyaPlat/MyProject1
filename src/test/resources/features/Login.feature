Feature: Login features

  Background:
    Given I open login page

  Scenario: Login Success
    Given I add "europlatinum@mail.ru" email to the emial field
    And I add "Newjob2020!!" password to the password field
    And I clcik login button
    Then I see login successfull message

  Scenario: Login Empty Email
    Given I add "" email to the emial field
    And I add "Newjob2020!!" password to the password field
    And I clcik login button
    Then I see login successfull message

  Scenario: Login Empty Password
    Given I add "europlatinum@mail.ru" email to the emial field
    And I add "" password to the password field
    And I clcik login button
    Then I see login successfull message
