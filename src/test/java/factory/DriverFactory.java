package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import utils.CommonUtils;

public class DriverFactory {
	
	static  WebDriver driver=null;

	public static WebDriver initializationBrowser(String browserName) {

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:/browserdrivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("Edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME_OUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
		
		return driver;

	}
	
	public static  WebDriver getDriver() {
		
		return driver;
	}

}
