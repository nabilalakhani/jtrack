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

import net.sourceforge.tess4j.Tesseract;

public class image {

	public static void capture(String fileName, Point firstCoordinate, Point secondCoordinate,
			int enlargeImageByPercentage) throws AWTException, IOException {
		Rectangle rectangle = new Rectangle(firstCoordinate);
		rectangle.add(secondCoordinate);
		BufferedImage image = new Robot().createScreenCapture(rectangle);
		BufferedImage resizedImage = new BufferedImage(image.getWidth() * (100 + enlargeImageByPercentage) / 100,
				image.getHeight() * (100 + enlargeImageByPercentage) / 100, image.getType());
		Graphics2D graphics = (Graphics2D) resizedImage.getGraphics();
		graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		graphics.drawImage(image, 0, 0, resizedImage.getWidth(), resizedImage.getHeight(), null);
		ImageIO.write(resizedImage, "JPEG", new File(fileName));
	}

	public static void main(String[] args) throws Exception {
		Thread.sleep(5000);
		capture("test.jpg",new Point(608, 517), new Point(654,531), 100);
		Tesseract tesseract = CommonMethods.getTessaract();
		File file = new File("src/main/resources/imageGenerated/test.jpg");
		String result = tesseract.doOCR(file);
		System.out.println(result);
	}

}
