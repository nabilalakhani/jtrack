package jtracer;

import java.net.URL;
import java.time.LocalDate;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Location;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class TestM {

	private static WindowsDriver jailtrackerapp = null;
	private static WindowsDriver desktop = null;

	public static String getDate() {
		LocalDate date = LocalDate.now();
		return date.toString();
	}

	@Test
	public static void setUp() throws FindFailed, InterruptedException {
//		try {
//			DesiredCapabilities capabilities = new DesiredCapabilities();
//			capabilities.setCapability("app", "C:\\Users\\Gamer\\Downloads\\jtrack.rdp");
//
//			// appCapabilities.setCapability("app",
//			// "C:\\Users\\LENOVO\\eclipse-workspace\\WinAppDriverSample\\testdata\\VBALogin.xlsm");
//			capabilities.setCapability("platformName", "Windows");
//			capabilities.setCapability("deviceName", "WindowsPC");
//			// capabilities.setCapability("app", "Root");
//
//			// capabilities.setCapability("platformName", "Windows");
//			// capabilities.setCapability("deviceName", "WindowsPC");
//
//			WindowsDriver jailtrackerapp = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
//			Thread.sleep(5000);
//			jailtrackerapp.findElementByName("File");
//
//		} catch (Exception e) {
//
//				DesiredCapabilities capabilities = new DesiredCapabilities();
//				capabilities.setCapability("app", "Root");
//				jailtrackerapp = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), capabilities);
//
//				String topWindow = desktop.findElementByClassName("RAIL_WINDOW").getAttribute("NativeWindowHandle");
//				int MAWinHandleInt = Integer.parseInt(topWindow);
//				String MAWinHandleHex = Integer.toHexString(MAWinHandleInt);
//
//				DesiredCapabilities caps = new DesiredCapabilities();
//				caps.setCapability("appTopLevelWindow", MAWinHandleHex);
//				session = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), caps);
//
//			
//
//		}
//			Set<String> win = jailtrackerapp.getWindowHandles();
//			jailtrackerapp.switchTo().window(win.toString());
//			jailtrackerapp.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Screen s = new Screen();
		
		App.open("C:\\Users\\Gamer\\Downloads\\jtrack.rdp");
		Pattern connect = new Pattern("G:\\sikuli images\\connect.PNG");
		Pattern password = new Pattern("G:\\sikuli images\\password.PNG");
		Pattern ok = new Pattern("G:\\sikuli images\\ok.PNG");
		Pattern importBtn = new Pattern("G:\\sikuli images\\import.PNG");

		s.click(connect);
		try {
		//s.wait(password, 30*60);
		s.type(password, "Summer03");
		s.click(ok);
		}catch(Exception e) {
			
			
		}
		
		CommonMethods.waitUntilDisplayed(s, importBtn,true);


	

	}

	public void cleanApp() throws FindFailed, InterruptedException {
		jailtrackerapp.quit();
		setUp();
	}

	public void tearDown() {
		jailtrackerapp.quit();
	}

	public void ImportBooking() throws FindFailed, InterruptedException {
		Screen s = new Screen();
		Pattern connect = new Pattern("G:\\sikuli images\\connect.PNG");
		Pattern password = new Pattern("G:\\sikuli images\\password.PNG");
		Pattern ok = new Pattern("G:\\sikuli images\\ok.PNG");
		Pattern importBtn = new Pattern("G:\\sikuli images\\import.PNG");

		s.click(connect);
		s.type("Summer03");
		s.click(ok);
		Thread.sleep(30000);
		s.click(importBtn);

	}
	// jailtrackerapp.findElementByName("Connect").click();
	// jailtrackerapp.findElementByName("About Notepad").click();
	// jailtrackerapp.findElementByName("OK").click();

	public void sendTestText() throws FindFailed {
		Screen s = new Screen();
		Pattern fileInputTextBox = new Pattern("G:\\sikuli images\\import.PNG");
		s.click(fileInputTextBox);

	}

	public void pressTimeAndDateButton() {
		jailtrackerapp.findElementByName("Edit").click();
		jailtrackerapp.findElementByAccessibilityId("26").click();
		Assert.assertNotNull(jailtrackerapp.findElementByClassName("Edit"));
		jailtrackerapp.findElementByClassName("Edit").clear();
	}

}
