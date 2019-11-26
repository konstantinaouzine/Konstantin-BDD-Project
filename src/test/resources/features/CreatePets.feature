@CreatePets
  Feature: Add Pet using various parameters
    JSON may contain proper and incorrect values
    And server should be ready to handle it

    Scenario : Success - pet adding using only required fields
      Given a pet with minimum fields
      When a user sends post request for pet adding
      Then pet successfully added

    Scenario Outline:  Success - pet adding using various fields
      Given a pet with "<field_request_name>" field
      When a user sends post request for pet adding
      Then pet with <field_response_value> successfully added
      Examples:
      |field_request_name|field_response_value|
      |name              |Bruce              |
      |status            |available          |
      |category          |1, my_cat_1        |


      Scenario Outline: Failure - pet adding when some field is incorrect
        Given a pet with <field_name> set with <field_value>
        When a user sends post request for pet adding
        Then pet adding failed with <status_code>
        And response message contains <message_data>
        Examples:
        |field_name|field_value|status_code|message_data          |
        |id        |Dasha      |500        |something bad happened|

