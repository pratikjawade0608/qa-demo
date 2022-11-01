package runners;

import dataProviders.ConfigProperties;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import reusable.TestBase;
import reusable.UIHelpers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@CucumberOptions(
        features = {"src/test/resources/features/Functional"},
        tags = "@DemoFeature",
        glue = {"stepdefinitions/functional"},
        plugin = {"pretty", "html:target/cucumber-reports/functional-report.html", "json:target/cucumber-reports/functional-report.json"},
        monochrome = true, dryRun = false)

public class FunctionalRunner extends BaseRunner {
    TestBase testBase;

    @BeforeMethod
    public void setUpBrowser() throws Exception {
        testBase = new TestBase();
        testBase.init(ConfigProperties.getConfigProperties().getString("browser"), "DemoURL");
    }

    @AfterMethod
    public void endTest(ITestResult result) {
        // When the test case is pass getting the screenshot
        UIHelpers.takeScreenShot(result.getName());
        // When the test case is failed getting the screenshot
        UIHelpers.takeScreenShotForFailedCase(result);
        UIHelpers.quitBrowser();
    }

    @Override
    String getRunnerName() {
        return "functional";
    }
}