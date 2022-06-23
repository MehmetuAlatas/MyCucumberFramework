package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        //

        plugin = {
                "pretty",
                "html:target/default_cucumber_report.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failedRerun.txt",
        },
        features = "./src/test/resources/features",//path od features folder
        glue = {"stepdefinitions", "hooks"},//path of the step definitions folder
        tags = "@customer_login",
        dryRun = false
)
public class TestRunner {
}
