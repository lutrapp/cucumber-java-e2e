package stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/Features",
        glue ={"stepDefinitions"},
        monochrome = true,
        plugin = {"pretty",
                "html:target/cucumber/report.html",
                "json:target/cucumber/report.json"}
//        tags = "@smoketest" // to run specific scenarios with this annotation on Features
)
public class TestRunner {
}
