package com.akkadu.qa.uitests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.akkadu.qa.base.MyScreenRecorder;
import com.akkadu.qa.utils.TestUtils;
import com.relevantcodes.extentreports.LogStatus;

public class SmokeTest extends BaseTest {

	/** The Log. */
	private static Logger Log = LogManager.getLogger(SmokeTest.class.getName());

	/**
	 * Test Login Flow.
	 * Verify home page after login
	 */
	@Test(description = "To verify login on Akkadu application")
	public void loginToAkkaduAppTest() throws Exception {

		test = extent.startTest("Login to Akkadu application Test");
		test.log(LogStatus.INFO,"Entered User email, password and click on Login button");

		MyScreenRecorder.startRecording("loginToAkkaduAppTest");

		pages.getLoginPage().loginToAkkaduApp("eventorganizer@akkadu-team.com", "qatestuser3");
		
		//test.log(LogStatus.INFO, "Verify success message  after login");
		//pages.getLoginPage().verifySuccessMessageAfterLogin();
		
		test.log(LogStatus.INFO, "Verify Home page afetr login");
		pages.getDashboardPage().verifyHomePageAfterLogin();
		
		test.log(LogStatus.PASS, "Login to akkadu application Test");

		MyScreenRecorder.stopRecording();
	}
	
	/**
	 * Test Sign up Flow.
	 * Verify home page after Sign up
	 */
	
	@Test(description = "To verify signup on Akkadu application")
	public void signUpToAkkaduAppTest() throws Exception {

		test = extent.startTest("Sign up to Akkadu application Test");
		test.log(LogStatus.INFO,"Click on signup link");

		MyScreenRecorder.startRecording("signUpToAkkaduAppTest");
		
		pages.getSignUpPage().clickToSignUpOnAkkaduApp();
		
		test.log(LogStatus.INFO,"Entered User email, paasword, confirm password and etc");
		pages.getSignUpPage().enterSignupDetail("Akkadutest.17", "1234567899");
		
		test.log(LogStatus.INFO, "Select user type to signup");
		pages.getSignUpPage().selectuserTypeToSignUp("Other");
		
		test.log(LogStatus.INFO, "click on signup button");
		pages.getSignUpPage().clickOnSignUpBttn();
		test.log(LogStatus.PASS, "Signup to akkadu application Test");
		
		test.log(LogStatus.INFO, "Verify Home page afetr signup");
		pages.getDashboardPage().verifyHomePageAfterLogin();
		MyScreenRecorder.stopRecording();
	}
	
	/**
	 * Test Create Event Flow.
	 * Verify home page after Sign up
	 */
	
	@Test(description = "To verify create event")
	public void verifyToCreateEventTest() throws Exception {

		test = extent.startTest("Create Event Test");
		test.log(LogStatus.INFO,"Entered User email, password and click on Login button");

		MyScreenRecorder.startRecording("verifyToCreateEventTest");

		pages.getLoginPage().loginToAkkaduApp("eventorganizer@akkadu-team.com", "qatestuser3");
		
		test.log(LogStatus.INFO, "Verify Home page afetr login");
		pages.getDashboardPage().verifyHomePageAfterLogin();
		
		test.log(LogStatus.INFO, "Click on create event button");
		pages.getDashboardPage().clickToCreateEvent();
		
		test.log(LogStatus.INFO, "Enter event name and bio");
		String eventName= pages.getDashboardPage().enterEventNameAndBio();
		
		test.log(LogStatus.INFO, "Click on next button");
		pages.getDashboardPage().clickOnNextButton();
		
		test.log(LogStatus.INFO, "Select From and To language");
		pages.getDashboardPage().selectFromAndTotLanguages();
		
		test.log(LogStatus.INFO, "Select expert type");
		pages.getDashboardPage().selectExpertType();
		
		test.log(LogStatus.INFO, "Click on create button");
		pages.getDashboardPage().clickOnCreateButton();
		
		test.log(LogStatus.INFO, "Click on save QR code button to download/save the QR code");
		pages.getDashboardPage().clickOnSaveQrCodeButtonAndVerifyToDownloadIt();
		
		test.log(LogStatus.INFO, "Click on audince link button to copy the audince link");
		pages.getDashboardPage().verifyToClickOnAudinceLinkBttn();
		
		test.log(LogStatus.INFO, "Click on finish button");
		pages.getDashboardPage().clickOnFinishButton();
		
		test.log(LogStatus.INFO, "Verify newly created event in the list ");
		pages.getDashboardPage().verifyNewlyCreatedEventByName(eventName);
		
		test.log(LogStatus.PASS, "Create Event Test");

		MyScreenRecorder.stopRecording();
	}
	
