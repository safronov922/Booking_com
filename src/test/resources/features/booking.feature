Feature: Search hotels
  Scenario: User search hotel
    Given User is on searching page
    When User click on search
    And User add "Отель Юбилейный" in search
    And click on search result
    And click Search button
    Then Hotel with name "Hotel Yubileiny" displayed on page
    Then Hotel score "Scored 8.1" displayed
