package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/Features/Home.feature", 
glue = "com.bellatrix.stepDefination",tags="@Smoke")
public class FeatureRunnerClass extends AbstractTestNGCucumberTests {

}
