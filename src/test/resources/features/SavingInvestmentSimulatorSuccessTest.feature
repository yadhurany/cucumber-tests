@Smoke
Feature: Saving Investment Simulator

  Scenario: Simulate a saving investment with success
    Given the client informed R$20,00 in the field "Qual o valor que você quer aplicar?"
    And the client informed R$20,00 in the field "Quanto você quer poupar todo mês?"
    And filled the field "Por quanto tempo você quer poupar?"
    When he or she clicks on the button "Simular"
    Then the system shows the amount of money the client will save according to the data informed