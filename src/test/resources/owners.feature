Feature: Owners


  Scenario: Navigate to Add Owner
    Given I am on the owners search page
    When I follow "Add Owner"
    When I fill in the following:
      | First name | Dan         |
      | Last name  | Wood        |
      | Address    | 123 Main St |
      | City       | Anywhere    |
      | Telephone  | 5555555     |
    And I press "Add Owner"    
    And I should see "Dan Wood"

 