package com.yadhurany;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/SavingInvestmentSimulatorValueLess20Test.feature", plugin = { "pretty" })
public class SavingInvestmentSimulatorValueLess20Test { }
