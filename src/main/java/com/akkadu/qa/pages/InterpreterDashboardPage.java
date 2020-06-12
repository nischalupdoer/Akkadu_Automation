package com.akkadu.qa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.akkadu.qa.base.BasePage;
import com.akkadu.qa.utils.TestUtils;

public class InterpreterDashboardPage extends BasePage{
	
	/** The Log. */
	private static Logger Log = LogManager.getLogger(LoginPage.class.getName());

	/** The welcome note on the interpreter dashboard */
	private By welComeNote = By.xpath("//h3[@id='welcome-note']");
	
	/** The Start button */
	private By interpretBttn = By.xpath("//div[@id='events__list-container']//span[contains(text(),'Interpret')]");
	
	/** The Start button */
	private By startTurnBttn = By.xpath("//span[contains(text(),'Start turn')]");
	
	public InterpreterDashboardPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		this.driver = driver;
		Log.info("Initializing home Page Objects");
		PageFactory.initElements(driver.get(), welComeNote);
	}
	
	public void verifyWelcomeNoteAfterLoggedInAsInterpreter(){
		waitForElementToBecomeVisible(welComeNote, longWait);
		Assert.assertTrue(isElementPresent(welComeNote), "Interpreter not logged in");
	}
	
	public void verifyAndClickOnInterpreBttn(){
		waitForElementToBecomeVisible(interpretBttn, longWait);
		clickAndWait(interpretBttn, longWait);
		TestUtils.sleep(10);
		waitForElementToBecomeVisible(startTurnBttn, longWait);
	}


}
