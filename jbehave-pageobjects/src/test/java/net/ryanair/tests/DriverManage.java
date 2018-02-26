package net.ryanair.tests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManage {

	protected static WebDriver driver;

	public DriverManage() {
		System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
		driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
}
