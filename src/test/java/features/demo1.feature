   
  Feature: Validate login and 3-page navigation
 
  Scenario: Successful login and navigate through Dashboard, Profile and Settings
  
    Given I open the browser
    And I navigate to "https://www.saucedemo.com/"
    When I enter username "standard_user"
    And I enter password "secret_sauce"
    And I click the login button
    Then I should see the dashboard page
    When I click the Sauce labs Backpack item to cart
    Then I remove the the same item in cart
    When I navigate to Menu page
    Then I should see the Menu details
    When I Click AllItems in Menu option
    Then I should see the dashboard page
    When I navigate to Menu page
    And I logout successfully
    
    