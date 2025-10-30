package pages;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class HomePage {
    WebDriver driver;
    By title = By.xpath("//title[text()='Swag Labs']");
    By menu = By.id("react-burger-menu-btn");
    By profileLink = By.id("inventory_sidebar_link");
    By addtocart = By.xpath("//div[text()='Sauce Labs Backpack']/following::button[1]");
    By yourcart = By.xpath("//a[@class='shopping_cart_link']");
    By removeitem = By.xpath("//button[text()='Remove']");
 
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
 
    public void verifyDashboard() {
        driver.findElement(title).isDisplayed();
    }
 
    public void clickaddtocart() {
        driver.findElement(addtocart).click();
    }
    
    public void viewyourcart() {
        driver.findElement(yourcart).click();
    }
    
    public void removeitem() {
        driver.findElement(removeitem).click();
    }
    
//  public MenuPage goToMenuoptions() {
//      driver.findElement(menu).click();
//      return new MenuPage(driver);
//    }

	public MenuPage goToMenuoptions() {
		driver.findElement(menu).click();
		return new MenuPage(driver);
	}
}