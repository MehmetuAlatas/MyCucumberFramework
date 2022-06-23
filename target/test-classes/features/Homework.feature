@Homework
Feature: User should be able to reserve a car

  Scenario Outline: User should be able to reserve a car as customer service profile
    Given user is on the login page
    And user login dropdown
    And user sends username "<username>"
    And user sends password "<password>"
    When user clicks on login button
    And user selects a "<car>"
    And user enters pick up place "<pick_place>"
    And user enters drop off place "<drop_place>"
    And user enters pick up date "<pick_date>"
    And user enters pick up time "<pick_time>"
    And user enters drop off date "<drop_date>"
    And user enters drop off time "<drop_time>"
    Then user clicks on continue reservation
    Then verify complete reservation screen pop up
    And user enters card number "<card_number>"
    And user enters "<name>" on the card
    And user enters "<expire_date>" and "<CVC>"
    And user checks the agreement
    And user clicks complete reservation
    Then verify Reservation created successfully pop up
    And naviaged to Reservations secreen
    And verify the last reservation is created "<car>" "<pick_place>" "<drop_place>"
    When you click on the last reservation
    Then verify reservation detail page is displayed
    And verify the table has the following fields: Model, Doors, Seats, Luggage, Transmission, Air Conditioning, Fuel Type, Age
    And click click on back to reservations
    And verify Reservation page is displayed
    And click on Home link
    Then verify the homepage is displayed



#    Then close the application

    Examples:
      | username                    | password | car         | pick_place | drop_place | pick_date  | pick_time | drop_date  | drop_time | card_number      | name    | expire_date | CVC |
      | customer@bluerentalcars.com | 12345    | Honda Civic | Mersin     | Anamur     | 01/10/2094 | 01:00PM   | 02/10/2094 | 08:00AM   | 1234123412341234 | Ali Can | 1225        | 565 |