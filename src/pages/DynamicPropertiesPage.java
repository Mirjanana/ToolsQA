package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicPropertiesPage extends BasePage {

	protected WebDriverWait waiter;
	
	public DynamicPropertiesPage(WebDriver driver) {
		super(driver);
	}
	public WebElement getColorChangeButton() {
		return this.driver.findElement(By.id("colorChange"));
	}
	public WebElement getVisibleAfterFiveSecButton() {
		return this.driver.findElement(By.id("visibleAfter"));
	}
	public void waitUntilMessageApear() {
		this.waiter = new WebDriverWait(driver, 5);
		waiter.until(ExpectedConditions.visibilityOf(getVisibleAfterFiveSecButton()));
		//waiter.until(ExpectedConditions.attributeContains(this.driver.findElement(By.xpath
		//		("//*[contains(@class, 'system_message')]")), "style", "display: none;"));
	}
	public String showMessage () throws InterruptedException {
		return this.getVisibleAfterFiveSecButton().getText();
	}
}
