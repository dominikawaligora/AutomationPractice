Feature: Create an account

  @negative @signup
  Scenario Outline: Create an account with invalid email
    Given User opens automationpractice.pl web page
    Given User clicks on Sign in button
    When User tries to create an account with '<username>' email
    Then Error message '<message>' should be visible

    Examples:
      | username         | message                |
      | invalidgmail.com | Invalid email address. |
      | invalid@gmail    | Invalid email address. |
      | @gmail.com       | Invalid email address. |

  @negative @signup
  Scenario Outline: Create an account with already existing email
    Given User opens automationpractice.pl web page
    Given User clicks on Sign in button
    When User tries to create an account with exiting email
    Then Error message '<message>' should be visible

    Examples:
      | message                                                                                                              |
      | An account using this email address has already been registered. Please enter a valid password or request a new one. |