	@Test(description = "To verify edit event")
	public void verifyToEditEventTest() throws Exception {

		test = extent.startTest("Edit Event Test");
		test.log(LogStatus.INFO,"Entered User email, password and click on Login button");

		MyScreenRecorder.startRecording("verifyToEditEventTest");

		pages.getLoginPage().loginToAkkaduApp("eventorganizer@akkadu-team.com", "qatestuser3");
		
		test.log(LogStatus.INFO, "Verify Home page afetr login");
		pages.getDashboardPage().verifyHomePageAfterLogin();
		
		test.log(LogStatus.INFO, "Click on edit event button");
		pages.getDashboardPage().editNewlyCreatedEvent();
		
		test.log(LogStatus.INFO, "Click on PDF manager button");
		pages.getDashboardPage().clickOnPdfManagerButton();
		
		test.log(LogStatus.INFO, "enter number of presentation to add the presentations");
		pages.getDashboardPage().eneterNumberOfPresentation("1");
		
		test.log(LogStatus.INFO, "Click on add presentations button");
		pages.getDashboardPage().clickOnAddPresentationsButton();
		
		test.log(LogStatus.INFO, "Add PDF and click on save button");
		pages.getDashboardPage().verifyToAddPresentationAndClickOnSaveButton("pdfFile.pdf");
		
		test.log(LogStatus.INFO, "Click on Done button");
		pages.getDashboardPage().clickOnDoneButton();
		
		test.log(LogStatus.INFO, "Edit event title and event intro");
		String eventTitle= pages.getDashboardPage().editEventTitleAndEventIntro();
		
		test.log(LogStatus.INFO, "Verify to add poster");
		pages.getDashboardPage().verifyToAddPoster("image.jpg");
		
		test.log(LogStatus.INFO, "Click on save changes  button");
		pages.getDashboardPage().clickOnSaveChangesButton();
		
		test.log(LogStatus.INFO, "Verify newly edited event in the list ");
		pages.getDashboardPage().verifyNewlyCreatedEventByName(eventTitle);
		
		test.log(LogStatus.PASS, "Create Event Test");

		MyScreenRecorder.stopRecording();
	}
	
	@Test(description = "To verify manage speaker")
	public void verifyToManageSpeakersOnEvent() throws Exception {

		test = extent.startTest("Manage Speaker Test");
		test.log(LogStatus.INFO,"Entered User email, password and click on Login button");

		MyScreenRecorder.startRecording("verifyToManageSpeakersOnEvent");

		pages.getLoginPage().loginToAkkaduApp("eventorganizer@akkadu-team.com", "qatestuser3");
		
		test.log(LogStatus.INFO, "Verify Home page afetr login");
		pages.getDashboardPage().verifyHomePageAfterLogin();
		
		test.log(LogStatus.INFO, "Click on edit event button");
		pages.getDashboardPage().editNewlyCreatedEvent();
		
		test.log(LogStatus.INFO, "Verify and click on manage speaker button");
		pages.getDashboardPage().verifyAndClickOnManageSpeakersBttn();
		
		test.log(LogStatus.INFO, "Verify and click on add speaker button");
		pages.getDashboardPage().verifyAndClickOnAddSpeakersBttn();
		
		test.log(LogStatus.INFO, "Enter email to search for speaker and click on search button");
		pages.getDashboardPage().enterEmailToSearchForTheSpeakerAndClickOnSearchBttn("interpreter1@akkadu-team.com");
		
		test.log(LogStatus.INFO, "Verify and click on add this speaker button");
		pages.getDashboardPage().verifyAndClickOnAddThisSpeakerBttn();
		
		test.log(LogStatus.INFO, "Verify message after adding the speaker");
	    pages.getDashboardPage().verifyMessageAfterAddingTheSpeaker();
	    
	    test.log(LogStatus.INFO, "Click on Done button");
		pages.getDashboardPage().clickOnDoneButton();
		
		test.log(LogStatus.PASS, "Manage Speaker Test");

		MyScreenRecorder.stopRecording();
	}
	
