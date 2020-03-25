package com.yadhurany;

import com.yadhurany.ui.pages.SavingInvestmentSimulatorUIPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("unused")
public class SavingInvestmentSimulatorSuccessSteps {

    private WebDriver driver;
    private SavingInvestmentSimulatorUIPage simuladorPage;

    @Before
    public void setUp() {
        driver = ChromeFactory.getCurrentDriver();
        simuladorPage = new SavingInvestmentSimulatorUIPage(driver);
    }

    @Given("the client informed R$20,00 in the field \"Qual o valor que você quer aplicar?\"")
    public void givenWheClientInformedHowMuchToApply() {
        simuladorPage.setValorAplicar("20,00");
    }

    @And("the client informed R$20,00 in the field \"Quanto você quer poupar todo mês?\"")
    public void andTheClientInformedHowMuchToSave() {
        simuladorPage.setValorInvestir("20,00");
    }

    @And("filled the field \"Por quanto tempo você quer poupar?\"")
    public void andTheClientFilledHowMuchTimeToSave() {
        simuladorPage.setTempo("6");
    }

    @When("he or she clicks on the button \"Simular\"")
    public void whenHeOrSheClicksOnSimulate() {
        simuladorPage.clickSimularButton();
    }

    @Then("the system shows the amount of money the client will save according to the data informed")
    public void thenShowHowMuchMoneyIsSaved() {
        WebDriverWait wdw = new WebDriverWait(driver, 10);
        ExpectedCondition<Boolean> condition = wd -> {
            WebElement result = wd.findElement(By.className("btnRefazer"));
            return result.isDisplayed();
        };
        wdw.until(condition);
        assertTrue(simuladorPage.getOutrasOpcoesText().contains("Veja estas outras opções para você"));
    }

}
