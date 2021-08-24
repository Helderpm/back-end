Feature: Client and Bank

  Scenario: multiplying a number by 0 should result to 0
    Given the number '141'
    When the number is multiplied by '0'
    Then the result should be '0'

  Scenario: a client should be able to read his accounts
    Given I am a client with '100.0' on my account 'TEST_002'
    When I check my account 'TEST_002'
    Then my balance should be '100.0'

  Scenario: a client should be able to make a deposit on his accounts
    Given I am a client with '100.0' on my account 'TEST_002'
    When I deposit '10' on my account 'TEST_002'
    Then my balance should be '110.0'

  Scenario: a client should be able to make a withdraw from his accounts
    Given I am a client with '100.0' on my account 'TEST_002'
    When I withdraw '10' from my account 'TEST_002'
    Then my balance should be '90.0'
