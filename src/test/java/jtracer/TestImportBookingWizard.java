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
import org.testng.annotations.Test;

import org.sikuli.script.Key;

import net.sourceforge.tess4j.TesseractException;

public class TestImportBookingWizard {

	private  Screen screen = new Screen();

	@Test
	public  void LoginToJTracker() throws FindFailed, InterruptedException, AWTException, TesseractException, IOException {

		Pattern importBtn = new Pattern(TestImportBookingWizard.class.getResource("/ImageData/import.PNG"));
		Pattern connect = new Pattern(TestImportBookingWizard.class.getResource("/ImageData/connect.PNG"));
		Pattern loggedIn = new Pattern(TestImportBookingWizard.class.getResource("/ImageData/jacketMgmt.PNG"));
		Pattern shoesCheckbox = new Pattern(TestImportBookingWizard.class.getResource("/ImageData/shoes.PNG"));
		Pattern itemAddedDialogue = new Pattern(TestImportBookingWizard.class.getResource("/ImageData/itemAdded.PNG"));
		Pattern itemAddedOk = new Pattern(TestImportBookingWizard.class.getResource("/ImageData/itemAddedOk.PNG"));
		Pattern issue = new Pattern(TestImportBookingWizard.class.getResource("/ImageData/issue.PNG"));
		

		App.open("C:\\jtracker\\jailtracker.rdp");
		// Pattern connect = new Pattern("G:\\sikuli images\\connect.PNG");
		Thread.sleep(2000);
		Robot robot = new Robot();
		
		
		if(screen.exists(connect) != null) {
			
			screen.click(connect);
			//CommonMethods.waitUntilDisplayed(screen, loggedIn,false);
			
		}
		
		//Log in to JTracker
		if(screen.exists(loggedIn) == null) {
			
		try {
		CommonMethods.login(robot, screen);
		CommonMethods.waitUntilDisplayed(screen, loggedIn, false);
		
		}catch(Exception e) {
			
			
			
		}
		
		}
		
		//Click on offender module tab to access import icon
		MouseEvents.click(robot,91, 37);

		
		String data = CommonMethods.captureAndConvertText("test",new Point(1340, 1018), new Point(1435,1030), 100);
		System.out.println("data found " + data);
		//Click on the Active Agency drop-down and select Active Agency.
		if(data != "Lincoln Hills Schoal") {
			
			MouseEvents.click(robot,1529, 1024);
			screen.type("Lincoln Hills School");
			screen.type(Key.ENTER);
			
			
		}
		
		
		//Click on the Import icon
		MouseEvents.click(robot,47, 107);


		//maximize search window
		MouseEvents.click(robot,1414, 154);
		
		//click on search
		MouseEvents.click(robot,1642, 148);
		
		if(screen.exists(issue) != null) {
			
			Assert.fail();
			
		}
		
		MouseEvents.click(robot,204, 798);

		
		//click new booking from selected import
		MouseEvents.click(robot,1405, 1014);
		
		//click on confirm agency ok
		MouseEvents.click(robot,915, 538);
		
		
		
		//Click on the drop-down arrow on the Wears Glasses and select Yes .
		MouseEvents.click(robot,155, 420);
		screen.type("Yes");
		screen.type(Key.ENTER);
		
		//Click the "next" button
		MouseEvents.click(robot,1858, 989);
		
		
		
		//Enter mandatory data for Legal Status, Status Type, and Start Date, and click the Save Button.
		MouseEvents.click(robot,255, 231);
		screen.type("Type 1");
		screen.type(Key.ENTER);
		
		
		//select status type : New Commitment
		MouseEvents.click(robot,519, 233);
		screen.type("New Commitment");
		screen.type(Key.ENTER);

		
		//start date : 5/4/2021
		MouseEvents.click(robot,605, 233);
		screen.type("05/04/2021");
		screen.type(Key.ENTER);

		
		//Click the "save" button
		MouseEvents.click(robot,814, 224);
	
		
		//Click the "next" button
		MouseEvents.click(robot,1858, 989);
		
	
		
		//Enter mandatory data for the Search Reason, Search Type, and Comments
		//search reason : Intake
		MouseEvents.click(robot,1343, 341);
		screen.type("Intake");
		screen.type(Key.ENTER);
		
		
		//search type : Strip Search
		MouseEvents.click(robot,1341, 385);
		screen.type("Strip Search");
		screen.type(Key.ENTER);

		
		//search comments :  comments
		MouseEvents.click(robot,1450, 308);
		screen.type("TC 01 - JTracker - Import/Booking WIZARD");
		screen.type(Key.ENTER);


		//Click the "next" button
		MouseEvents.click(robot,1858, 989);
		
		
		
		//Record personal property (by item category) to be stored for Youth while living at DJC facility.	
		screen.click(shoesCheckbox);
		
		
		//description :Red/Black Nike Air Jordans, Size 11
		MouseEvents.click(robot,317, 551);
		screen.type("Red/Black Nike Air Jordans, Size 11");
		
		//Reason Recieved :Youth wanted to keep them like new until he gets released.
		MouseEvents.click(robot,187, 701);
		screen.type("Youth wanted to keep them like new until he gets released.");

		
		//Storage Location :LHS/CLS Storeroom
		MouseEvents.click(robot,653, 701);
		screen.type("LHS/CLS Storeroom");
		
		
		
		//Click the add button
		MouseEvents.click(robot,1854, 701);
		
		
		if(screen.exists(itemAddedDialogue) != null) {
			
			screen.click(itemAddedOk);
			
		}

		
		String recieverName = CommonMethods.captureAndConvertText("test",new Point(877, 463), new Point(970,478), 100);
		
		//Assert.assertEquals(recieverName,"Vella, Sreenivasulu");
		
		
		//Click the "next" button SKIPPING IMAGE SECTION
		MouseEvents.click(robot,1858, 989);
		
		
		//Click the "next" button
		MouseEvents.click(robot,1858, 989);
				
		
		//Click the Add Contacts button in the upper left hand corner of the screen.
		MouseEvents.click(robot,85, 223);
		
		//Add contact details click on guardian dropdown
		MouseEvents.click(robot,319, 172);
		screen.type("Yes");
		screen.type(Key.ENTER);
		
		
		//enter first name
		MouseEvents.click(robot,697, 327);
		screen.type("Lydia");
		
		//enter last name
		MouseEvents.click(robot,991, 332);
		screen.type("Lancaster");
		
		
		//Add contact details click on guardian dropdown
		MouseEvents.click(robot,595, 328);
		screen.type("Mother");
		screen.type(Key.ENTER);
		
		
		//Add relation details mother
		MouseEvents.click(robot,1311, 328);
		screen.type("Mother");
		screen.type(Key.ENTER);
		
		//Add emergency contact as yes
		MouseEvents.click(robot,594, 366);
		screen.type("Yes");
		screen.type(Key.ENTER);
		
		
		//click on save to save all data
		MouseEvents.click(robot,1388, 743);
		
		
		//Click the "next" button
		MouseEvents.click(robot,1858, 989);



	}
	
	
	

}
