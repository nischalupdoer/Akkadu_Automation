package com.akkadu.qa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.internal.BaseAction;

// TODO: Auto-generated Javadoc
/**
 * Created By : Adeeb.
 */

public class PageCollection 
{
	/** The Log. */
	private static Logger Log = LogManager.getLogger(PageCollection.class.getName());

	/** The driver. */
	protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	/** The login page. */
	private LoginPage loginPage;
	
	private SignUpPage signUpPage;
	
	private DashboardPage dashboardPage;
	
	private ProfilePage profilePage;
	
	private OrganizerBroadcastPage organizerBroadcastPage;
	
	private InterpreterDashboardPage interpreterDashboardPage;
	
	private InterpreterBroadcastPage interpreterBroadcastPage;
		
	

		
	/**
	 * Instantiates a new page collection.
	 *
	 * @param driver the driver
	 */
	public PageCollection(ThreadLocal<WebDriver> driver) 
	{
		this.driver = driver;
		Log.info("Initialized Page Collection Class");
	}

	/**
	 * Gets the login page.
	 *
	 * @return the login page
	 */


	public LoginPage getLoginPage() 
	{
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}
	
	public SignUpPage getSignUpPage() 
	{
		return (signUpPage == null) ? signUpPage = new SignUpPage(driver) : signUpPage;
	}
	
	public DashboardPage getDashboardPage() 
	{
		return (dashboardPage == null) ? dashboardPage = new DashboardPage(driver) : dashboardPage;
	}
	
	public ProfilePage getProfilePage() 
	{
		return (profilePage == null) ? profilePage = new ProfilePage(driver) : profilePage;
	}
	
	public OrganizerBroadcastPage getOrganizerBroadcastPage() 
	{
		return (organizerBroadcastPage == null) ? organizerBroadcastPage = new OrganizerBroadcastPage(driver) : organizerBroadcastPage;
	}
	
	public InterpreterDashboardPage getInterpreterDashboardPage() 
	{
		return (interpreterDashboardPage == null) ? interpreterDashboardPage = new InterpreterDashboardPage(driver) : interpreterDashboardPage;
	}
	
	public InterpreterBroadcastPage getInterpreterBroadcastPage() 
	{
		return (interpreterBroadcastPage == null) ? interpreterBroadcastPage = new InterpreterBroadcastPage(driver) : interpreterBroadcastPage;
	}
}