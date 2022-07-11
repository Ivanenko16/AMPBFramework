package com.cucumber.junit.steps;

import com.cucumber.junit.ScenarioContext;
import com.cucumber.junit.TestContext;

import java.util.HashSet;
import java.util.List;

public class BaseStep {

    private final ScenarioContext scenarioContext;

    public BaseStep(TestContext testContext) {
        scenarioContext = testContext.getScenarioContext();
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }

    public static <T> boolean listEqualsIgnoreOrder(List<T> list1, List<T> list2) {
        return new HashSet<>(list1).equals(new HashSet<>(list2));
    }
}


