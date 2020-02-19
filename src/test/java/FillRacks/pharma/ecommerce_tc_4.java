package FillRacks.pharma;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.CheckoutPage;

public class ecommerce_tc_4 extends base{

	// public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stubs

		@Test
		public void totalValidation() throws InterruptedException, IOException
		{
		 AndroidDriver<AndroidElement>driver=capabilities("GeneralStoreApp");
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
	     driver.hideKeyboard();
	     driver.findElement(By.xpath("//*[@text='Female']")).click();
	     driver.findElement(By.id("android:id/text1")).click();
	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
	     driver.findElement(By.xpath("//*[@text='Argentina']")).click();
	     // driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	     driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	     driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		    driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(4000);
		int count=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		double sum=0;
		CheckoutPage checkOutPage=new CheckoutPage(driver);
		
		for(int i=0;i<count;i++)
		{
		String amount1=	checkOutPage.productList.get(i).getText();
		double amount=getAmount(amount1);
		sum=sum+amount;//280.97+116.97.
		}
System.out.println(sum+"sum of products");

String total=checkOutPage.totalAmount.getText();

total= total.substring(1);
double totalValue=Double.parseDouble(total);
System.out.println(totalValue+"Total value of products");
Assert.assertEquals(sum, totalValue);  
//service.stop();




System.out.println("Test Executed");
		}

}
