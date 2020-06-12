package com.akkadu.qa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.akkadu.qa.base.BasePage;
import com.akkadu.qa.utils.TestUtils;

public class SignUpPage extends BasePage{
	
	/** The Log. */
	private static Logger Log = LogManager.getLogger(LoginPage.class.getName());

	/** The Sign up link. */
	private By signUpLink = By.xpath("//a[@href='/account/signup']");
	
	/** sign up email field*/
	private By signupEmailField = By.xpath("//input[@name='user_email']");
	
	/** The user sign up password filed. */
	private By signUpPasswordField = By.xpath("//input[@name='user_password']");
	
	/** The user sign up confirm password filed. */
	private By signUpConfirmPasswordField = By.xpath("//input[@name='user_confirmPassword']");
	
	/** The user  type (Event Organizer)*/
	private By signUpTypeEventOrg = By.id("type-eventOrganizer");
	
	/** The user  type info*/
	private By typeInfo = By.id("typeInfo");
	
	/** The phone number filed. */
	private By phoneNumberField = By.name("user_phone");
	
	/** I accept Terms check box */
	private By iAcceptChkBx = By.name("user_termsOfService");
	
	/** The user sign up button.*/
	private By signUpBttn = By.xpath("//button[@name='signup-btn']");
	
	/** The language change drop down button.*/
	private By languageDropDownBttn = By.xpath("//button[@class='button is-dark is-outlined']");
	
	//button[@class='button is-dark is-outlined']
	
	//select[@id='typeInfo']
	
	public SignUpPage(ThreadLocal<WebDriver> driver) {
		super (driver);
		this.driver = driver;
		Log.info("Initializing login Page Objects");
		PageFactory.initElements(driver.get(), signUpLink);
	}
	
	
	public void enterSignupDetail(String password, String phone) throws InterruptedException {
		waitForElementToBecomeVisible(signupEmailField, longWait);
		String email= "organizer"+randomid()+"@yopmail.com";
		setText(signupEmailField, email, shortWait);
		setText(signUpPasswordField, password, shortWait);
		setText(signUpConfirmPasswordField, password, shortWait);
		setText(phoneNumberField, phone, shortWait);
		clickAndWait(iAcceptChkBx, shortWait);
	}
	
	public void selectuserTypeToSignUp(String type_Info) throws InterruptedException {
		clickAndWait(signUpTypeEventOrg, shortWait);
		waitForElementToBecomeVisible(typeInfo, shortWait);
		selectByCompleteVisibleText(typeInfo, type_Info);
	}
	
	public void clickOnSignUpBttn() throws InterruptedException {
		clickAndWait(signUpBttn, shortWait);
	}
	
	public void clickToSignUpOnAkkaduApp() throws InterruptedException {
		gotoURL(TestUtils.getProperty("url"));
		waitForElementToBecomeVisible(signUpLink, longWait);
		waitForElementToBecomeVisible(languageDropDownBttn, longWait);
		waitForElementToBeClickable(languageDropDownBttn, longWait);
		clickAndWait(signUpLink, longWait);
		
	}

}
