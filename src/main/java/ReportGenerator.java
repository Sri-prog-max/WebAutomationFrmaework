
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
 
import java.io.File;
import java.util.Collections;
 
public class ReportGenerator {
    public static void main(String[] args) {
        File reportOutputDir = new File("reports");
        Configuration config = new Configuration(reportOutputDir, "SeleniumCucumberTestNGFramework");
        ReportBuilder builder = new ReportBuilder(Collections.singletonList("reports/cucumber.json"), config);
        builder.generateReports();
    }
}