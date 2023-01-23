package testrunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions

(
features = "Feature",
glue = {"stepdefinition"},
//tells time taken by each step or method
//plugin = {"usage"},
//plugin = {"pretty","html:target/cucumber-report.html"},
//plugin = {"pretty","json:target/cucumber-report/cucumberjson.json", "html:target/cucumber-report.html", "junit:target/cucumber-report/cucumberxml.xml"},
plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
//monochrome = true,
tags = "not @tagoutline"

//tags = "(@SmokeTest or @RegressionTest) and (not @E2ETest)"
//tags = "@completeprogram"
//tags = "@SmokeTest or @RegressionTest"
//tags = "@SmokeTest and @RegressionTest"

)
public class CucumberRunner extends AbstractTestNGCucumberTests{

}
