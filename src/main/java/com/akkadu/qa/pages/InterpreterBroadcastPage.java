package com.akkadu.qa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.akkadu.qa.base.BasePage;
import com.akkadu.qa.utils.TestUtils;

public class InterpreterBroadcastPage extends BasePage {
	
	/** The Log. */
	private static Logger Log = LogManager.getLogger(LoginPage.class.getName());

	/** The Start button */
	private By startTurnBttn = By.xpath("//span[contains(text(),'Start turn')]");
	
	/** The Request change button */
	private By requestChangeBttn = By.xpath("//span[contains(text(),'Request change')]");
	
	/** The listen floor button */
	private By listenFloorBttn = By.xpath("//div[@class='p-3 floor-partner-controls']//button[1]");
	
	/** The listen floor button */
	private By listenPartnerBttn = By.xpath("//div[@class='p-3 floor-partner-controls']//button[2]");
	
	/** The listen floor button */
	private By muteBttn = By.xpath("//span[contains(text(),'Mute')]");
	
	/** The listen floor button */
	private By unmuteBttn = By.xpath("//span[contains(text(),'Unmute')]");
	
	/** The Requesting Interpreter button */
	private By requestingInterpretersBttn = By.xpath("//span[contains(text(),'Requesting interpreters')]");	
	
	/** The Request Confirm  button */
	private By confirmBttn = By.xpath("//span[contains(text(),'Confirm')]");	
	
	//span[contains(text(),'Confirm')]
	

	public InterpreterBroadcastPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		this.driver = driver;
		Log.info("Initializing home Page Objects");
		PageFactory.initElements(driver.get(), startTurnBttn);	
	}
	
	public void clickToConfirmTheRequestAndVerify(){
		waitForElementToBecomeVisible(confirmBttn, longWait);
		clickAndWait(confirmBttn, longWait);
		TestUtils.sleep(7);
		Assert.assertTrue(isElementPresent(requestChangeBttn), "Request is not confirmed");
	}
	
	
	public void verifyAndClickOnRequestChangeBttn(){
		waitForElementToBecomeVisible(requestChangeBttn, longWait);
		clickAndWait(requestChangeBttn, longWait);
		waitForElementToBecomeVisible(requestingInterpretersBttn, longWait);
		Assert.assertTrue(isElementPresent(requestingInterpretersBttn), "requestChangeBttn button is not clicked or requestingInterpretersBttn button is not appearing");
	}
	
	public void verifyAndClickOnListenPartnerBttn(){
		waitForElementToBecomeVisible(listenPartnerBttn, longWait);
		waitForElementToBeClickable(listenPartnerBttn, longWait);
		clickAndWait(listenPartnerBttn, longWait);
		TestUtils.sleep(5);
		String value= getAttribute(listenPartnerBttn, "class");
		System.out.println("value is  ---------------" +value);
		Assert.assertTrue(value.contains("danger"), "Listen partner button is not clicked and color is not green");
	}
	
	public void verifyAndClickOnListenFloorBttn(){
		waitForElementToBecomeVisible(listenFloorBttn, longWait);
		clickAndWait(listenFloorBttn, longWait);
		TestUtils.sleep(5);
		String value= getAttribute(listenFloorBttn, "class");
		System.out.println("value is  ---------------" +value);
		Assert.assertTrue(value.contains("success"), "Listen floor button is not clicked and color is not red");
	}
	
	
	public void verifyAndClickOnUnmuteBttn(){
		waitForElementToBecomeVisible(unmuteBttn, longWait);
		//clickAndWait(unmuteBttn, longWait);
		javascriptButtonClick(unmuteBttn);
		waitForElementToBecomeVisible(muteBttn, longWait);
		Assert.assertTrue(isElementPresent(muteBttn), "Unmute button is not clicked or Mute button is not appearing");
	}
	
	public void verifyAndClickOnMuteBttn(){
		waitForElementToBecomeVisible(muteBttn, longWait);
		//clickAndWait(muteBttn, longWait);
		javascriptButtonClick(muteBttn);
		waitForElementToBecomeVisible(unmuteBttn, longWait);
		Assert.assertTrue(isElementPresent(unmuteBttn), "Mute button is not clicked or Unmute button is not appearing");
	}
	
	public void verifyAndClickOnStartTurnBttn(){
		waitForElementToBecomeVisible(startTurnBttn, longWait);
		clickAndWait(startTurnBttn, longWait);
		waitForElementToBecomeVisible(requestChangeBttn, longWait);
		Assert.assertTrue(isElementPresent(requestChangeBttn), "Start Turn button is not clicked or Request Change button is not appearing");
	}
	
	public void verifyStartTurnBttnOnInterpreter1_AfterConfermTheRequestByInterpreter2(){
		Assert.assertTrue(isElementPresent(startTurnBttn), "Start turn button is not appearing on interpreter1 while request is confirmed by interpreter2");
	}


}
