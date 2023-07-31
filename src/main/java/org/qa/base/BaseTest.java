package org.qa.base;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	public static WebDriver driver;
	static void initDriver() {
		String browser = Utility.readProperties("browser");
		
		if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
			System.out.println("New Browser" + browser);
		}
		else if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
	}
	public static void initBrowser() {
		initDriver();
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utility.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utility.IMPLICIT_WAIT_TIME));
		driver.get(Utility.readProperties("applicationURL"));
	}
	public static void quit() {
		driver.quit();
	}
}
