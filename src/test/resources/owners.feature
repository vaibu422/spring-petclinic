Feature: Owners


  Scenario: Navigate to Add Owner
    Given I am on the owners search page
    When I follow "Add Owner"
    Then I should see "New Owner" within "h2"

 