/*
 *
 */
package com.akkadu.qa.pages;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.akkadu.qa.base.BasePage;
import com.akkadu.qa.utils.TestUtils;

public class LoginPage extends BasePage {

	/** The Log. */
	private static Logger Log = LogManager.getLogger(LoginPage.class.getName());

	/** The Login button. */
	private By loginBttn = By.xpath("//span[contains(text(),'Login')]");

	/** The user email field. */
	private By userEmailField = By.xpath("//input[@name='user_email']");

	/** The user password filed. */
	private By userPasswordField = By.xpath("//input[@name='user_password']");

	/** The Login button */
	private By loginButton = By.xpath("//button[@type='submit']//span[@class='icon is-small']");



	/**
	 * Instantiates a new login page.
	 *
	 * @param driver the driver
	 */
	// initialize elements
	public LoginPage(ThreadLocal<WebDriver> driver) {

		super(driver);
		this.driver = driver;
		Log.info("Initializing login Page Objects");
		PageFactory.initElements(driver.get(), loginBttn);
	}

//add all actions method here
	/**
	 * Method to Login into the Application.
	 */

	public void loginToAkkaduApp(String userEmail, String userPassword) throws InterruptedException {
		gotoURL(TestUtils.getProperty("url"));
		waitForElementToBecomeVisible(loginBttn, longWait);
		clickAndWait(loginBttn, longWait);
		waitForElementToBecomeVisible(userEmailField, longWait);
		setText(userEmailField, userEmail, shortWait);
		setText(userPasswordField, userPassword, shortWait);
		clickAndWait(loginButton, longWait);
		Log.info("Login Successfull");

	}
	
	public void verifySuccessMessageAfterLogin() throws InterruptedException {
		Assert.assertTrue(isTextPresentOnPage("Successfully logged in. Redirecting"), "user not logged in");
		Log.info("Login Successfull");

	}
	
	public void openNewTabToLoginForInterpreter(String userEmail, String userPassword, int tabNo) throws InterruptedException, AWTException{
		//openNewTab();
		openNewTab1();
		switchTab(tabNo);
		gotoURL(TestUtils.getProperty("url"));
		waitForElementToBecomeVisible(loginBttn, longWait);
		clickAndWait(loginBttn, longWait);
		waitForElementToBecomeVisible(userEmailField, longWait);
		setText(userEmailField, userEmail, shortWait);
		setText(userPasswordField, userPassword, shortWait);
		clickAndWait(loginButton, longWait);
		Log.info("Login Successfull");
	}
	
	public void switchToDesiredTab(int tabNo) throws InterruptedException, AWTException{
		switchTab(tabNo);
	}
	


}