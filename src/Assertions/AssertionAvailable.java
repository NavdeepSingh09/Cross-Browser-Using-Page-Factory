package Assertions;

import Page.GetStartH;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

public class AssertionAvailable {

	static MobileDriver<MobileElement> driver;
	GetStartH obj=new GetStartH(driver);	
	
	public String AssertGetStart()
	{
		return "Get started";
	}
	public String AssertWelcomeTitle()
	{
		return "Welcome to Thrive!";
	}
	public String AssertTitleProfileInfo()
	{
		return "Please enter your profile info:";
	}
	public String AssertTitleallText()
	{
		return "(all text fields are mandatory)";
	}
	public String AssertAlreadyAccount()
	{
		return "Already have an account? Sign in";
	}
	public String AssertMadField()
	{
		return "Mandatory Field";
	}
	public String AssertMafield()
	{
		return "Mandatory field";
	}
	public String AssertIncorrectEmail()
	{
		return "Incorrect email format";
	}
	public String AssertPass()
	{
		return "Minimum 8 characters, 1 capital letter and 1 number";
	}
	public String AssertPh()
	{
		return "10 digit phone number required";
	}
	
}
