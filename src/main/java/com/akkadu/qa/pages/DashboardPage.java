package com.akkadu.qa.pages;

import java.awt.AWTException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.akkadu.qa.base.BasePage;
import com.akkadu.qa.utils.TestUtils;

public class DashboardPage extends BasePage {

	/** The Log. */
	private static Logger Log = LogManager.getLogger(LoginPage.class.getName());

	/** The Create Event button */
	private By createEventBttn = By.xpath("//span[contains(text(),'Create Event')]");
	
	/** The event name field */
	private By eventNameField = By.xpath("//div[@class='control is-clearfix']//input[@class='input']");
	
	/** The time done button */
	private By doneBttn = By.xpath("//span[contains(text(),'Done!')]");
	
	/** The Bio text area */
	private By bioTextArea = By.xpath("//textarea[@class='textarea']");
	
	/** The Next button */
	private By nextBttn = By.xpath("//span[contains(text(),'Next')]");
	
	/** The From language dropdown */
	private By fromLanguageDropDown = By.xpath("//span[contains(text(),'From:')]//following-sibling::div");
	
	/** The English (India) language */
	private By engIndiaLanguage = By.xpath("//a [contains(text(),'English (India)')]");
	
	/** The To language dropdown */
	private By toLanguageDropDown = By.xpath("//span[contains(text(),'To:')]//following-sibling::div");
	
	/** The Level of interpretation (Expert) */
	private By expertRadioBttn = By.xpath("//div[@class='interpretation-levels']//div[1]//label[1]");
	
	/** The Create button */
	private By createBttn = By.xpath("//button[@class='button transition ml-auto is-medium is-primary']//span[contains(text(),'Create')]");
	
	/** The Save QR code button*/
	private By saveQrCodeBttn = By.xpath("//span[contains(text(),'Save QR Code')]");
	
	/** The Save QR code button*/
	private By audienceLinkBttn = By.xpath("//span[contains(text(),'Audience link')]");
	
	/** The Save QR code button*/
	private By finishBttn = By.xpath("//span[contains(text(),'Finish')]");
	
	/** The newly created event name*/
	private By newlyCreatedEventName = By.xpath("//div[@id='events__list-container']//div[1]//div[1]//div[2]//h3");
	
	/** The Edit button on newly created event*/
	private By newlyCreatedEventEditBttn = By.xpath("//div[@id='events__list-container']//div[1]//div[2]//div[1]//div[1]//span[contains(text(),'Edit')]");
	
	/** The PDF manager button*/
	private By pdfManagerBttn = By.xpath("//section[@class='dashboard-edit edit-card-wrapper']//section//span[contains(text(),'PDF Manager')]");
	
	/** The number of presentation field*/
	private By noOfPresentationField = By.xpath("//input[@name='pdf_slots_number']");
	
	/** The add presentations button*/
	private By addPresentationsBttn = By.xpath("//span[contains(text(),'Add Presentations')]");
	
	/** The add presentation (file) icon*/
	private By addFileIcon = By.xpath("//span[@class='icon']");
	
	/** The save button to combine and save the added presentation file*/
	private By saveButton = By.xpath("//button[@class='button save-pdf-state-button is-light']//span[contains(text(),'Save')]");
	
	/** The Done button on presentation add section*/
	private By doneButton = By.xpath("//span[contains(text(),'Done')]");
	
	/** The event title field on edit event section*/
	private By evetTitleField = By.xpath("//section[@class='dashboard-edit edit-card-wrapper']//section//div//input[@placeholder='Event Title']");
	
	/** The event title field on edit event section*/
	private By eventIntroTxtArea = By.xpath("//section[@class='dashboard-edit edit-card-wrapper']//section//div//textarea[@placeholder='Event Introduction']");
	
	/** The choose file button*/
	private By chooseFileBttn = By.xpath("//section//input[@name='poster']");
	
	/** The choose file button*/
	private By saveChangesBttn = By.xpath("//section[@class='dashboard-edit edit-card-wrapper']//section//span[contains(text(),'Save Changes')]");
	
	/** The manage speakers button*/
	private By manageSpeakersBttn = By.xpath("//section[@class='dashboard-edit edit-card-wrapper']//section//span[contains(text(),'Manage speakers')]");
	
