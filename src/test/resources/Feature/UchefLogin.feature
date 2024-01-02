Feature: feature to test login functionality of Uchef

  Scenario Outline: Check login is successful with valid credentials
    Given user opens the browser
    And enter the URL
    Given user is on home page
    Then Click on login button
    When user enters <username> and <password>
    And clicks on Sign in button
    Then user is navigated to the home page
    And user click on Profile button
    Then Click on setting icon
    When CLick on Log out button
    Then user navigate to the home page

    Examples: 
      | username          | password |
      | laxmi@yopmail.com | Test@123 |
      #| chakraveers@gmail.com | Password@123 |