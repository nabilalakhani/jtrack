package jtracer;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TestImportBookingWizard {

	private  Screen screen = new Screen();

	@Test
	public  void LoginToJTracker() throws FindFailed, InterruptedException, AWTException, TesseractException {

		Pattern importBtn = new Pattern(TestImportBookingWizard.class.getResource("/ImageData/import.PNG"));
		

		App.open("C:\\Users\\Gamer\\Downloads\\jtrack.rdp");
		// Pattern connect = new Pattern("G:\\sikuli images\\connect.PNG");
		Thread.sleep(2000);
		Robot robot = new Robot();
		
		try {
		CommonMethods.login(robot, screen);
		
		}catch(Exception e) {
			
			
			
		}

		while (true) {

			screen.wait(importBtn, 30 * 60);

			if (screen.exists(importBtn) != null) {

				screen.hover(importBtn);
				screen.click(importBtn);
				break;

			} else {

				screen.mouseMove(50, 100);
				screen.mouseMove(50, 200);

			}
		}
		MouseEvents.click(robot,1137, 12);

		MouseEvents.click(robot,1165, 148);
		MouseEvents.click(robot,1012, 705);
		MouseEvents.click(robot,635, 386);
		MouseEvents.click(robot,155, 420);
	
		
		Tesseract tesseract = CommonMethods.getTessaract();
		File file = new File("/Users/shubham/Desktop/tess4j.jpg");
		String result = tesseract.doOCR(file);
		System.out.println(result);
	}
	
	

}