	/** The add speaker button*/
	private By addSpeakerBttn = By.xpath("//span[contains(text(),'Add speaker')]");
	
	/** The speaker search field by email*/
	private By searchEmailField = By.xpath("//input[@class='input']");
	
	/** The search button*/
	private By searchBttn = By.xpath("//span[contains(text(),'Search')]");
	
	/** The see speakers button*/
	private By seeSpeakers = By.xpath("//span[contains(text(),'See speakers')]");
	
	/** The streaming link button*/
	private By streamingLinkBttn = By.xpath("//span[contains(text(),'Streaming Link')]");
	
	/** The add this speaker button*/
	private By addThisSpeakerBttn = By.xpath("//span[contains(text(),'Add this speaker')]");
	
	/** The message after adding a particular speaker*/
	private By msgAfterAddSpeaker = By.xpath("//div[@class='flex items-center']");
	
	/** The Stream button on newly created event*/
	private By streamBttn = By.xpath("//div[@id='events__list-container']//div[1]//div[2]//div[1]//div[1]//span[contains(text(),'Stream')]");
	
	
	
	
	
	public DashboardPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		this.driver = driver;
		Log.info("Initializing home Page Objects");
		PageFactory.initElements(driver.get(), createEventBttn);
	}
	
	public void verifyAndClickOnStreamBttn(){
		waitForElementToBecomeVisible(streamBttn, longWait);
		waitForElementToBeClickable(streamBttn, longWait);
		clickAndWait(streamBttn, longWait);
		switchTab(1);
	}
	
	public void verifyMessageAfterAddingTheSpeaker(){
		waitForElementToBecomeVisible(msgAfterAddSpeaker, longWait);
		Assert.assertTrue(isElementPresent(msgAfterAddSpeaker), "Speaker not added");
	}
	
	public void verifyAndClickOnAddThisSpeakerBttn(){
		waitForElementToBecomeVisible(addThisSpeakerBttn, longWait);
		waitForElementToBeClickable(addThisSpeakerBttn, longWait);
		clickAndWait(addThisSpeakerBttn, longWait);
	}

	public void enterEmailToSearchForTheSpeakerAndClickOnSearchBttn(String email){
		waitForElementToBecomeVisible(searchEmailField, shortWait);
		setText(searchEmailField, email, shortWait);
		javascriptButtonClick(searchBttn);
		//clickAndWait(searchBttn, shortWait);
		// interpreter1@akkadu-team.com
	}

	
	public void verifyAndClickOnAddSpeakersBttn(){
		waitForElementToBecomeVisible(addSpeakerBttn, longWait);
		waitForElementToBeClickable(addSpeakerBttn, longWait);
		javascriptButtonClick(addSpeakerBttn);
		//clickAndWait(addSpeakerBttn, longWait);
		waitForElementToBeClickable(streamingLinkBttn, shortWait);
		Assert.assertTrue(isElementPresent(streamingLinkBttn), "Streaming link button is not appearing on the manage speakers window");
		Assert.assertTrue(isElementPresent(seeSpeakers), "See speakers button is not appearing on the manage speakers window");
	}
	
	public void verifyAndClickOnManageSpeakersBttn(){
		waitForElementToBeClickable(manageSpeakersBttn, shortWait);
//		waitForElementToBecomeVisible(manageSpeakersBttn, shortWait);
		clickAndWait(manageSpeakersBttn, longWait);
	}

	
	public void verifyToAddPoster(String fileName) throws InterruptedException, AWTException {
		waitForElementToBecomeVisible(chooseFileBttn, longWait);
		javascriptButtonClick(chooseFileBttn);
		TestUtils.sleep(4);
		addImageMethod(fileName);
		TestUtils.sleep(7);
		}
	
	public void clickOnSaveChangesButton() {
		waitForElementToBecomeVisible(saveChangesBttn, shortWait);
		clickAndWait(saveChangesBttn, longWait);
		TestUtils.sleep(7);
	}

	
	public String editEventTitleAndEventIntro() throws InterruptedException {
		waitForElementToBecomeVisible(evetTitleField, longWait);
		String eventTitle= "event"+randomid();
		setText(evetTitleField, eventTitle, shortWait);
		setText(eventIntroTxtArea, eventTitle+"is going to start", shortWait);
		return eventTitle;
	}
	
	public void clickOnDoneButton() {
		waitForElementToBeClickable(doneButton, longWait);
//		waitForElementToBecomeVisible(doneButton, longWait);
		clickAndWait(doneButton, longWait);
	}
	
	
	public void verifyToAddPresentationAndClickOnSaveButton(String fileName) throws InterruptedException, AWTException {
		waitForElementToBecomeVisible(addFileIcon, longWait);
		javascriptButtonClick(addFileIcon);
		TestUtils.sleep(4);
		addImageMethod(fileName);
		waitForElementToBecomeVisible(saveButton, shortWait);
		clickAndWait(saveButton, shortWait);
		TestUtils.sleep(7);
		}
	
	public void clickOnAddPresentationsButton() {
		waitForElementToBecomeVisible(addPresentationsBttn, longWait);
		clickAndWait(addPresentationsBttn, longWait);
	}
	
	public void eneterNumberOfPresentation(String count) {
		waitForElementToBecomeVisible(noOfPresentationField, longWait);
		setText(noOfPresentationField, count, shortWait);
	}
	
	public void clickOnPdfManagerButton() {
		waitForElementToBecomeVisible(pdfManagerBttn, longWait);
		clickAndWait(pdfManagerBttn, longWait);
	}
	
	public void editNewlyCreatedEvent() {
		waitForElementToBecomeVisible(newlyCreatedEventEditBttn, longWait);
		waitForElementToBeClickable(newlyCreatedEventEditBttn, longWait);
		clickAndWait(newlyCreatedEventEditBttn, longWait);
	}
	
	
	public void verifyNewlyCreatedEventByName(String expEventName) throws InterruptedException {
		waitForElementToBecomeVisible(newlyCreatedEventName, longWait);
		String actEventName= getText(newlyCreatedEventName);
		Assert.assertTrue(actEventName.contains(expEventName), "Event not created");
	}
	
	public void clickOnFinishButton() throws InterruptedException {
		clickAndWait(finishBttn, shortWait);
	}
	
	public void verifyToClickOnAudinceLinkBttn() throws InterruptedException {
		waitForElementToBeClickable(audienceLinkBttn, shortWait);
		clickAndWait(audienceLinkBttn, shortWait);
	}
	
	public void clickOnSaveQrCodeButtonAndVerifyToDownloadIt() throws InterruptedException {
		waitForElementToBecomeVisible(saveQrCodeBttn, longWait);
		waitForElementToBeClickable(saveQrCodeBttn, longWait);
		clickAndWait(saveQrCodeBttn, longWait);
	}
	
	public void clickOnCreateButton() throws InterruptedException {
		clickAndWait(createBttn, shortWait);
	}
	
	public void selectExpertType() throws InterruptedException {
		waitForElementToBeClickable(expertRadioBttn, shortWait);
	//	waitForElementToBecomeVisible(expertRadioBttn, shortWait);
		clickAndWait(expertRadioBttn, shortWait);
	}
	
	public void selectFromAndTotLanguages() throws InterruptedException {
		waitForElementToBecomeVisible(fromLanguageDropDown, shortWait);
		clickAndWait(fromLanguageDropDown, shortWait);
		waitForElementToBecomeVisible(engIndiaLanguage, shortWait);
		//clickAndWait(engIndiaLanguage, shortWait);
		javascriptButtonClick(engIndiaLanguage);
		clickAndWait(toLanguageDropDown, shortWait);
	}
	
	public String enterEventNameAndBio() throws InterruptedException {
		waitForElementToBecomeVisible(eventNameField, longWait);
		String eventName= "event"+randomid();
		setText(eventNameField, eventName, shortWait);
		setText(bioTextArea, eventName+"is going to start", shortWait);
		return eventName;
	}
	
	public void clickOnNextButton() throws InterruptedException {
		clickAndWait(nextBttn, longWait);
	}
	
	public void clickToCreateEvent() throws InterruptedException {
		waitForElementToBecomeVisible(createEventBttn, longWait);
		clickAndWait(createEventBttn, longWait);
		Log.info("Login Successfull");
	}
	
	public void verifyHomePageAfterLogin() throws InterruptedException {
		waitForElementToBecomeVisible(createEventBttn, longWait);
		Assert.assertTrue(isElementPresent(createEventBttn), "user is not logged in");
		Log.info("Login Successfull");
	}
}