	@Test(description = "To verify Streaming")
	public void verifyToStreamingOnBroadcast() throws Exception {

		test = extent.startTest("Streaming Test");
		test.log(LogStatus.INFO,"Entered User email, password and click on Login button");

		MyScreenRecorder.startRecording("verifyToStreamingOnBroadcast");

		pages.getLoginPage().loginToAkkaduApp("eventorganizer@akkadu-team.com", "qatestuser3");
		
		test.log(LogStatus.INFO, "Verify Home page afetr login");
		pages.getDashboardPage().verifyHomePageAfterLogin();
		
		test.log(LogStatus.INFO, "Click on stream button to stream the event");
		pages.getDashboardPage().verifyAndClickOnStreamBttn();
		
		test.log(LogStatus.INFO, "Verify and click on start button and verify after click on it");
		pages.getOrganizerBroadcastPage().verifyAndClickOnStartBttn();
		
		test.log(LogStatus.INFO, "Verify and click on listen to speakers button and verify colors of it");
		pages.getOrganizerBroadcastPage().verifyAndClickOnListenToSpeakersBttn();
		
		test.log(LogStatus.INFO, "Click on mute button and verify after click on it");
		pages.getOrganizerBroadcastPage().verifyAndClickOnMuteBttn();
		
		test.log(LogStatus.INFO, "Open new tab to login as a interpreter");
		pages.getLoginPage().openNewTabToLoginForInterpreter("interpreter1@akkadu-team.com", "qatestuser1", 2);
		
		test.log(LogStatus.INFO, "Verify welcome note after logged in as a interpreter");
	    pages.getInterpreterDashboardPage().verifyWelcomeNoteAfterLoggedInAsInterpreter();
	    
	    test.log(LogStatus.INFO, "Click on Interpret button");
		pages.getInterpreterDashboardPage().verifyAndClickOnInterpreBttn();
		
		test.log(LogStatus.INFO, "Click on Start turn button");
		pages.getInterpreterBroadcastPage().verifyAndClickOnStartTurnBttn();
		
		test.log(LogStatus.INFO, "Click on mute button and verify unmute button after click on it");
		pages.getInterpreterBroadcastPage().verifyAndClickOnMuteBttn();
		
		test.log(LogStatus.INFO, "Click on unmute button and verify mute button after click on it");
		pages.getInterpreterBroadcastPage().verifyAndClickOnUnmuteBttn();
		
		test.log(LogStatus.INFO, "Verify and click on listen floor button and verify its color functionality");
		pages.getInterpreterBroadcastPage().verifyAndClickOnListenFloorBttn();
		
		test.log(LogStatus.INFO, "Verify and click on listen partner button and verify its color functionality");
		pages.getInterpreterBroadcastPage().verifyAndClickOnListenPartnerBttn();
		
				/////////////////////
		test.log(LogStatus.INFO, "Open new tab to login as a interpreter 2");
		pages.getLoginPage().openNewTabToLoginForInterpreter("interpreter2@akkadu-team.com", "qatestuser2",3);
		
		test.log(LogStatus.INFO, "Verify welcome note after logged in as a interpreter 2");
	    pages.getInterpreterDashboardPage().verifyWelcomeNoteAfterLoggedInAsInterpreter();
	    
	    test.log(LogStatus.INFO, "Click on Interpret button");
		pages.getInterpreterDashboardPage().verifyAndClickOnInterpreBttn();
		
		test.log(LogStatus.INFO, "Switch to tab 2 for interpretr 1 dashboard");
		pages.getLoginPage().switchToDesiredTab(2);
		
		test.log(LogStatus.INFO, "Click on request change button by interpreter 1");
		pages.getInterpreterBroadcastPage().verifyAndClickOnRequestChangeBttn();
		
		test.log(LogStatus.INFO, "Switch to tab 3 for interpretr 2 dashboard");
		pages.getLoginPage().switchToDesiredTab(3);
		
		test.log(LogStatus.INFO, "Click to confirm the request and verify request change buuton");
		pages.getInterpreterBroadcastPage().clickToConfirmTheRequestAndVerify();
		
		test.log(LogStatus.INFO, "Switch to tab 2 for interpretr 1 dashboard");
		pages.getLoginPage().switchToDesiredTab(2);
		
		test.log(LogStatus.INFO, "Verify start turn button on interpreter 1 dashboard when interpreter 2 has confirmed the request");
		pages.getInterpreterBroadcastPage().verifyStartTurnBttnOnInterpreter1_AfterConfermTheRequestByInterpreter2();
	
		test.log(LogStatus.PASS, "Streaming Test");

		MyScreenRecorder.stopRecording();
	}
	
