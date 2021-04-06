package tests;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.DynamicPropertiesPage;
import pages.PracticeFormPage;


public class BaseTest {

	protected String baseUrl="https://demoqa.com/";
	protected WebDriver driver;
	protected DynamicPropertiesPage dynamicPropertiesPage;
	protected PracticeFormPage practiceFormPage;

	
	@BeforeClass
	public void setUp () {
		System.setProperty("webdriver.chrome.driver",
				"driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		
		this.dynamicPropertiesPage = new DynamicPropertiesPage(driver);
		this.practiceFormPage = new PracticeFormPage(driver);
		//this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterClass
	public void closeAplication () {
		this.driver.close();
	}
}
