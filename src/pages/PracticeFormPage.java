package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PracticeFormPage extends BasePage {
	
	private String male;
	private String female;
	private String other;
	private String sports;
	private String reading;
	private String music;
	protected JavascriptExecutor executor;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public PracticeFormPage(WebDriver driver) {
		super(driver);
	}
	public WebElement getFirstName() {
		return this.driver.findElement(By.id("firstName"));
	}
	public WebElement getLastName() {
		return this.driver.findElement(By.id("lastName"));
	}
	public WebElement getEmail() {
		return this.driver.findElement(By.id("userEmail"));
	}
	public WebElement getGenderMale(String male) {
		return this.driver.findElement(By.id("gender-radio-1"));
	}
	public WebElement getGenderFemale(String female) {
		return this.driver.findElement(By.id("gender-radio-2"));
	}
	public WebElement getGenderOther(String other) {
		return this.driver.findElement(By.id("gender-radio-3"));
	}
	public WebElement getMobile() {
		return this.driver.findElement(By.id("userNumber"));
	}
	public WebElement getDateOfBirth() {
		return this.driver.findElement(By.xpath("//*[@id=\"subjectsContainer\"]/div/div[1]"));
	}
	public WebElement getHobiesSports() {
		return this.driver.findElement(By.id("hobbies-checkbox-1"));
	}
	public WebElement getHobiesReading() {
		return this.driver.findElement(By.id("hobbies-checkbox-2"));
	}
	public WebElement getHobiesMusic() {
		return this.driver.findElement(By.id("hobbies-checkbox-3"));
	}
	public WebElement getPicture() {
		return this.driver.findElement(By.id("uploadPicture"));
	}

	public WebElement getCurrentAddress() {
		return this.driver.findElement(By.id("currentAddress"));
	}
	public Select getUserState() {
		Select element = new Select(this.driver.findElement(By.id("state")));
		return element;
	}
	public Select getUserCity() {
		Select element = new Select(this.driver.findElement(By.id("city")));
		return element;
	}
	public WebElement getSubmitButton() {
		return this.driver.findElement(By.id("submit"));
	}
	public void getInputType() {
		js.executeScript("arguments[0].click();",getPicture() );
	}
	public void uploadPicture (String imgPath) {
		getInputType();
		this.driver.findElement(By.xpath("//input[@type='file']")).sendKeys(imgPath);
	}
	public void submitForm (String firstName, String lastName, String email, String gender,
			String mobileNumber, String dateOfBirth, String hobies, String imgPath, 
			String address,String state, String city) {
		this.getFirstName().sendKeys(firstName);
		this.getLastName().sendKeys(lastName);
		this.getEmail().sendKeys(email);
		if (gender==male) {
			this.getGenderMale(gender).click();	
		} else if (gender==female) {
			this.getGenderFemale(gender).click();	
		} else {
			this.getGenderOther(gender).click();
		}
		this.getMobile().sendKeys(mobileNumber);
		this.getDateOfBirth().sendKeys(dateOfBirth);
		if (hobies==sports) {
			this.getHobiesSports().click();	
		} else if (hobies==reading) {
			this.getHobiesSports().click();	
		} else {
			this.getHobiesSports().click();
		}
		this.uploadPicture(imgPath);
		this.getCurrentAddress().sendKeys(address);
		this.getUserState().selectByVisibleText(state);
		this.getUserCity().selectByVisibleText(city);
	}
	public void twoHobies (String hobie2) {
		if (hobie2==sports) {
			this.getHobiesSports().click();	
		} else if (hobie2==reading) {
			this.getHobiesSports().click();	
		} else {
			this.getHobiesSports().click();
		}
	}
	public void threeHobies (String hobie2, String hobie3) {
		if (hobie2==sports || hobie3 == sports) {
			this.getHobiesSports().click();	
		} else if (hobie2==reading || hobie3==reading) {
			this.getHobiesSports().click();	
		} else {
			this.getHobiesSports().click();
		}
	}
}
