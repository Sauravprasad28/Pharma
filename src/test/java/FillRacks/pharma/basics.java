package FillRacks.pharma;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.io.File;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HomePage;
import pageObjects.Preferences;
public class basics extends base{

	
	public static void main (String[] args) throws MalformedURLException {
	
	
	AndroidDriver<AndroidElement> driver=capabilities("emulator");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

HomePage h = new HomePage(driver);
	
	//You can call the methods or variables of the class with class object
    
    

  Preferences p = new Preferences(driver);
    // driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
    p.dependencies.click();
    driver.findElementById("android:id/checkbox").click();
    driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
    driver.findElementByClassName("android.widget.EditText").sendKeys(input);
   // driver.findElementsByClassName("android.widget.Button").get(1).click();
    p.buttons.get(1).click();

	}
}
