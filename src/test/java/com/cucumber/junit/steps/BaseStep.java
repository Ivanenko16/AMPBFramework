package com.cucumber.junit.steps;

import com.cucumber.junit.ScenarioContext;
import com.cucumber.junit.TestContext;

public class BaseStep {

    private final ScenarioContext scenarioContext;

    public BaseStep(TestContext testContext) {
        scenarioContext = testContext.getScenarioContext();
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
