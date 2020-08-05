package COMMONFUNCTIONS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class BASIC_UTILITIES {

	static WebDriver driver;

	public BASIC_UTILITIES(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void launchBrowser(WebDriver driver) {

		System.setProperty("webdriver.chrome.driver", "E:\\New folder\\Practice\\KICKOFF\\DRIVERS\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	public void browserActions(WebDriver driver) {

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	}

	public void exitBrowser(WebDriver driver) {

		driver.close();
	}

	public String dataFromPropertiesFile(String inputValue) throws IOException {

		Properties prop = new Properties();
		File f = new File("E:\\New folder\\Practice\\KICKOFF\\DATA\\config.properties");
		FileInputStream fis = new FileInputStream(f);

		prop.load(fis);
		String value = prop.getProperty(inputValue);
		System.out.println(value);

		return value;
	}

}
