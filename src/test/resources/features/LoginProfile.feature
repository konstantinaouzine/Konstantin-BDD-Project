@LoginProfile
Feature: Login Profile
  As a bank customer
  I want to login my bank account using my credentials

  Background: User navigates to bank home page
    Given I am on the login page
    Then I should see login fields

  Scenario: Successful login
    Given I stay on login page
    When I fill in "Username" with "mngr233239"
    And I fill in "Password" with "dUhAnAd"
    And I click on the LogIn button
    Then I am on the MyProfile page on URL "http://demo.guru99.com/V1/html/Managerhomepage.php"
    And I should see the LogOut button

  Scenario Outline: Failed login using wrong credentials
    Given I stay on login page
    When I fill in "Username" with "<username>"
    And I fill in "Password" with "<password>"
    And I click on the LogIn button
    Then I should get Error screen
    Examples:
      | username          | password  |
      | mngr233239        | Incorrect |
      | Incorrect         | dUhAnAd   |


