package pageEvents;
import pageObjects.ResultsPageElements;
import utils.BaseTest;
import utils.ElementFetch;


public class ResultsPageEvents {
	
	public static final String FirstResult = null;

	public static boolean isFirstResultDisplayed() {
		ElementFetch elementFetch = new ElementFetch();
		BaseTest.test.info("Checking for at least 1 result");
		if (elementFetch.getWebElement("XPATH", ResultsPageElements.firstResult).isDisplayed()) {
			return true;
			}
		else {
			return false;
		}
	}


}
