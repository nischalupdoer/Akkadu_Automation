package com.akkadu.qa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.akkadu.qa.base.BasePage;
import com.akkadu.qa.utils.TestUtils;

public class ProfilePage extends BasePage {

	/** The Log. */
	private static Logger Log = LogManager.getLogger(LoginPage.class.getName());

	/** The Gender */
	private By gender = By.xpath("//h5[contains(text(),'Test')]");

	

	public ProfilePage(ThreadLocal<WebDriver> driver) {
		super(driver);
		this.driver = driver;
		Log.info("Initializing login Page Objects");
		PageFactory.initElements(driver.get(), gender);
	}
}
