package com.automation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.automation.steps",
        plugin = {"json:target/cucumber.json","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class TestRunner {
}
