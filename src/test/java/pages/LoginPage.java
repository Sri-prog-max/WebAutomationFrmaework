//package pages;
//
//public class LoginPage {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}

package pages;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class LoginPage {
    WebDriver driver;
    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");
 
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
 
    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }
 
    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }
 
    public HomePage clickLogin() {
        driver.findElement(loginBtn).click();
        return new HomePage(driver);
    }
}
 
