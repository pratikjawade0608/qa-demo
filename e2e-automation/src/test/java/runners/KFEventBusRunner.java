package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@CucumberOptions(features = {"src/test/resources/features/KFEventBus"},
        tags = "@KFEventBusDemoFeature",
        glue = {"stepdefinitions/kfeventbus"},
        plugin = {"pretty", "html:target/cucumber-reports/kfeventbus_report.html","json:target/cucumber-reports/kfeventbus_report.json"},
        monochrome = true,
        dryRun = false)

public class KFEventBusRunner extends BaseRunner {
    @Override
    String getRunnerName() {
        return "kfeventbus";
    }
}