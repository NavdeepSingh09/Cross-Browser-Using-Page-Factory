package Page;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class GetStartH {
	
	final MobileDriver<MobileElement> driver;
	 @AndroidFindBy(xpath="//android.widget.Button[@text='Get started']")
	 @iOSFindBy(xpath="IOS Element path")
	public MobileElement ClickOnGetStarted;
	
	public GetStartH(MobileDriver<MobileElement> driver)
	{
		this.driver=driver;
	}
	

}
