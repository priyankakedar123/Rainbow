package UtilPackage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.devtools.v85.page.model.ScreencastFrame;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Keywords.UIkeywords;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestListener implements ITestListener{
private static final Logger LOG =Logger.getLogger(TestListener.class);
	@Override
	public void onTestFailure(ITestResult result) {
		AShot ashot = new AShot();
		LOG.info("Test is failes take screen shot");
		ashot.shootingStrategy(ShootingStrategies.viewportPasting(200));
		Screenshot sc =ashot.takeScreenshot(UIkeywords.getInstance().driver);
		BufferedImage img = sc.getImage();
		String dir = System.getProperty("user.dir");
		try {
			ImageIO.write(img, "png", new File(dir+"ScreenShots/"+result.getName()+".png"));
			LOG.info("Screen shot is saved successfully");
		} catch (IOException e) {
	       LOG.error("Unable to take screenshot");
			e.printStackTrace();
		}
	}
}
