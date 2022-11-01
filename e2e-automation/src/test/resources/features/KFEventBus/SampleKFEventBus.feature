@PFD-545
Feature: Test KF Event Bus communication

  Scenario: Validate QA module can receive and send messages to KF Event Bus
    Given A connection is stablished with KF Event Bus
    When User sends a message to KF event bus
    Then The message is processed successfully by KF event bus
    And User waits for 5 seconds
    And User can retrieve the message from KF Event bus


