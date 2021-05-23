package jtracer;

import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class CommonMethods {
	
	public static void login(Robot robot,Screen screen) throws InterruptedException {
		
		MouseEvents.click(robot, 349, 189);
		screen.type("Summer03");
		Thread.sleep(2000);
		MouseEvents.click(robot, 310, 282);
		
	}
	
	public static void waitUntilDisplayed(Screen s,Pattern element,boolean flag) throws FindFailed {
		
		while(true) {
			
			s.wait(element, 30*60);
			
			if (s.exists(element) != null && flag == true ){
				
				s.hover(element);
				s.click(element);
				break;
				
				
			}else if(s.exists(element) != null && flag == false ){
				
				s.hover(element);
				break;
				
			}else
			{
				
				s.mouseMove(50,100);
				s.mouseMove(50,200);
				
			}
		}
		
		
	}
	
	
	public static String captureAndConvertText(String fileName, Point firstCoordinate, Point secondCoordinate,
			int enlargeImageByPercentage) throws AWTException, IOException, TesseractException {
		Rectangle rectangle = new Rectangle(firstCoordinate);
		rectangle.add(secondCoordinate);
		BufferedImage image = new Robot().createScreenCapture(rectangle);
		BufferedImage resizedImage = new BufferedImage(image.getWidth() * (100 + enlargeImageByPercentage) / 100,
				image.getHeight() * (100 + enlargeImageByPercentage) / 100, image.getType());
		Graphics2D graphics = (Graphics2D) resizedImage.getGraphics();
		graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		graphics.drawImage(image, 0, 0, resizedImage.getWidth(), resizedImage.getHeight(), null);
		ImageIO.write(resizedImage, "JPEG", new File("src/main/resources/imageGenerated/test.jpg"));
		
		
		Tesseract tesseract = CommonMethods.getTessaract();
		File file = new File("src/main/resources/imageGenerated/test.jpg");
		String result = tesseract.doOCR(file);
		return result;
		
	}
	
	public static Tesseract  getTessaract() {
		
		Tesseract instance = new Tesseract();
		instance.setDatapath("C:\\Users\\Gamer\\Downloads\\jtrack-master\\jtrack-master\\tess");
		instance.setLanguage("eng");
		instance.setHocr(false);
		return instance;

		
	}

}
