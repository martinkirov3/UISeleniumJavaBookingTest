package pageEvents;
import utils.ElementFetch;
import utils.BaseTest;
import utils.Constants;
import pageObjects.SearchPageElements;

import java.util.Random;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPageEvents {
	
	public void enterDestination() {
		ElementFetch elementFetch = new ElementFetch();
		BaseTest.test.getClass().getMethods().toString();
		elementFetch.getWebElement("ID", SearchPageElements.destination).sendKeys("Malaga");
	}
	
	public void clickOnDates() {
		ElementFetch elementFetch = new ElementFetch();
		BaseTest.test.info(this.toString());
		elementFetch.getWebElement("XPATH", SearchPageElements.dates).click();
	}
	
	public void selectCheckIn() {
		ElementFetch elementFetch = new ElementFetch();
		BaseTest.test.info("selectCheckIn");
		WebDriverWait wait = new WebDriverWait(BaseTest.driver, 30000);
		wait.until(ExpectedConditions.elementToBeClickable(elementFetch.getWebElement("XPATH", SearchPageElements.selectCheckIn))).click();
	}
	
	public void selectCheckOut() {
		ElementFetch elementFetch = new ElementFetch();
		BaseTest.test.info("selectCheckOut");
		WebDriverWait wait = new WebDriverWait(BaseTest.driver, 30000);
		wait.until(ExpectedConditions.elementToBeClickable(elementFetch.getWebElement("XPATH", SearchPageElements.selectCheckOut))).click();
	}
	
	public void clickOnGuests() {
		ElementFetch elementFetch = new ElementFetch();
		BaseTest.test.info("clickOnGuests");
		elementFetch.getWebElement("XPATH", SearchPageElements.guests).click();
	}
	
	public void addAdults() {
		ElementFetch elementFetch = new ElementFetch();
		BaseTest.test.info("addAdults");
		while (Integer.parseInt(Constants.adults)>Integer.parseInt(elementFetch.getWebElement("XPATH", SearchPageElements.adults).getText())) {
			elementFetch.getWebElement("XPATH", SearchPageElements.addAdults).click();
		}	
	}
	
	public void addChildren() {
		ElementFetch elementFetch = new ElementFetch();
		BaseTest.test.info("addChildren");
		while (Integer.parseInt(Constants.children)>Integer.parseInt(elementFetch.getWebElement("XPATH", SearchPageElements.children).getText())) {
			elementFetch.getWebElement("XPATH", SearchPageElements.addChildren).click();
			elementFetch.getWebElement("XPATH", SearchPageElements.age).click();
			Select dropdown = new Select(elementFetch.getWebElement("XPATH", SearchPageElements.ageSelect));
			dropdown.selectByIndex(new Random().nextInt(dropdown.getOptions().size())); 
		}
	}
	
	public void addRooms() {
		ElementFetch elementFetch = new ElementFetch();
		BaseTest.test.info("addRooms");
		while (Integer.parseInt(Constants.rooms)>Integer.parseInt(elementFetch.getWebElement("XPATH", SearchPageElements.rooms).getText())) {
			elementFetch.getWebElement("XPATH", SearchPageElements.addRooms).click();
		}
	}
	
	public void clickOnSearchButton() {
		ElementFetch elementFetch = new ElementFetch();
		BaseTest.test.info("clickOnSearchButton");
		elementFetch.getWebElement("XPATH", SearchPageElements.searchButton).click();
	}
}
