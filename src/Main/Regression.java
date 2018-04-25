package Main;

import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import Assertions.AssertionAvailable;
import Page.GetStartH;
import Page.RegistrationF;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Regression {
	
	static MobileDriver<MobileElement> driver;

	AssertionAvailable objAssert=new AssertionAvailable();
	GetStartH objHomePage= new GetStartH(driver);
	RegistrationF objRegForm= new RegistrationF(driver);
	
	String userName = " ";//Your UserName of BrowserStack
	String accessKey = " ";//Your access Key of BrowserStack
	String AndroidAppURL= " ";// Your Android App URL
	String iOSAppURL=" ";// Your iOS App URL
	
	DesiredCapabilities caps = new DesiredCapabilities();
	
	@BeforeSuite
	public void setupMyAppium() throws Exception
	{
		Scanner sc=new Scanner(System.in); 
		System.out.println("Enter your testing platform 'ios' or 'android'");  
		   String platform=sc.next();
		   switch(platform)
		   {
		   case "ios":
			    System.out.println("IOS capabilities Running");
			   
			    caps.setCapability("os", "ios");
			    caps.setCapability("os_version", "10.3"); 
			    caps.setCapability("device", "iPhone 7 Plus");
			    caps.setCapability("realMobile", true);
			    caps.setCapability("browserstack.debug", "true");
			    caps.setCapability("project","iosTest App");
				caps.setCapability("build", "iosFactory");
			    caps.setCapability("name", "iosThrive");
			    caps.setCapability("browserstack.video", "true");           
			    caps.setCapability("browserstack.timezone", "Toronto");
			    caps.setCapability("app", iOSAppURL);
			    
			    driver = new IOSDriver<MobileElement> (new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);	
			    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			   
			   break;
		   case "android":
			    System.out.println("Android capabilities Running");
			   
			    caps.setCapability("os", "android");
			    caps.setCapability("os_version", "7.0"); 
			    caps.setCapability("device", "Samsung Galaxy S8");
			    caps.setCapability("realMobile", true);
			    caps.setCapability("browserstack.debug", "true");
			    caps.setCapability("project","Cross Platform");
				caps.setCapability("build", "Cross Platform Factory");
		        caps.setCapability("name", "Factory Method Cross Platform");
			    caps.setCapability("browserstack.video", "true");
			    caps.setCapability("browserstack.timezone", "Toronto");
			    caps.setCapability("app", AndroidAppURL);
			    driver = new AndroidDriver <MobileElement> (new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);		
			    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			   
			   break;
		   default:
			   System.out.println("Please Enter valid platform");
			   break;			   
		   }
		   sc.close();
		   PageFactory.initElements(new AppiumFieldDecorator(driver),objHomePage);
		   PageFactory.initElements(new AppiumFieldDecorator(driver), objRegForm);	
	}
	
	@AfterSuite
	public void quit()
	{
		driver.quit();
	}
	
	@Test(priority=0)
	public void GetStart()
	{
		ExtentReports extent=ExtentReports.get(Regression.class);
		extent.init("C:\\Users\\cheem\\eclipse-workspace\\Cross Platform\\advanceReport.html", true);
		
		extent.startTest("Click on get Started button and verify button available");

		String TEXT=objHomePage.ClickOnGetStarted.getText();
		Assert.assertEquals(TEXT, objAssert.AssertGetStart());
		
		extent.log(LogStatus.INFO, "Get Started text availabe on button");
		
		objHomePage.ClickOnGetStarted.click();
		
		extent.log(LogStatus.PASS, "Button is clickable and availabe");
		//extent.attachScreenshot(screenCapturePath);
		extent.endTest();
	}
	@Test(priority=1)
	public void RegForm() throws Exception
	{
		boolean value= objRegForm.Close_Button.isDisplayed();
		Assert.assertEquals(value, true);
		
		String T1=objRegForm.WelCome_Title.getText();
		Assert.assertEquals(T1, objAssert.AssertWelcomeTitle());
		
		String T2=objRegForm.ProfileInfo_Title.getText();
		Assert.assertEquals(T2, objAssert.AssertTitleProfileInfo());
		
		String T3=objRegForm.Warning_Title.getText();
		Assert.assertEquals(T3, objAssert.AssertTitleallText());
		
		boolean value1=objRegForm._CheckBox.isDisplayed();
		Assert.assertEquals(value1,true);
		
		String T4=objRegForm.AlreadyAcc_SignIn_Button.getText();
		Assert.assertEquals(T4, objAssert.AssertAlreadyAccount());
		
		objRegForm.Create_Account_Button.click();
		
		String AlertMadField1=objRegForm.Alert1.get(0).getText();
		Assert.assertEquals(AlertMadField1, objAssert.AssertMadField());
		
		String AlertMadField2=objRegForm.Alert1.get(1).getText();
		Assert.assertEquals(AlertMadField2, objAssert.AssertMadField());
		
		String AlertMadField3=objRegForm.Alert2.get(0).getText();
		Assert.assertEquals(AlertMadField3, objAssert.AssertMafield());
		
		String AlertMadField4=objRegForm.Alert2.get(1).getText();
		Assert.assertEquals(AlertMadField4, objAssert.AssertMafield());
		
		String AlertMadField5=objRegForm.Alert2.get(2).getText();
		Assert.assertEquals(AlertMadField5, objAssert.AssertMafield());
		
		objRegForm.RegForm(objRegForm.ExcelFirstName(), objRegForm.ExcelLastName(), "abc@mailinator", "abcd123", "1234");
		
		objRegForm.Create_Account_Button.click();
		
		String T5=objRegForm.Email_Alert.getText();
		Assert.assertEquals(T5,objAssert.AssertIncorrectEmail());
		
		String T6=objRegForm.Password_Alert.getText();
		Assert.assertEquals(T6,objAssert.AssertPass());
		
		String T7=objRegForm.Phone_Alert.getText();
		Assert.assertEquals(T7,objAssert.AssertPh());
		
	}
}
