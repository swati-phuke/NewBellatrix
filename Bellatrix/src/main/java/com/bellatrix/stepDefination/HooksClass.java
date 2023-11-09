package com.bellatrix.stepDefination;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.bellatrix.config.Configration;
import com.bellatrix.custumexception.InvalidBrowserError;
import com.bellatrix.utilities.FileUtil;
import com.bellatrix.utilities.Screenshot;

import groovy.util.ConfigBinding;
import groovyjarjarantlr4.v4.parse.ANTLRParser.throwsSpec_return;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class HooksClass {
Screenshot screenshot = new Screenshot();
	private static final Logger LOG = Logger.getLogger(HooksClass.class);
	public Configration config;

	public static RemoteWebDriver driver;

	public static RemoteWebDriver getDriver() {
		return driver;
	}

	@Before
	public  void SetUp() throws FileNotFoundException, Exception {
		config = new Configration();
		String browserName = config.getBrowserName();
		if(config.getExicutionMode().equalsIgnoreCase("local")) {
			if(browserName.equalsIgnoreCase("Chrome")) {
				driver= new ChromeDriver();
			}else if(browserName.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			}else {
			throw new InvalidBrowserError(config.getBrowserName());
			}
				
			}else {
				LOG.info("Executing suite on grid");
				FirefoxOptions  firefoxOptions = new FirefoxOptions();
				//chromeOption.setcapatility (browserVersion,118);
				firefoxOptions.setCapability("patformName", "windows");
				firefoxOptions .setCapability("se:name", "my simple test");
				firefoxOptions.setCapability("se:sample MetadataValue", "Sample meta data value");
				driver= new RemoteWebDriver(new URL("http://192.168.43.217:4444"),firefoxOptions);
			}
			
	           // driver.get(config.getAppURl());
	            driver.manage().window().maximize();
	          
	}
	@After
	public void takeScreenShotOnTestFailure(Scenario scenario)throws IOException{

		try {
		if(scenario.isFailed())
		{
		Date date= new Date();
		
		AShot ashot =new AShot();

		BufferedImage img = ashot.shootingStrategy(ShootingStrategies.viewportPasting(4000))
		.takeScreenshot(HooksClass.driver).getImage();
		String baseDir= System.getProperty("user.dir");
		ImageIO.write(img,"png",
		new File(baseDir + "src/main/resources/FailedTestScreenShot/.png" +date));
		}
		}
		catch (IOException e)
		{
		e.printStackTrace();
		}
		}

	@After
	public void tearDown() {
		driver.quit();
	}

}
