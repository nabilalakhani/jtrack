package jtracer;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import net.sourceforge.tess4j.TesseractException;

public class app {

	public static void main(String[] args) throws TesseractException, AWTException, IOException, InterruptedException, FindFailed {
		// TODO Auto-generated method stub

		Screen screen = new Screen();
		Pattern fileInputTextBox = new Pattern("C:\\temp\\settings.PNG");
		screen.click(fileInputTextBox);


	}

	public void m1() throws IOException, AWTException, InterruptedException {

		

		Thread.sleep(3000);
		Robot robot = new Robot();
		String format = "jpg";
		String fileName = "PartialScreenshot." + format;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle captureRect = new Rectangle(460,491,47,25);
		BufferedImage screenFullImage = robot.createScreenCapture(captureRect);
		ImageIO.write(screenFullImage, format, new File(fileName));
		 robot = new Robot();

		// Capture a particular area on the screen

		int x = 37;

		int y = 598;

		int width = 100;

		int height = 35;

		Rectangle area = new Rectangle(x, y, width, height);

		BufferedImage bufferedImage = robot.createScreenCapture(area);

		// Write generated image to a file

		try {

			// Save as PNG

			File file = new File("screenshot_small.png");

			ImageIO.write(bufferedImage, "png", file);

		} catch (IOException e) {

			System.out.println("Could not save small screenshot " + e.getMessage());

		}

		// Capture the whole screen

		area = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

		bufferedImage = robot.createScreenCapture(area);

		// Write generated image to a file

		// Save as PNG

		File file = new File("screenshot_full.png");

		ImageIO.write(bufferedImage, "png", file);

	}

}