	@Test(description = "To verify Streaming and Event display on Interpreter's end")
	public void VerifyToStreamOnBroadcast() throws Exception
	{
		test = extent.startTest("Streaming Test");
		test.log(LogStatus.INFO,"Entered User email, password and click on Login button");

		MyScreenRecorder.startRecording("verifyToStreamingOnBroadcast");

		pages.getLoginPage().loginToAkkaduApp("eventorganizer@akkadu-team.com", "qatestuser3");
		
		test.log(LogStatus.INFO, "Verify Home page afetr login");
		pages.getDashboardPage().verifyHomePageAfterLogin();
		
		test.log(LogStatus.INFO, "Click on edit event button");
		pages.getDashboardPage().editNewlyCreatedEvent();
		
		test.log(LogStatus.INFO, "Edit Event start time");
		pages.getDashboardPage().EditEventStartTime();
		
		test.log(LogStatus.INFO, "Click on stream button to stream the event");
		pages.getDashboardPage().verifyAndClickOnStreamBttn();
		
		test.log(LogStatus.INFO, "Verify and click on start button and verify after click on it");
		pages.getOrganizerBroadcastPage().verifyAndClickOnStartBttn();
		
		test.log(LogStatus.INFO, "Verify and click on listen to speakers button and verify colors of it");
		pages.getOrganizerBroadcastPage().verifyAndClickOnListenToSpeakersBttn();
		
		test.log(LogStatus.INFO, "Click on mute button and verify after click on it");
		pages.getOrganizerBroadcastPage().verifyAndClickOnMuteBttn();
		
		test.log(LogStatus.INFO, "Open new tab to login as a interpreter");
		pages.getLoginPage().openNewTabToLoginForInterpreter("interpreter1@akkadu-team.com", "qatestuser1", 1);
		
		test.log(LogStatus.INFO, "Verify welcome note after logged in as a interpreter");
	    pages.getInterpreterDashboardPage().verifyWelcomeNoteAfterLoggedInAsInterpreter();
	    
	    test.log(LogStatus.INFO, "Verify Event showing in interpreter's end");
	    pages.getInterpreterDashboardPage().VerifyEventStreaming();
	    
	    MyScreenRecorder.stopRecording();
	}
}
