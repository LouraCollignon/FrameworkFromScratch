Feature: Belastingdienst home page scenarios

  //should these cucumber scenarios follow the page object model?
  Scenario: Navigate to the next page
    Given I am on the Belastingdienst home page
    When I click on the auto button on the main section
    Then I should see the following header: