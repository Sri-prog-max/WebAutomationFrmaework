package factory;
 
import org.openqa.selenium.WebDriver;
 
public class DriverFactory {
 
    // ThreadLocal for parallel execution
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
 
    // Set driver for each thread
    public static void setDriver(WebDriver driver) {
        tlDriver.set(driver);
    }
 
    // Get driver for each thread
    public static WebDriver getDriver() {
        return tlDriver.get();
    }
 
    // Close driver for that thread
    public static void closeDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}