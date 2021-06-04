package com.appium.swiggy.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.appium.swiggy.util.TestUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;



public class TestBase {
	//public static WebDriver driver;
	public static Properties prop;
	//public  static EventFiringWebDriver e_driver;
	//public static WebEventListener eventListener;
	
	public static AppiumDriver<MobileElement> driver;
	
	//Constructor - call prop file
//	public TestBase() {
//			
//		try {
//			
//			prop=new Properties();
//			FileInputStream fs= new FileInputStream(
//					"/Users/ADMIN/eclipse-workspace/SwiggyAppiumProject/src/main/java/com/appium/swiggy/config/config.properties");
//			//SwiggyAppiumProject\src\main\java\com\appium\swiggy\config\config.properties
//			
//			prop.load(fs);
//		}catch(FileNotFoundException e) {
//			e.printStackTrace();	
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//	}	
	// Initialization
	public static void Initialization() {	
		
		try {
		DesiredCapabilities cap= new DesiredCapabilities();
		//cap.setCapability("deviceName", "Redmi Note 4");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0 NRD90M");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 4");
		cap.setCapability(MobileCapabilityType.UDID, "8ff2ccba0104");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		//cap.setCapability("appPackage", "io.appium.android.apis");
		
		URL url= new URL("http://127.0.0.1:4723/wd/hub");
		
		driver=new AppiumDriver<MobileElement>(url, cap);
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
//		String browserName = prop.getProperty("browser");
//		
//		if (browserName.equals("chrome")) {	
//			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
//			driver = new ChromeDriver();
//		}
		
		//e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
//		eventListener = new WebEventListener();
//		e_driver.register(eventListener);
//		driver = e_driver;
		
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait, TimeUnit.SECONDS);
//		
//		driver.get(prop.getProperty("myurl"));
				
	}


