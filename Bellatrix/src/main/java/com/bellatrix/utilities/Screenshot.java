package com.bellatrix.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.bellatrix.stepDefination.HooksClass;

import io.cucumber.java.Scenario;

public class Screenshot  {
	public void takeScreenshotOnFailure(Scenario scenario) {

		if (scenario.isFailed()) {

		TakesScreenshot ts = (TakesScreenshot)HooksClass.driver;

		byte[] src = ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(src, "image/png", "screenshot");
		}

		}
	
}