package runner;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;
 
@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = {"stepDefinitions"},
	    
	    plugin = {
	            "pretty",
	            "html:target/reports/cucumber-reports/cucumber-html-report.html",             // ✅ generates direct HTML report
	            "json:target/reports/cucumber-reports/cucumber.json",         // ✅ required for masterthought plugin
	            
	        },
	        monochrome = true
	    
	)
public class TestNGRunner extends AbstractTestNGCucumberTests {
 
    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void beforeClass(@Optional("edge") String browser) {
        System.setProperty("browser", browser);
    }
 
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
