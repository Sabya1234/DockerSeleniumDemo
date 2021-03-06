package Selenium.DockerSeleniumGridDemo;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	 protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	 //for execution on selenium 4 grid on docker 
	 String node="http://localhost:4444";

	    @BeforeMethod
	   // @Parameters(value = {"browser"})
	    public void setupTest() throws MalformedURLException {
	    	String browser=System.getProperty("nodeSelection");
	    	System.out.println("Selected node :"+browser);
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("browserName", browser);
	        //capabilities.setCapability("enableVNC", true);
	        driver.set(new RemoteWebDriver(new URL(node), capabilities));
	        
	        //For execution on grid 3 use below syntax to conencto hub url for execution of scripts
	        //driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities));
	    }

	    public WebDriver getDriver() {
	        return driver.get();
	    }

	    @AfterMethod
	    public void tearDown() {
	        getDriver().quit();
	    }

	    @AfterClass
	    void terminate() {
	        driver.remove();
	    }
	/*private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	

	
	 * Intialize webdriver in this Method
	 *
	 *//*
	@BeforeMethod
	@Parameters(value = { "browser" })
	public void setUpTest(String browser) {
		
		switch(browser)
		{
		case "chrome" :
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			break;
		
		
		case "firefox": 
		  WebDriverManager.firefoxdriver().setup();
		   driver.set(new FirefoxDriver());
		   break;
		   
		case "edge":
			
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
			break;
			
		default:
			  System.out.println("Invalid Broswer choice");
		}
			   

	}

	public WebDriver getDriver() {
		return driver.get();
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

	@AfterClass

	public void dispose() {
		driver.remove();
	}
*/
	/*public String getScreenshotPath(String TestCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destPath = System.getProperty("user.dir") + "\\Screenshot\\" + TestCaseName + ".png";
		File file = new File(destPath);
		//FileUtils.copyFile(source, file);
		return destPath;*/

	//}

}
