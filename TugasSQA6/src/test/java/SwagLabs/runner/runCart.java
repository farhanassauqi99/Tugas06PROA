package SwagLabs.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/SwagLabs/features",
        glue = "SwagLabs.stepDef",
//        plugin = {"html:target/HTML_report.html"},
        plugin = {"pretty", "json:target/cucumber-reports/reports.json",
                "json:target/cucumber-reports/cucumber.runtime.formatter.JSONFormatter"},
        tags = "@Cart"
)
public class runCart {
}
