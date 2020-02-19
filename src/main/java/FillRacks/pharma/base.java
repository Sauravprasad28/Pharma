

package FillRacks.pharma;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {

		public static  AndroidDriver<AndroidElement> capabilities(String appName) throws InterruptedException, IOException
		{
			String userDirectory = System.getProperty("user.dir");

			FileInputStream fis = new FileInputStream (userDirectory+"\\src\\main\\java\\FillRacks\\pharma\\global.properties");
			Properties prop = new Properties (); 
			prop.load(fis);
			
			
			
			AndroidDriver<AndroidElement>  driver;

		// TODO Auto-generated method stub
		
			 File appDir = new File("src");
		     File app = new File(appDir, (String) prop.get(appName));
		     DesiredCapabilities capabilities = new DesiredCapabilities();
		     
		     String Device = (String) prop.get("device");
		     capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Device);
		     capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		     capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
		     capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		     

		     driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;
		}
		
	}


