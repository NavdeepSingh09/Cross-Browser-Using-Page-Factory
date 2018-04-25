package Page;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class RegistrationF {
	
	 	final MobileDriver<MobileElement> driver;
		
	 	@AndroidFindBy(xpath="//android.widget.EditText[@text='First Name']")
	 	@iOSFindBy(xpath="//android.widget.EditText[@text='First']")
		public MobileElement F_name_TextBox;
		
		@AndroidFindBy(xpath="//android.widget.EditText[@text='Last Name']")
		@iOSFindBy(xpath="IOS Element Address")
		public MobileElement L_Name_TextBox;
		
		@AndroidFindBy(xpath="//android.widget.EditText[@text='Email address']")
		@iOSFindBy(xpath="IOS Element Address")
		public MobileElement Email_TextBox;
		
		@AndroidFindBy(xpath="//android.widget.EditText[@text='Password']")
		@iOSFindBy(xpath="IOS Element Address")
		public MobileElement Password_TextBox;
		
		@AndroidFindBy(xpath="//android.widget.EditText[@text='Mobile number']")
		@iOSFindBy(xpath="IOS Element Address")
		public MobileElement M_No_TextBox;
		
		@AndroidFindBy(xpath="//android.widget.Button[@index='8' and @text='Create your account']")
		@iOSFindBy(xpath="IOS Element Address")
		public MobileElement Create_Account_Button;
		
		@AndroidFindBy(xpath="//android.widget.TextView[@text='Mandatory Field']")
		@iOSFindBy(xpath="IOS Element Address")
		public List <MobileElement> Alert1;
		
		@AndroidFindBy(xpath="//android.widget.TextView[@text='Mandatory field']")
		@iOSFindBy(xpath="IOS Element Address")
		public List<MobileElement> Alert2;
		
		@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.compass_canada.thrive:id/toolbar_title']")
		@iOSFindBy(xpath="IOS Element Address")
		public MobileElement WelCome_Title;
		
		@AndroidFindBy(xpath="//android.widget.ImageView[contains(@resource-id,'toolbar_back_button')]")
		@iOSFindBy(xpath="IOS Element Address")
		public MobileElement Close_Button;
		
		@AndroidFindBy(xpath="//android.widget.TextView[@text='Please enter your profile info:']")
		@iOSFindBy(xpath="IOS Element Address")
		public MobileElement ProfileInfo_Title;
		
		@AndroidFindBy(xpath="//android.widget.TextView[@text='(all text fields are mandatory)']")
		@iOSFindBy(xpath="IOS Element Address")
		public MobileElement Warning_Title;
		
		@AndroidFindBy(xpath="//android.widget.TextView[@index='1' and @text='Subscribe to promotions']")
		@iOSFindBy(xpath="IOS Element Address")
		public MobileElement Subscribe_Text;

		@AndroidFindBy(className="android.widget.CheckBox")
		@iOSFindBy(xpath="IOS Element Address")
		public MobileElement _CheckBox;
		
		@AndroidFindBy(xpath="//android.widget.Button[@index='9']")
		@iOSFindBy(xpath="IOS Element Address")
		public MobileElement AlreadyAcc_SignIn_Button;
		
		@AndroidFindBy(xpath="//android.widget.TextView[@text='Incorrect email format']")
		@iOSFindBy(xpath="IOS Element Address")
		public MobileElement Email_Alert;
		
		@AndroidFindBy(xpath="//android.widget.TextView[@text='Minimum 8 characters, 1 capital letter and 1 number']")
		@iOSFindBy(xpath="IOS Element Address")
		public MobileElement Password_Alert;
		
		@AndroidFindBy(xpath="//android.widget.TextView[@text='10 digit phone number required']")
		@iOSFindBy(xpath="IOS Element Address")
		public MobileElement Phone_Alert;
		
		File filename= new File("C:\\Users\\cheem\\eclipse-workspace\\Factory Method\\InputData.xlsx");
		
		
		public RegistrationF(MobileDriver<MobileElement> driver)
		{
			this.driver=driver;
		}
		
		public String ExcelFirstName() throws Exception
		{
			FileInputStream LoadFile= new FileInputStream(filename);
			XSSFWorkbook wb=new XSSFWorkbook(LoadFile);
			XSSFSheet sh1= wb.getSheetAt(0);
			String FirstName= sh1.getRow(0).getCell(0).getStringCellValue();
			wb.close();
			return FirstName;
			
		}
		public String ExcelLastName() throws Exception
		{
			FileInputStream LoadFile= new FileInputStream(filename);
			XSSFWorkbook wb=new XSSFWorkbook(LoadFile);
			XSSFSheet sh1= wb.getSheetAt(0);
			String LastName= sh1.getRow(0).getCell(1).getStringCellValue();
			wb.close();
			return LastName;
			
		}

		public void RegForm(String FName,String LName,String EMail,String PassWord, String PH) throws Exception
		{
			
			this.setFirstName(FName);
			this.setLastName(LName);
			this.setEmailAddress(EMail);
			this.setPass(PassWord);
			this.setMobileNo(PH);
		}
			
		private void setMobileNo(String PH)
		{
			M_No_TextBox.sendKeys(PH);
		}

		private void setPass(String PassWord) 
		{
			Password_TextBox.sendKeys(PassWord);	
		}

		private void setEmailAddress(String EMail) 
		{
			Email_TextBox.sendKeys(EMail);	
		}

		private void setLastName(String LName)
		{
			L_Name_TextBox.sendKeys(LName);	
		}

		private void setFirstName(String FName) 
		{
			F_name_TextBox.sendKeys(FName);
			
		}
		
}
