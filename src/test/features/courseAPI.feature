Feature: Course API functionalities

  Scenario: A topic can be retrieved
    Given client makes a / GET request
    When client calls /topics
    Then client receives the topics
    Then the client receives a response code of 200
