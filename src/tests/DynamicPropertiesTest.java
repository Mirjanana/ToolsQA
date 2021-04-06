package tests;

import org.testng.annotations.Test;

import org.testng.Assert;

public class DynamicPropertiesTest extends BaseTest{

	@Test
	public void changeOfColor () throws InterruptedException {
		this.driver.get(baseUrl + "dynamic-properties");
		this.dynamicPropertiesPage.waitUntilMessageApear();
		String message = "Visible After 5 Seconds";
		Assert.assertTrue(this.dynamicPropertiesPage.showMessage().contains(message),
				"[ERROR]: Message for visibility is not valid");
	}
}
