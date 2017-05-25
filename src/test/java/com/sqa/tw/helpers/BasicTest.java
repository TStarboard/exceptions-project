package com.sqa.tw.helpers;

import java.util.concurrent.*;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.testng.annotations.*;

public abstract class BasicTest extends Core {

	public BasicTest(String baseUrl) {
		super(baseUrl, null);
	}

	@BeforeClass(enabled = true)
	public void setUp() throws Exception {
		setDriver(new FirefoxDriver());
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getDriver().get(getBaseUrl());
	}

	@BeforeClass(enabled = false)
	public void setUpChrome() throws Exception {
		// Set property for specific drivers
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		// Initialize the specific driver to run test
		setDriver(new ChromeDriver());
		// Set baseURL for the website you will be testing
		// this.baseUrl = "http://www.ebay.com/";
		// Set any properties for the driver, such as setting an implicit wait
		// for 30 seconds
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getDriver().get(getBaseUrl());
	}

	@BeforeClass(enabled = false)
	public void setUpIE() throws Exception {
		System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
		setDriver(new InternetExplorerDriver());
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getDriver().get(getBaseUrl());
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		getDriver().quit();
	}
}