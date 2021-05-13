package runnerTest1;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		//tags= "@RegressionTest",
		features="features",
		glue={"stepDefs"},
		//monochrome=true,
		plugin= {"pretty","html:target/cucumber-html-report"
		//"json:target/cucumber-reports/cucumber.json"
		}
		)
public class APITestRunner {

}
