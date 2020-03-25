@Smoke
Feature: Saving Investment Simulator

  Scenario: Client fills in the field values with less than R$20,00 for simulating a saving investment
    Given the client filled in the field "Qual o valor que você quer aplicar?" with less than R$20,00
    When he or she tries to fill in another field
    Then the system shows the message "Valor mínimo de 20.00"