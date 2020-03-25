package com.yadhurany;

import com.yadhurany.ui.pages.SavingInvestmentSimulatorUIPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class SavingInvestmentSimulatorCleaningDataSteps {

    private WebDriver driver;
    private SavingInvestmentSimulatorUIPage simuladorPage;

    @Before
    public void setUp() {
        driver = ChromeFactory.getCurrentDriver();
        simuladorPage = new SavingInvestmentSimulatorUIPage(driver);
    }

    @Given("the client has filled one or more fields of the form")
    public void givenTheClientInformedOneOrMoreFields() {
        simuladorPage.setValorAplicar("127,00");
    }

    @When("he or she clicks on the button \"Limpar formulário\"")
    public void whenHeOrSheClicksOnCleanForm() {
        simuladorPage.clickLimparButton();
    }

    @Then("the system cleans the data that was filled in")
    public void thenTheSystemCleansTheData() {
        assertEquals("", simuladorPage.getValorAplicarText());
    }

}
