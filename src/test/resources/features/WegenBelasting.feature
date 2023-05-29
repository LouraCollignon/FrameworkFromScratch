Feature: Belastingdienst Wegenbelasting calculation

  Scenario: Navigate to the calculate Wegenbelasting page from the Home page
    Given That I am on the Wegenbelasting Home page
    When I surf to the Wegenbelasting calculation page
    Then I should see the header: "Motorrijtuigenbelasting berekenen"

  Scenario Outline: Calculate Wegenbelasting for multiple iterations
    Given I am on the Wegenbelasting calculation page and see "Motorrijtuigenbelasting berekenen"
    When I select if I live in the Netherlands "<liveInNL>"
    And I select the "<vehicleType>" that I own
    And I select whether my car drives on "<cleanEnergy>"
    And I select what "<province>" I live in
    And I select what "<fuelType>" my car has
    And I select what "<weightClass>" my car belongs into
    And I click the calculate button
    Then I should be seeing the amount of taxes I need to pay for the car options I put in.

    Examples:
      |liveInNL  |vehicleType| cleanEnergy|province| fuelType|weightClass|
      |true |Personenauto|true|             |       |           |
      |false  |Personenauto|false |Noord-Brabant|Benzine|3351 t/m 3450|
      |true |Motor       |false |Drenthe      |       |           |