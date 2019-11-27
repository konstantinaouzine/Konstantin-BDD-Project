@CreatePets
Feature: Add Pet using various parameters
  JSON may contain proper and incorrect values
  and server should be ready to process it

  Background: Protocol configuration applied
    Given URL and headers setup performed
    Then be happy

  Scenario: Success - pet adding using only required fields
    Given a pet with id 1001
    When a user sends post request for pet adding
    Then operation completed with status code 200
    And pet successfully added


  Scenario Outline:  Success - pet adding using various fields
    Given a pet with "<field_name>" set with "<field_value>"
    When a user sends post request for pet adding
    Then operation completed with status code 200
    And pet successfully added
    Examples:
    |field_name        |field_value        |
    |name              |Bruce              |
    |status            |available          |
    |category          |1, my_cat_1        |

  @Ignore
  Scenario Outline: Failure - pet adding when some field is incorrect
    Given a pet with "<field_name>" set with "<field_value>"
    When a user sends post request for pet adding
    Then operation completed with status code <status_code>
    And response message contains "<message_data>"
    Examples:
    |field_name|field_value|status_code|message_data          |
    |id        |Dasha      |500        |something bad happened|

