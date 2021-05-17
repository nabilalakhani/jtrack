package jtracer;

import java.awt.Robot;
import java.awt.event.InputEvent;

public class MouseEvents {

	public static void click(Robot robot, int x, int y) throws InterruptedException {

		robot.mouseMove(x, y);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(2000);

	}

}
