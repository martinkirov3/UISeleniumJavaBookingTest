package pageEvents;
import org.testng.Assert;

import pageObjects.HomePageElements;
import pageObjects.SearchPageElements;
import utils.BaseTest;
import utils.ElementFetch;

public class HomePageEvents {
	
	public void verifySearchButton() {
		ElementFetch elementFetch = new ElementFetch();
		Assert.assertTrue(elementFetch.getWebElements("ID", SearchPageElements.searchButton).toString().length()>0, "Search button is there");
	}
	
	public void acceptTermsAndConditions() {
		ElementFetch elementFetch = new ElementFetch();
		BaseTest.test.info("acceptTermsAndConditions");
		elementFetch.getWebElement("XPATH", HomePageElements.termsAndConditions).click();
	}
	
}
