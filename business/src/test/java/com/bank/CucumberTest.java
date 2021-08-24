package com.bank;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.platform.engine.Cucumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Cucumber
@CucumberOptions(publish = true)
public class CucumberTest {

    @Test
    public void run() {
        // Without this, cucumber tests are executed but not counted by surefire
        Assertions.assertTrue(true);
    }
}
