package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage {
	WebDriver driver;
	By passmngr = By.xpath("//button[text()='OK']");
	By menuHeader = By.xpath("//div[@class='bm-menu']");
	By Allitemslink = By.id("inventory_sidebar_link");
	By settingsHeader = By.xpath("//h2[contains(text(),'Settings')]");
	By logout = By.xpath("//a[text()='Logout']");

	public MenuPage(WebDriver driver) {
		this.driver = driver;

	}

	public void verifyMenuPage() {
		driver.findElement(menuHeader).isDisplayed();
	}

	public void clickAllitems() {
		driver.findElement(Allitemslink).click();
	}
	public void logout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(logout));
		logoutLink.click();
//		driver.findElement(logoutLink).click();
	}

}



