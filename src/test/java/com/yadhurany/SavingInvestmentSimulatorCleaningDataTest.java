package com.yadhurany;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/SavingInvestmentSimulatorCleaningDataTest.feature", plugin = { "pretty" })
public class SavingInvestmentSimulatorCleaningDataTest { }
