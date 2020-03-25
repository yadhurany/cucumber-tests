package com.yadhurany;

import com.yadhurany.ui.pages.SavingInvestmentSimulatorUIPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class SavingInvestmentSimulatorValueLess20Steps {

    private WebDriver driver;
    private SavingInvestmentSimulatorUIPage simuladorPage;

    @Before
    public void setUp() {
        driver = ChromeFactory.getCurrentDriver();
        simuladorPage = new SavingInvestmentSimulatorUIPage(driver);
    }

    @Given("the client filled in the field \"Qual o valor que você quer aplicar?\" with less than R$20,00")
    public void givenWheClientInformedHowMuchToApply() {
        simuladorPage.setValorAplicar("16,00");
    }

    @When("he or she tries to fill in another field")
    public void whenHeOrSheClicksOnSimulate() {
        simuladorPage.clickValorInvestirField();
    }

    @Then("the system shows the message \"Valor mínimo de 20.00\"")
    public void thenShowHowMuchMoneyIsSaved() {
        assertEquals("Valor mínimo de 20.00", simuladorPage.getValorAplicarErrorText());
    }

}
