package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepdefinitions"},
        //tags = "@smoke",
        // todo: report with date
        plugin = { "pretty", "html:target/cucumber-report.html"},
        monochrome = true )

public class CucumberRunnerTest {

}
