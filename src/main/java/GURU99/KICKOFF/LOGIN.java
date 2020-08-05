package GURU99.KICKOFF;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import COMMONFUNCTIONS.BASIC_UTILITIES;

public class LOGIN {

	static WebDriver driver;
	
	public LOGIN(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login(WebDriver driver, String url, String username, String password) throws IOException {

		driver.get(url);

		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();

		String homePageActualTitle = driver.getTitle();

		if (homePageActualTitle.equals("Guru99 Bank Manager HomePage")) {
			System.out.println("successfully entered into home page");
		} else {
			System.out.println("Something went wrong, Not able to enter into home page");
			Assert.fail();
		}

	}

}
