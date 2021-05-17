package jtracer;

import java.awt.Robot;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import net.sourceforge.tess4j.Tesseract;

public class CommonMethods {
	
	public static void login(Robot robot,Screen screen) throws InterruptedException {
		
		MouseEvents.click(robot, 349, 189);
		screen.type("Summer03");
		Thread.sleep(2000);
		MouseEvents.click(robot, 328, 325);
		
	}
	
	public static void waitUntilDisplayed(Screen s,Pattern element) throws FindFailed {
		
		while(true) {
			
			s.wait(element, 30*60);
			
			if (s.exists(element) != null){
				
				s.hover(element);
				s.click(element);
				
			}else {
				
				s.mouseMove(50,100);
				s.mouseMove(50,200);
				
			}
		}
		
		
	}
	
	public static Tesseract  getTessaract() {
		
		Tesseract instance = new Tesseract();
		instance.setDatapath("C:\\Users\\Gamer\\eclipse-workspace\\JTracker\\tess");
		instance.setLanguage("eng");
		instance.setHocr(false);
		return instance;

		
	}

}
