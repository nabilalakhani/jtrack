package jtracer;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class app {

	public static void main(String[] args) throws TesseractException {
		// TODO Auto-generated method stub
		
		
		CommonMethods.getTessaract();
		Tesseract tesseract = CommonMethods.getTessaract();
		
		File file = new File("G:\\file.JPG");
		String result = tesseract.doOCR(file);
		System.out.println(result.toString());
	}
	

}
