package com.cucumber.junit.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty", "html:target/cucumber/report.html",
                "json:target/cucumber/report.json",
                "junit:target/cucumber/report.xml",
                "com.epam.reportportal.cucumber.StepReporter"
        },
        monochrome = true,
        tags = "@api1",
        glue = "com.cucumber.junit",
        features = "src/test/resources/com/cucumber/junit/features")

public class CucumberRunnerTest {
}
