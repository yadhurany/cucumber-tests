@Smoke
Feature: Saving Investment Simulator

  Scenario: Clean the saving investment simulator’s form data
    Given the client has filled one or more fields of the form
    When he or she clicks on the button "Limpar formulário"
    Then the system cleans the data that was filled in