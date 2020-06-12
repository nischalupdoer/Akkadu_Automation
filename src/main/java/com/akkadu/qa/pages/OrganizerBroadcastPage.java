package com.akkadu.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.akkadu.qa.base.BasePage;
import com.akkadu.qa.utils.TestUtils;

public class OrganizerBroadcastPage extends BasePage{
	
	/** The Log. */
	private static Logger Log = LogManager.getLogger(LoginPage.class.getName());

	/** The Start button */
	private By startBttn = By.xpath("//span[contains(text(),'Start')]");
	
	/** The Listen to speakers button */
	private By listenToSpeakersBttn = By.xpath("//div[@id='controls']//button");

	/** The Mute button */
	private By muteBttn = By.xpath("//span[contains(text(),'Mute')]");

	//span[contains(text(),'Listen to speakers')]
	public OrganizerBroadcastPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		this.driver = driver;
		Log.info("Initializing home Page Objects");
		PageFactory.initElements(driver.get(), startBttn);
	}
	
	public void verifyAndClickOnMuteBttn(){
		waitForElementToBecomeVisible(muteBttn, longWait);
		clickAndWait(muteBttn, longWait);
		Assert.assertTrue(isElementPresent(startBttn), "Mute button is not clicked or start button is not appearing after click on mute button");
	}
	
	public void verifyAndClickOnListenToSpeakersBttn(){
		waitForElementToBecomeVisible(listenToSpeakersBttn, longWait);
		String value= getAttribute(listenToSpeakersBttn, "class");
		//System.out.println("value is before click  ---------------" +value1);
		Assert.assertTrue(value.contains("danger"), "Listen to speakers button is not red");
		clickAndWait(listenToSpeakersBttn, longWait);
		TestUtils.sleep(2);
		String value1= getAttribute(listenToSpeakersBttn, "class");
		//System.out.println("value is  ---------------" +value);
		Assert.assertTrue(value1.contains("success"), "Listen to speakers button is not clicked and green");
	}
	

	public void verifyAndClickOnStartBttn() throws AWTException{
		TestUtils.sleep(10);
		waitForElementToBecomeVisible(startBttn, longWait);
		waitForElementToBeClickable(startBttn, longWait);
		clickAndWait(startBttn, longWait);
		TestUtils.sleep(3);
		handleWindowPopup();
		TestUtils.sleep(7);
		Assert.assertTrue(isElementPresent(muteBttn), "Start button is not clicked or mute button is not appearing after click on start button");
	}
	
	public void handleWindowPopup() throws AWTException {
	Robot robot = new Robot();
	robot.delay(5000);
	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyPress(KeyEvent.VK_ENTER);
	}
}
