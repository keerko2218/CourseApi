package springbootcucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/courseAPI.feature", plugin = {"pretty", "html:target/cucumber"})
public class TopicCucumberIntegrationTest {
}