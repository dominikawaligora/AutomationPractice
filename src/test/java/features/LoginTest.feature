Feature: Login

  @positive @smoke @login
  Scenario Outline: Login to automationpractice.pl
    Given User opens automationpractice.pl web page
    Given User clicks on Sign in button
    When User signs in with valid credentials
    Then Sign out button is visible
    Then User name '<username>' is displayed properly
    Then User signs out

    Examples:
      | username   |
      | Dominika W |

  @negative @login
  Scenario Outline: Login to automationpractice.pl with wrong credentials
    Given User opens automationpractice.pl web page
    Given User clicks on Sign in button
    When User tries to login with '<username>' username and '<password>' password
    Then Error message '<message>' should be visible

    Examples:
      | username      | password     | message                    |
      | fake@fake.com | fakepassword | Authentication failed.     |
      | fake@fake.com | fakepassword | Authentication failed.     |
      |               | fakepassword | An email address required. |
      | fake@fake.com |              | Password is required.      |
      | fakefake.com  | fakepassword | Invalid email address.     |

  @negative @login
  Scenario Outline: Login to automationpractice.pl with valid username and invalid password
    Given User opens automationpractice.pl web page
    Given User clicks on Sign in button
    When User tries to login with valid username and '<password>' password
    Then Error message '<message>' should be visible

    Examples:
      | password     | message                |
      | fakepassword | Authentication failed. |
      |              | Password is required.  |

