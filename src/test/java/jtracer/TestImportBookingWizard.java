package jtracer;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.sikuli.script.Key;

import net.sourceforge.tess4j.TesseractException;

public class TestImportBookingWizard {

	private Screen screen = new Screen();
	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeTest
	public void startReport(){
		//ExtentReports(String filePath,Boolean replaceExisting) 
		//filepath - path of the file, in .htm or .html format - path where your report needs to generate. 
		//replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
		//True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
		//False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/JailTrackerExtentReport.html", true);
		//extent.addSystemInfo("Environment","Environment Name")
		extent
                .addSystemInfo("Host Name", "Jail Tracker App")
                .addSystemInfo("Environment", "Automation Testing")
                .addSystemInfo("User Name", "Sreenivas");
                //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
                //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
                extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
	

	@Test
	public void LoginToJTracker()
			throws FindFailed, InterruptedException, AWTException, TesseractException, IOException {

		logger = extent.startTest("Test Import booking wizard");

		
		Pattern importBtn = new Pattern(TestImportBookingWizard.class.getResource("/ImageData/import.PNG"));
		Pattern connect = new Pattern(TestImportBookingWizard.class.getResource("/ImageData/connect.PNG"));
		Pattern loggedIn = new Pattern(TestImportBookingWizard.class.getResource("/ImageData/jacketMgmt.PNG"));
		Pattern shoesCheckbox = new Pattern(TestImportBookingWizard.class.getResource("/ImageData/shoes.PNG"));
		Pattern itemAddedDialogue = new Pattern(TestImportBookingWizard.class.getResource("/ImageData/itemAdded.PNG"));
		Pattern itemAddedOk = new Pattern(TestImportBookingWizard.class.getResource("/ImageData/itemAddedOk.PNG"));
		Pattern issue = new Pattern(TestImportBookingWizard.class.getResource("/ImageData/issue.PNG"));
		Pattern assignableBed = new Pattern(TestImportBookingWizard.class.getResource("/ImageData/assignableBed.PNG"));
		Pattern legalStatusLbl = new Pattern(
				TestImportBookingWizard.class.getResource("/ImageData/legalStatusLbl.PNG"));
		Pattern personSearchLbl = new Pattern(
				TestImportBookingWizard.class.getResource("/ImageData/personSearchLbl.PNG"));
		Pattern personalPropertyLbl = new Pattern(
				TestImportBookingWizard.class.getResource("/ImageData/personalPropertyLbl.PNG"));

		App.open("C:\\Users\\Gamer\\Downloads\\jtrack-master\\jtrack-master\\src\\main\\resources\\jtracker.rdp");
		// Pattern connect = new Pattern("G:\\sikuli images\\connect.PNG");
		Thread.sleep(2000);
		Robot robot = new Robot();

		if (screen.exists(connect) != null) {

			screen.click(connect);
			// CommonMethods.waitUntilDisplayed(screen, loggedIn,false);

		}

		// Log in to JTracker
		if (screen.exists(loggedIn) == null) {

			try {
				CommonMethods.login(robot, screen);
				CommonMethods.waitUntilDisplayed(screen, loggedIn, false);

			} catch (Exception e) {

			}

		}

		// Click on offender module tab to access import icon
		MouseEvents.click(robot, 91, 37);

		String data = CommonMethods.captureAndConvertText("test", new Point(1340, 1018), new Point(1435, 1030), 100);
		System.out.println("data found " + data);
		// Click on the Active Agency drop-down and select Active Agency.
		if (data != "Lincoln Hills Schoal") {

			MouseEvents.click(robot, 1529, 1024);
			screen.type("Lincoln Hills School");
			screen.type(Key.ENTER);

		}

		// Click on the Import icon
		MouseEvents.click(robot, 47, 107);

		// maximize search window
		MouseEvents.click(robot, 1414, 154);

		// click on search
		MouseEvents.click(robot, 1642, 148);

		MouseEvents.click(robot, 204, 798);

		// click new booking from selected import
		MouseEvents.click(robot, 1405, 1014);

		// click on confirm agency ok
		MouseEvents.click(robot, 915, 538);

		// Click on the drop-down arrow on the Wears Glasses and select Yes .
		MouseEvents.click(robot, 155, 420);
		screen.type("Yes");
		screen.type(Key.ENTER);

		// Click the "next" button
		MouseEvents.click(robot, 1858, 989);

		// check if legal status page is displayed
		if (screen.exists(legalStatusLbl) == null) {

			Assert.fail();
			logger.log(LogStatus.FAIL, "Test Case (failed as Legal status page was not loaded");


		}

		// Enter mandatory data for Legal Status, Status Type, and Start Date, and click
		// the Save Button.
		MouseEvents.click(robot, 255, 231);
		screen.type("Type 1");
		screen.type(Key.ENTER);

		// select status type : New Commitment
		MouseEvents.click(robot, 519, 233);
		screen.type("New Commitment");
		screen.type(Key.ENTER);

		// start date : 5/4/2021
		MouseEvents.click(robot, 605, 233);
		screen.type("05/04/2021");
		screen.type(Key.ENTER);

		// Click the "save" button
		MouseEvents.click(robot, 814, 224);

		// Click the "next" button
		MouseEvents.click(robot, 1858, 989);

		// check if person search page is displayed
		if (screen.exists(personSearchLbl) == null) {

			Assert.fail();
			logger.log(LogStatus.FAIL, "Test Case (failed as person search page was not loaded");


		}

		// Enter mandatory data for the Search Reason, Search Type, and Comments
		// search reason : Intake
		MouseEvents.click(robot, 1343, 341);
		screen.type("Intake");
		screen.type(Key.ENTER);

		// search type : Strip Search
		MouseEvents.click(robot, 1341, 385);
		screen.type("Strip Search");
		screen.type(Key.ENTER);

		// search comments : comments
		MouseEvents.click(robot, 1450, 308);
		screen.type("TC 01 - JTracker - Import/Booking WIZARD");
		screen.type(Key.ENTER);

		// Click the "next" button
		MouseEvents.click(robot, 1858, 989);

		// check if personal property page is displayed
		if (screen.exists(personalPropertyLbl) == null) {

			Assert.fail();
			logger.log(LogStatus.FAIL, "Test Case (failed as personal property page was not loaded");

		}

		// Record personal property (by item category) to be stored for Youth while
		// living at DJC facility.
		screen.click(shoesCheckbox);

		// description :Red/Black Nike Air Jordans, Size 11
		MouseEvents.click(robot, 317, 551);
		screen.type("Red/Black Nike Air Jordans, Size 11");

		// Reason Recieved :Youth wanted to keep them like new until he gets released.
		MouseEvents.click(robot, 187, 701);
		screen.type("Youth wanted to keep them like new until he gets released.");

		// Storage Location :LHS/CLS Storeroom
		MouseEvents.click(robot, 653, 701);
		screen.type("LHS/CLS Storeroom");

		// Click the add button
		MouseEvents.click(robot, 1854, 701);

		if (screen.exists(itemAddedDialogue) == null) {

			screen.click(itemAddedOk);

		}

		String recieverName = CommonMethods.captureAndConvertText("test", new Point(877, 463), new Point(970, 478),
				100);

		// Assert.assertEquals(recieverName,"Vella, Sreenivasulu");

		// Click the "next" button SKIPPING IMAGE SECTION
		MouseEvents.click(robot, 1858, 989);

		// Click the "next" button
		MouseEvents.click(robot, 1858, 989);

		// Click the Add Contacts button in the upper left hand corner of the screen.
		MouseEvents.click(robot, 85, 223);

		// Add contact details click on guardian dropdown
		MouseEvents.click(robot, 319, 172);
		screen.type("Yes");
		screen.type(Key.ENTER);

		// enter first name
		MouseEvents.click(robot, 697, 327);
		screen.type("Lydia");

		// enter last name
		MouseEvents.click(robot, 991, 332);
		screen.type("Lancaster");

		// Add contact details click on guardian dropdown
		MouseEvents.click(robot, 595, 328);
		screen.type("Mother");
		screen.type(Key.ENTER);

		// Add relation details mother
		MouseEvents.click(robot, 1311, 328);
		screen.type("Mother");
		screen.type(Key.ENTER);

		// Add emergency contact as yes
		MouseEvents.click(robot, 594, 366);
		screen.type("Yes");
		screen.type(Key.ENTER);

		// click on save to save all data
		MouseEvents.click(robot, 1388, 743);

		// Click the "next" button
		MouseEvents.click(robot, 1858, 989);

		// click on assignable bed
		while (screen.exists(assignableBed) == null) {

			// scroll down to find assignable bed
			MouseEvents.click(robot, 308, 521);
			if (screen.exists(assignableBed) != null) {

				screen.click(assignableBed);

			}

		}

		// click on bed info
		MouseEvents.click(robot, 343, 303);

		// Click on reason for move
		MouseEvents.click(robot, 391, 910);
		screen.type("Intake");
		screen.type(Key.ENTER);

		// click on assign button
		MouseEvents.click(robot, 668, 644);

		// Click the "next" button
		MouseEvents.click(robot, 1858, 989);

		// Click the "finish" button
		MouseEvents.click(robot, 1301, 989);
		
		

	}

	
	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
		// ending test
		//endTest(logger) : It ends the current test and prepares to create HTML report
		extent.endTest(logger);
	}
	
	
	@AfterTest
	public void endReport(){
		// writing everything to document
		//flush() - to write or update test information to your report. 
                extent.flush();
                //Call close() at the very end of your session to clear all resources. 
                //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
                //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
                //Once this method is called, calling any Extent method will throw an error.
                //close() - To close all the operation
                extent.close();
    }
	
}
