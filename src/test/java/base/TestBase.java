package base;
 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

 
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
 
public class TestBase {
 
    public WebDriver init_driver(String browserName) {
        WebDriver driver = null;
 
        if (browserName.equalsIgnoreCase("chrome")) {
//            driver = new ChromeDriver(options);
        	System.setProperty("webdriver.chrome.driver", "C:\\Users\\SR20375549\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        	ChromeOptions options = new ChromeOptions();
        	 
            // ✅ Disable password manager & credential popups
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("autofill.profile_enabled", false);
         
            options.setExperimentalOption("prefs", prefs);
         
            // ✅ Additional arguments to suppress automation popups
            options.addArguments(
                "--disable-infobars",
                "--disable-notifications",
                "--disable-save-password-bubble",
                "--disable-extensions",
                "--disable-popup-blocking",
                "--disable-blink-features=AutomationControlled",
                "--no-first-run",
                "--no-service-autorun",
                "--password-store=basic"
            );
         
            // Prevent “controlled by automated test software” banner
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
         
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
 

 
        } else if (browserName.equalsIgnoreCase("edge")) {
        	System.setProperty("webdriver.edge.driver", "C:\\Users\\SR20375549\\Downloads\\edgedriver_win64\\msedgedriver.exe");

        	
//            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--start-maximized");
            driver = new EdgeDriver(options);
        } else {
            throw new RuntimeException("Browser not supported: " + browserName);
        }
 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
 
        return driver;
    }
}