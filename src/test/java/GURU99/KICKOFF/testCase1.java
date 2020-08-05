package GURU99.KICKOFF;

import org.testng.annotations.Test;

import COMMONFUNCTIONS.BASIC_UTILITIES;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class testCase1 {

	static WebDriver driver;
	BASIC_UTILITIES a = new BASIC_UTILITIES(driver);
	LOGIN l = new LOGIN(driver);

	@BeforeClass
	public void beforeClass() {

		a.launchBrowser(driver);
	}

	@BeforeMethod
	public void beforeMethod() {

		a.browserActions(driver);
	}

	@Test
	public void login() throws IOException {

		String URL = a.dataFromPropertiesFile("url");
		String username = a.dataFromPropertiesFile("username");
		String password = a.dataFromPropertiesFile("password");

		l.login(driver, URL, username, password);

	}

	@AfterMethod
	public void afterMethod() {

	//	driver.manage().deleteAllCookies();
	}

	@AfterClass
	public void afterClass() {

		a.exitBrowser(driver);
	}

}
