package AutomationSDFC;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AutomationScripts extends Reusable {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		Reusable re=new Reusable();
		//these atr re usable methods
		//hello world
		LoginErrorMessage_1();
		LoginToSalesForce_2();
		Tc3_Test_the_rememberUsername_check();
		TC4_Test_ForgotPassword();
		ForgotPassword_4B();
		Tc5_Selectusemenu_usernamedropdown();
		Tc6_Editprofile_Data();
	Tc7_usernamedropdwn();
		Tc8_developerconsoledata();
    	Tc9_SelectLogoutUser_menu();
		Tc10_Create_acc();
        tc11_Create_new_view();
        Tc12_EditView ();
		 tc13_mergeacc();
		t14_createAcc();
		tc15_opertunites();
		tc16_newopty();
		Tc17_opp();
		tc18_stuckopp();
		tc19_open_or_close();
		tc20_leads();
		tc21_view();
		tc22_defaultpage ();
		tc23_todayslead();
		tc24_newlead();
		tc25_contacts();
		tc26_createnewviewcontacts();
		tc27_Checkrecentlycreatedcontacts();
		tc28_Mycontactviewcontact();
		tc29_viewcontactsincontacts();
		tc30_creatingnewviewcontacts();
		tc31_cancel_contacts();
		tc32_saveandnewbutoonincontacts();
		tc33_home ();

		tc34_verifylastname();
		tc35_removebutton();
		tc36_currentDateLink();
		
	tc37_Blocking_an_event_in_the_calender_with_weekly_recurrance();
		
		
//		Reusable.report.endTest(logger);
//		Reusable.report.flush();
	}
	public static  void initialize_driver()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\seema\\Selenium\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
	}
	public static void LoginToSFDC() throws InterruptedException, IOException
	{
		String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\login.xls","Sheet1");
		String URL=data[1][2];
		getURL( driver,URL);
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Login")).click();
		logger.log(LogStatus.PASS, "Salesforce application page is opened" );
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		String username1=data[1][0];
		enterText(username, username1,"usernName");
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		String password1=data[1][1];
		enterText(password, password1,"password");
		WebElement login=driver.findElement(By.xpath("//input[@id='Login']"));
		clickObj(login,"login");
		Thread.sleep(4000);
		
	}
	public static void LoginErrorMessage_1() throws IOException, InterruptedException
	{
		
		createTestScriptReport("LoginErrorMessage_1");
		initialize_driver();
		String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\tc.xls","Sheet1");
        String URL=data[1][1];
		getURL( driver,URL);
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Login")).click();
		logger.log(LogStatus.PASS, "Salesforce application page is opened" ); 
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		String username1=data[1][0];
		enterText(username, username1,"usernName");
		logger.log(LogStatus.PASS, "User Name is displayed in User name field" );
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		String password1=data[1][1];
		enterText(password, password1,"password");
		logger.log(LogStatus.PASS, "Password field is empty"); 
		WebElement login=driver.findElement(By.xpath("//input[@id='Login']"));
		clickObj(login,"login");
		logger.log(LogStatus.PASS, "error message 'Please enter your password is displayed");
		Thread.sleep(4000);
		driver.close();
		Reportclose();
		
	}

	public static void LoginToSalesForce_2() throws InterruptedException, IOException
	{
		createTestScriptReport("LoginToSalesForce_2");
		initialize_driver();
		LoginToSFDC();
		driver.close();
		Reportclose();
	}
	public static void Tc3_Test_the_rememberUsername_check() throws InterruptedException, IOException
	{
		createTestScriptReport("Tc3_Test_the_rememberUsername_check");
		initialize_driver();
		String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\login.xls","Sheet1");
        String URL=data[1][2];
		getURL( driver,URL);
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Login")).click();
		logger.log(LogStatus.PASS, "Salesforce application page is opened" );
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		String username1=data[1][0];
		enterText(username, username1,"usernName");
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		String password1=data[1][1];
		enterText(password, password1,"password");
		
		Thread.sleep(4000);
		//driver.findElement(By.linkText("Login")).click();
		WebElement rememberme=driver.findElement(By.xpath("//input[@id='rememberUn']"));
		selectcheckbox(rememberme,"check box");
		logger.log(LogStatus.PASS, "Login sales force page is displayed with <username> populated and remember user name checked");
		deselectcheckbox(rememberme,"check box");
		WebElement login=driver.findElement(By.xpath("//input[@id='Login']"));
		clickObj(login,"login");
		//driver.findElement(By.xpath("//input[@id='Login']")).click();
		Thread.sleep(1000);
		WebElement usernamefield=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		usernamefield.click();
		WebElement logout=driver.findElement(By.xpath("//a[@title='Logout']"));
		logout.click();
//		WebElement validateUname=driver.findElement(By.xpath("//div[@id='username_container']"));
//		//validateUname.click();
//		logger.log(LogStatus.PASS, validateUname.getText());
		driver.close();
		Reportclose();
		
	}
	public static void TC4_Test_ForgotPassword() throws InterruptedException, IOException
	{
		createTestScriptReport("TC4_Test_ForgotPassword");
		initialize_driver();
		String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\login.xls","Sheet1");
		String URL=data[1][2];
		getURL( driver,URL);
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Login")).click();
		logger.log(LogStatus.PASS, "Salesforce application page is opened" );
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		String username1=data[1][0];
		enterText(username, username1,"usernName");
		driver.findElement(By.xpath("//a[@id='forgot_password_link']")).click();
		logger.log(LogStatus.PASS, "Salesforce forgot password page is displayed");
        driver.findElement(By.xpath("//input[@id='un']")).click();
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		logger.log(LogStatus.PASS, "Password reset message page is displayed. An email associated with the <username> account is sent");
		driver.close();
Reportclose();
	}
	public static void ForgotPassword_4B() throws InterruptedException, IOException
	{
		createTestScriptReport("ForgotPassword_4B");
		initialize_driver();
		String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\tc4B.xls","Sheet1");
		String URL=data[1][2];
		getURL( driver,URL);
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Login")).click();
		//logger.log(LogStatus.PASS, "Salesforce application page is opened" );
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		String username1=data[1][0];
		enterText(username, username1,"usernName");
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		String password1=data[1][1];
		enterText(password, password1,"password");
		WebElement login=driver.findElement(By.xpath("//input[@id='Login']"));
		clickObj(login,"login");
		Thread.sleep(4000);
		WebElement error=driver.findElement(By.id("error"));
		String actuval="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		validateErrorMsg(actuval, error.getText());
		logger.log(LogStatus.PASS, error.getText());
		driver.close();
		Reportclose();
	}
	public static void Tc5_Selectusemenu_usernamedropdown() throws InterruptedException, IOException
	{
		createTestScriptReport("Tc5_Selectusemenu_usernamedropdown");
		initialize_driver();
		LoginToSFDC();
        Thread.sleep(4000);
        logger.log(LogStatus.PASS,"SalesForce login page is launched and application home page is logged in with correct username"  );
		WebElement usermenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
		dropdown(usermenu,"usermenu");
		logger.log(LogStatus.PASS,"User menu drop down is displayed");
		logger.log(LogStatus.PASS,"Drop down with "+"My profile"+ "My Settings"+ "Developer Console"+"Logout"+ "is displayed");
        Thread.sleep(4000);
		WebElement profiletab=driver.findElement(By.xpath("//a[@title='My Profile']"));
		System.out.println(usermenu.getText());
	    dropdown(profiletab,"profiletab");
	    driver.close();
		Reportclose();
	    
		}
	public static void Tc6_Editprofile_Data() throws InterruptedException, IOException
	{
		
       createTestScriptReport("Tc6_Editprofile_Data");
       String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\tc6.xls","Sheet1");
       initialize_driver();
	   LoginToSFDC();
       WebElement usermenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
       dropdown(usermenu,"usermenu");
	   logger.log(LogStatus.PASS,"User menu drop down is displayed");
	   logger.log(LogStatus.PASS,"Drop down with "+"My profile"+ "My Settings"+ "Developer Console"+"Logout"+ "is displayed");
	   WebElement profiletab=driver.findElement(By.xpath("//a[@title='Profile Tab']"));
	   dropdown(profiletab,"profiletab");
	   Thread.sleep(4000);
		WebElement editprofile=driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']"));
		editprofile.click();
		WebElement iframe=driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']"));
		switchFrame(driver,iframe);
		WebElement about=driver.findElement(By.id("aboutTab"));
		about.click();
		WebElement lastname=driver.findElement(By.name("lastName"));
		lastname.clear();
		String lastname2=data[1][0];
		enterText(lastname,lastname2,"lastname");
		Thread.sleep(4000);
		driver.switchTo().defaultContent();
		switchFrameid( driver,"contactInfoContentId");
		WebElement saveall=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]"));
		clickObj(saveall,"saveall");
		driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'Post')]")).click();
		Thread.sleep(4000);
        logger.log(LogStatus.PASS,"postlink is displayed");
        WebElement profiletab1=driver.findElement(By.xpath("//a[contains(@title,'Profile Tab - Selected')]"));
        clickObj(profiletab1,"profiletab1");
		driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'Post')]")).click();
		WebElement iframe1=driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, publisherRichTextEditor']"));
		switchFrame(driver,iframe1);
		WebElement textbox=  driver.findElement(By.xpath("/html[1]/body[1]"));
		clickObj(textbox,"textbox");
		String textbox2=data[1][1];
		enterText(textbox,textbox2,"textbox");
		switchdefaultFrame(driver);
		System.out.println("i am out of teh frame");
		driver.findElement(By.xpath("//input[@id='publishersharebutton']")).click();
		logger.log(LogStatus.PASS,"postlink page is displayed successfullty");
		logger.log(LogStatus.PASS,"uploading the file is started");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'File')]")).click();
		driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']")).click();
		driver.findElement(By.xpath("//input[@id='chatterFile']")).click();
		System.out.println("file is choosen");
		logger.log(LogStatus.PASS,"file is choosen");
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement browse=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='chatterFile']")));
		String browse2=data[1][2];
		enterText(browse,browse2,"link"); 
		Thread.sleep(4000);
		 WebElement share=driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
		 share.click();
		 Thread.sleep(4000);
		 logger.log(LogStatus.PASS,"uploading the file is done successfully");
		 driver.close();
			Reportclose();
		  
		}
	public static void Tc7_usernamedropdwn() throws InterruptedException, IOException
	{
		createTestScriptReport("Tc7_usernamedropdwn");
	       String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\tc6.xls","Sheet1");
	       initialize_driver();
		   LoginToSFDC();
	      WebElement usermenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
	       dropdown(usermenu,"usermenu");
		   logger.log(LogStatus.PASS,"User menu drop down is displayed");
		   logger.log(LogStatus.PASS,"Drop down with "+"My profile"+ "My Settings"+ "Developer Console"+"Logout"+ "is displayed");
	      driver.findElement(By.linkText("My Settings")).click();
	      driver.findElement(By.id("PersonalInfo_font")).click();
	      driver.findElement(By.id("LoginHistory_font")).click();
    WebElement link=driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]"));
     link.click();
	WebElement displaylayout=driver.findElement(By.id("DisplayAndLayout_font"));
	displaylayout.click();
	WebElement custamizetabs=driver.findElement(By.id("CustomizeTabs_font"));
	custamizetabs.click();
	WebElement selectsalesforechatter=driver.findElement(By.id("p4"));
	SelectByindex( selectsalesforechatter,3);
	WebElement selectbutton=driver.findElement(By.xpath("//select[@id='duel_select_0']"));
	SelectbyText(selectbutton,"Reports");
	WebElement add1=driver.findElement(By.xpath("//img[@title='Add']"));
	add1.click();
	System.out.println("email");
		WebElement email=driver.findElement(By.xpath("//div[@id='EmailSetup']//a[@class='header setupFolder']"));
		email.click();
		WebElement emailsetting=driver.findElement(By.id("EmailSettings_font"));
		emailsetting.click();
		WebElement ename=driver.findElement(By.name("sender_name"));
		ename.clear();
		ename.sendKeys("kalyani");
		WebElement eadd=driver.findElement(By.name("sender_email"));
		eadd.clear();
		eadd.sendKeys("seemakurthikalyani@gmail.com");
		//@SuppressWarnings("unchecked")
		List<WebElement> radiobutton=driver.findElements(By.name("auto_bcc"));
		boolean bval;
		bval=radiobutton.get(0).isSelected();
		if(bval==false)
		{
			radiobutton.get(0).click();
		}
		WebElement save3=driver.findElement(By.xpath("//input[@title='Save']"));
		save3.click();
	    System.out.println("calenderremainders");
		WebElement calendersandremainders=driver.findElement(By.id("CalendarAndReminders_font"));
	
		calendersandremainders.click();
		WebElement activityremainder=driver.findElement(By.id("Reminders_font"));
		
		activityremainder.click();
		WebElement opentestRe=driver.findElement(By.id("testbtn"));
		opentestRe.click();
		Set<String> getAllWindows=driver.getWindowHandles();
		String[] window=getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(window[0]).close();
		 driver.close();
			Reportclose();
	
	}
	
	public static void Tc8_developerconsoledata() throws InterruptedException, IOException
	{
		createTestScriptReport("Tc8_developerconsoledata");
		initialize_driver();
		logger.log(LogStatus.INFO, "Firefox browser is launced....");
		LoginToSFDC();
        Thread.sleep(4000);
        logger.log(LogStatus.PASS,"SalesForce login page is launched and application home page is logged in with correct username"  );
		WebElement usermenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
		dropdown(usermenu,"usermenu");
		logger.log(LogStatus.PASS,"User menu drop down is displayed");
		WebElement developerconsole=driver.findElement(By.linkText("Developer Console"));
		developerconsole.click();
//		Set<String> getAllWindows=driver.getWindowHandles();
//		String[] window=getAllWindows.toArray(new String[getAllWindows.size()]);
		windowhandler(driver);
		//driver.switchTo().window(window[1]).close();
		System.out.println("executed");
		logger.log(LogStatus.PASS, "window is opened");
        driver.close();
		Reportclose();
	}
	public static void Tc9_SelectLogoutUser_menu() throws InterruptedException, IOException
	{
		createTestScriptReport("Tc9_SelectLogoutUser_menu");
		initialize_driver();
		LoginToSFDC();
		Thread.sleep(4000);
		WebElement usermenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
		clickObj(usermenu,"usermenu");
		logger.log(LogStatus.INFO, "usermenu opened");
		driver.findElement(By.linkText("Logout")).click();
		logger.log(LogStatus.PASS, "logged out successfully");
		driver.close();
		Reportclose();
	}
	public static void Tc10_Create_acc() throws InterruptedException, IOException
	{
		createTestScriptReport("Tc10_Create_acc");
		initialize_driver();
		LoginToSFDC();
		Thread.sleep(4000);
		WebElement accuontButton=driver.findElement(By.linkText("Accounts"));
		accuontButton.click();
		WebElement new1=driver.findElement(By.name("new"));
		logger.log(LogStatus.INFO, "new button is opened");
		new1.click();
		String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\tc6.xls","Sheet1");
		String accn=data[1][0];
        WebElement AccName=driver.findElement(By.id("acc2"));
		enterText(AccName,accn,"accn");
		//AccName.sendKeys("123456");
		WebElement save=driver.findElement(By.name("save"));
		save.click();
		System.out.println("executed");
		logger.log(LogStatus.PASS, "Account is created");
		driver.close();
		Reportclose();
		}
	public static void tc11_Create_new_view() throws InterruptedException, IOException
	{
		createTestScriptReport("tc11_Create_new_view");
		initialize_driver();
		LoginToSFDC();
		Thread.sleep(4000);
		WebElement accuontButton=driver.findElement(By.linkText("Accounts"));
		accuontButton.click();
		logger.log(LogStatus.INFO, "Accounts button is clicked");
		WebElement newview=driver.findElement(By.id("createNewButton"));
		newview.click();
		WebElement edit=driver.findElement(By.linkText("Edit"));
		edit.click();
		String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\tc6.xls","Sheet1");
		String accn=data[1][0];
		WebElement btn=driver.findElement(By.id("fname"));
		enterText(btn,accn,"fname");
		//btn.sendKeys("kalyani");
		String accn1=data[1][1];
		WebElement btn1=driver.findElement(By.id("devname"));
		enterText(btn1,accn1,"devname1");
		//btn.sendKeys("kalyani");
		String accn2=data[1][2];
		WebElement btn2=driver.findElement(By.id("devname"));
		enterText(btn2,accn2,"devname2");
		//btn2.sendKeys("kalyani");
		WebElement save1=driver.findElement(By.name("save"));
		save1.click();
		logger.log(LogStatus.PASS,"newly added view is displayed");
		driver.close();
		Reportclose();
		}
	public static void Tc12_EditView () throws InterruptedException, IOException
	{
		createTestScriptReport("Tc12_EditView");
		initialize_driver();
		LoginToSFDC();
		Thread.sleep(4000);
		WebElement accuontButton=driver.findElement(By.linkText("Accounts"));
		accuontButton.click();
		WebElement dropdown=driver.findElement(By.xpath("//select[@id='fcf']"));
		//dropdown.click();
		Select sl=new Select(dropdown);
		sl.selectByIndex(2);
		logger.log(LogStatus.INFO,"Select dropdow is clicked");
		WebElement edit=driver.findElement(By.linkText("Edit"));
		edit.click();
		WebElement list=driver.findElement(By.xpath("//input[@id='fname']"));
		list.click();
		WebElement editname=driver.findElement(By.xpath("//input[@id='fname']"));
		editname.click();
		editname.clear();
		String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\tc12.xls","Sheet1");
		String accn=data[1][0];
		enterText(editname,accn,"editname");
		//editname.sendKeys("kalyani1");
		WebElement conatainsdropdown=driver.findElement(By.xpath("//select[@id='fcol1']"));
		Select sel1=new Select(conatainsdropdown);
		//SelectByindex(conatainsdropdown,5);
		sel1.selectByIndex(5);
		logger.log(LogStatus.INFO,"contains dropdown is selected by using index");
		WebElement operator=driver.findElement(By.xpath("//select[@id='fop1']"));
		Select sel2=new Select(operator);
		//SelectByindex(operator,3);
		sel2.selectByIndex(3);
		logger.log(LogStatus.INFO,"operator is selected");
		WebElement value=driver.findElement(By.xpath("//input[@id='fval1']"));
		String value1=data[1][1];
		enterText(value,value1,"fval");
		//value.sendKeys("a123");
		WebElement avalsel=driver.findElement(By.xpath("//option[@value='SOCIAL_PERSONA_FACEBOOK']"));
		avalsel.click();
		WebElement add1=driver.findElement(By.className("rightArrowIcon"));
		add1.click();
		WebElement save1=driver.findElement(By.name("save"));
		save1.click();
		
		driver.close();
		Reportclose();
	}
	public static void tc13_mergeacc() throws InterruptedException, IOException
	{
		createTestScriptReport("tc13_mergeacc");
		initialize_driver();
		LoginToSFDC();
		Thread.sleep(4000);
		WebElement accuontButton=driver.findElement(By.linkText("Accounts"));
		accuontButton.click();
		Thread.sleep(4000);
		WebElement mergeacc=driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
		mergeacc.click();
		WebElement meraccnum=driver.findElement(By.xpath("//input[@id='srch']"));
		String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\tc13.xls","Sheet1");
		String accn=data[1][0];
		enterText(meraccnum,accn,"meraccnum");
		//meraccnum.sendKeys("123456");
		driver.findElement(By.xpath("//div[contains(@class,'pbWizardBody')]//input[2]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='cid0']")).click();
		driver.findElement(By.xpath("//input[@id='cid1']")).click();
		driver.findElement(By.xpath("//input[@id='cid2']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[contains(@title,'Next')]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'pbTopButtons')]//input[contains(@title,'Merge')]")).click();
		//switchtoAlert(driver,alert);
		Alert alert=driver.switchTo().alert();
		alert.accept();
		//switchtoAlert(WebDriver driver,alert)
		logger.log(LogStatus.PASS,"merge acc is listed");
		driver.close();
		Reportclose();
	}
	public static void t14_createAcc() throws InterruptedException, IOException
	{
		createTestScriptReport("t14_createAcc");
		initialize_driver();
		LoginToSFDC();
		Thread.sleep(4000);
			WebElement accuontButton=driver.findElement(By.linkText("Accounts"));
			accuontButton.click();
			WebElement daylink=driver.findElement(By.linkText("Accounts with last activity > 30 days"));
			 daylink.click();
			 Thread.sleep(4000);
			WebElement datefield=driver.findElement(By.xpath("//img[@id='ext-gen148']"));
			 datefield.click();
			  driver.findElement(By.xpath("//div[contains(text(),'Created Date')]")).click();
			 WebElement startdate=driver.findElement(By.name("startDate"));
			 startdate.clear();
			 String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\tc14.xls","Sheet1");
			 String startdate1=data[1][0];
			 enterText(startdate,startdate1,"startdate");
			 //startdate.sendKeys("12/12/18");
			 WebElement enddate=driver.findElement(By.name("endDate"));
			 enddate.clear();
			 String endDate=data[1][1];
			enterText(enddate,endDate,"enddate");
			// enddate.sendKeys("12/14/18");
			 WebElement save2=driver.findElement(By.xpath("//button[@id='ext-gen49']"));
			 save2.click();
			 WebElement rpname=driver.findElement(By.name("reportName"));
			 String name=data[1][2];
				enterText(rpname,name,"rpname");
			 //rpname.sendKeys("satishkalyani345");
			 WebElement upname=driver.findElement(By.id("saveReportDlg_DeveloperName"));
			 upname.sendKeys("");
			 Thread.sleep(4000);
			// WebElement save3=driver.findElement(By.id("ext-gen257"));
			 //save3.click();
			 WebElement save3=driver.findElement(By.xpath("//button[contains(text(),'Save and Run Report')]"));
			 save3.click();
		////table[@id='dlgSaveAndRun']
			 driver.close();
				Reportclose();
		
	}
	public static void tc15_opertunites() throws InterruptedException, IOException
	{
		createTestScriptReport("tc15_opertunites");
		initialize_driver();
		LoginToSFDC();
		Thread.sleep(4000);
		WebElement opertunites=driver.findElement(By.linkText("Opportunities"));
		opertunites.click();
	    WebElement ispresent=driver.findElement(By.xpath("//select[@id='fcf']"));
	    ispresent.click();
	    //List<WebElement> ispresent=driver.findElements(By.xpath("//select[@id='fcf']"));
	    Select sel=new Select( ispresent);
	    //sel.selectByVisibleText("Closing Next Month");
	   //sel.selectByVisibleText("Closing This Month");
     //List<WebElement> bval;
	//bval=sel.getAllSelectedOptions();
	sel.getAllSelectedOptions();
	//sel.getOptions();
	System.out.println(sel.getAllSelectedOptions());
	//logger.log(LogStatus.PASS, (Throwable) sel.getAllSelectedOptions());
	driver.close();
	Reportclose();
	}
	public static void tc16_newopty() throws InterruptedException, IOException
	{
		createTestScriptReport("tc16_newopty");
		initialize_driver();
		LoginToSFDC();
		WebElement opertunites=driver.findElement(By.linkText("Opportunities"));
		opertunites.click();
	WebElement new1=driver.findElement(By.name("new"));
	new1.click();
	WebElement optname=driver.findElement(By.name("opp3"));
	optname.clear();
	optname.sendKeys("hello");
	// WebElement accname1=driver.findElement(By.name("opp4"));
	//accname1.click();
	/* Select sl=new Select(accname);
	sl.selectByIndex(1);*/
	/* WebElement closedate=driver.findElement(By.name("opp9"));
	closedate.click();
	WebElement ele=driver.findElement(By.xpath("//td[contains(@class,'weekday selectedDate')]"));
	ele.click();*/

	WebElement stage=driver.findElement(By.id("opp11"));

	Select sel=new Select(stage);
	sel.selectByIndex(2);
	WebElement probability=driver.findElement(By.id("opp12"));

	probability.clear();
	probability.sendKeys("10");
	WebElement amt=driver.findElement(By.id("opp7"));

	amt.clear();
	amt.sendKeys("10000");

	WebElement leadsource=driver.findElement(By.id("opp6"));

	Select sel2=new Select(leadsource);
	sel.selectByIndex(2);
	WebElement nextstep=driver.findElement(By.id("opp10"));

	nextstep.clear();
	nextstep.sendKeys("abcd");

	WebElement description=driver.findElement(By.id("opp14"));
	 
	description.clear();
	description.sendKeys("hi hello how  are you");
	//WebElement accname=driver.findElement(By.xpath("//input[@id='opp4']"));
	//accname.sendKeys("1234");
	// Set<String> oldwindow=driver.getWindowHandles();
	String homepage=driver.getWindowHandle();
	WebElement accname=driver.findElement(By.xpath("//img[contains(@title,'Account Name Lookup (New Window)')]"));
	accname.click();
	 Set<String> windows=driver.getWindowHandles();
	 Iterator it=windows.iterator();
	 String currentwindowid;
	 while(it.hasNext())
	 {
		 currentwindowid=it.next().toString();
		 System.out.println("currentid");
		 if(!currentwindowid.equals(homepage))
		 {
			 driver.switchTo().window(currentwindowid);
			 driver.manage().window().maximize();
			 Thread.sleep(4000);
			 //driver.switchTo().frame(0);
			 driver.switchTo().frame("searchFrame");
				//driver.findElement(By.name("new")).click();
			 driver.findElement(By.name("go")).click();
			 
			 System.out.println("page is opened");
				Thread.sleep(4000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("resultsFrame");
				driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/th[1]/a[1]")).click();
				
				
				
				String currentid2;
				while(it.hasNext())
				{
				currentid2=it.next().toString();
				System.out.println("currentid2");
				if(!currentid2.equals(currentwindowid))
				{
					driver.switchTo().window(currentid2);
					driver.manage().window().maximize();
					Thread.sleep(4000);
					driver.switchTo().frame("searchFrame");
					driver.findElement(By.className("dataRow even first")).click();
					
					System.out.println("executed");
				}
				
			
			/*	Thread.sleep(4000);
	//driver.switchTo().window(window[2]);
	Thread.sleep(1000);
	driver.switchTo().frame("lksrch");


		driver.get("https://na85.salesforce.com/_ui/common/data/LookupPage?lkfm=editPage&lknm=opp4&lktp=001&lksrch=123456");
		driver.findElement(By.name("new")).click();
		driver.getCurrentUrl();
		
				driver.switchTo().window(window[0]);
				Thread.sleep(4000);

				
	driver.switchTo().frame(0);
	driver.switchTo().frame("searchFrame");
	driver.findElement(By.name("new")).click();*/
	 
				driver.close();
				Reportclose();


	}
		 }
	 }
	}
	public static void Tc17_opp() throws InterruptedException, IOException
	{
		createTestScriptReport("Tc17_opp");
		initialize_driver();
		LoginToSFDC();
		WebElement opertunites=driver.findElement(By.linkText("Opportunities"));
		opertunites.click();
	Thread.sleep(4000);	
	WebElement opertunitespipeline=driver.findElement(By.xpath("//body[contains(@class,'ext-webkit ext-chrome sfdcBody brandQuaternaryBgr')]/div[@id='contentWrapper']/div[contains(@class,'bodyDiv brdPalette brandPrimaryBrd')]/table[@id='bodyTable']/tbody/tr/td[@id='bodyCell']/table[@id='toolsContent']/tbody/tr/td/div[contains(@class,'toolsContentLeft')]/div[1]"));
		opertunitespipeline=driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));
		
		opertunitespipeline.click();	
		driver.close();
		Reportclose();
	}

	public static void tc18_stuckopp() throws InterruptedException, IOException
	{
		createTestScriptReport("tc18_stuckopp");
		initialize_driver();
		LoginToSFDC();
		WebElement opertunites=driver.findElement(By.linkText("Opportunities"));
		opertunites.click();
	Thread.sleep(4000);	
	WebElement stuckopertunities=driver.findElement(By.xpath("//body[contains(@class,'ext-webkit ext-chrome sfdcBody brandQuaternaryBgr')]/div[@id='contentWrapper']/div[contains(@class,'bodyDiv brdPalette brandPrimaryBrd')]/table[@id='bodyTable']/tbody/tr/td[@id='bodyCell']/table[@id='toolsContent']/tbody/tr/td/div[contains(@class,'toolsContentLeft')]/div[1]"));

	stuckopertunities=driver.findElement(By.linkText("Stuck Opportunities"));
	stuckopertunities.click();
	driver.close();
	Reportclose();
	}

	public static void tc19_open_or_close() throws InterruptedException, IOException
	{
		createTestScriptReport("tc19_open_or_close");
		initialize_driver();
		LoginToSFDC();
		WebElement opertunites=driver.findElement(By.linkText("Opportunities"));
		opertunites.click();
	Thread.sleep(4000);	

	WebElement quaterlysummary=driver.findElement(By.xpath("//form[@id='lead_summary']"));
	quaterlysummary=driver.findElement(By.xpath("//select[@id='quarter_q']"));
	SelectByindex(quaterlysummary, 2);
	Select sel=new Select(quaterlysummary);
	sel.selectByIndex(2);
	WebElement quaterlysummaryinclude=driver.findElement(By.xpath("//select[@id='open']"));
//	SelectByindex(quaterlysummaryinclude, 2);
	Select sel2=new Select(quaterlysummaryinclude);
	sel2.selectByIndex(2);

	driver.findElement(By.xpath("//input[contains(@title,'Run Report')]")).click();
	driver.close();
	Reportclose();
	}
	public static void tc20_leads() throws InterruptedException, IOException
	{
		createTestScriptReport("tc20_leads");
		initialize_driver();
		LoginToSFDC();
		Thread.sleep(4000);
		WebElement leads=driver.findElement(By.linkText("Leads"));
		leads.click();
		logger.log(LogStatus.INFO, "leads tab is clicked");
		System.out.println("application is succesfully logged in");
		Thread.sleep(4000);
		logger.log(LogStatus.INFO, "application launched");
		WebElement usermenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
		usermenu.click();
		driver.findElement(By.linkText("Logout")).click();
		System.out.println(" tc20 appln is successfully loggedout");
		logger.log(LogStatus.PASS, "userlogged out and application closed successfully");
			
			
		driver.close();
		Reportclose();	
	}
	
	public static void  tc21_view() throws InterruptedException, IOException
	{
		createTestScriptReport("tc21_view");
		initialize_driver();
		LoginToSFDC();
		Thread.sleep(4000);	
		WebElement leads=driver.findElement(By.xpath("//a[contains(@title,'Leads Tab')]"));
		 leads.click();
		// logger.log(LogStatus.INFO, "application is succesfully loggedin");
		 System.out.println("application is succesfully logged in");
		 //Thread.sleep(4000);
			WebElement viewmenu=driver.findElement(By.xpath("//select[@id='fcf']"));
			viewmenu.click();
			Select sel =new Select(viewmenu);
			List<WebElement> options=sel.getOptions();
			
			if(options.isEmpty())
			{
				//return false;
			}
			else
			{
			for(WebElement item:options) {
			System.out.println("dropdown values are  "+ item.getText());
			
			logger.log(LogStatus.PASS, item.getText());
			//return true;
			}
			}
			driver.close();
			Reportclose();
			
	}
	public static void tc22_defaultpage () throws InterruptedException, IOException
	{
		 createTestScriptReport("tc22_defaultpage");
		 initialize_driver();
		 LoginToSFDC();
		 Thread.sleep(4000);
		 WebElement leads=driver.findElement(By.linkText("Leads"));
		 leads.click();
		 System.out.println("application is succesfully logged in");
		 Thread.sleep(4000);
		 WebElement viewmenu=driver.findElement(By.xpath("//select[@id='fcf']"));
		 //SelectByindex(viewmenu, 3);
		 Select sel1=new Select(viewmenu);
			sel1.getAllSelectedOptions();
			sel1.selectByIndex(3);
			WebElement b=sel1.getFirstSelectedOption();
			logger.log(LogStatus.PASS,"the selected leads is:     "+b.getText());
			WebElement usermenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
			usermenu.click();
			driver.findElement(By.linkText("Logout")).click();
			System.out.println("appln is successfully loggedout5");
			Thread.sleep(6000);
			WebElement username1=driver.findElement(By.xpath("//input[@id='username']"));
			username1.clear();
			username1.sendKeys("seemakurthikalyani@gmail.com");
			WebElement password1=driver.findElement(By.xpath("//input[@id='password']"));
			password1.clear();
			password1.sendKeys("satish098*");
			driver.findElement(By.xpath("//input[@id='Login']")).click();
			Thread.sleep(4000);
			WebElement leads2=driver.findElement(By.linkText("Leads"));
			leads2.click();
		    WebElement viewmenu1=driver.findElement(By.name("fcf"));
			Select sel2=new Select(viewmenu1);
			WebElement viewmenu2=sel2.getFirstSelectedOption();
			System.out.println("result should be shown as same:  "+viewmenu2.getText());
			logger.log(LogStatus.PASS,viewmenu2.getText());
			driver.close();
			Reportclose();
	}
	public static void tc23_todayslead() throws InterruptedException, IOException
	{
		createTestScriptReport("tc23_todayslead");
		 initialize_driver();
		 LoginToSFDC();
		 Thread.sleep(4000);
		WebElement leads=driver.findElement(By.linkText("Leads"));
		 leads.click();
		 System.out.println("application is succesfully logged in");
		 Thread.sleep(4000);
		
			WebElement viewmenu=driver.findElement(By.xpath("//select[@id='fcf']"));
			
			Select sel1=new Select(viewmenu);
			sel1.selectByIndex(3);
			WebElement b=sel1.getFirstSelectedOption();
			
			System.out.println("the selected leads is:     "+b.getText());
			
			WebElement usermenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
			usermenu.click();
			driver.findElement(By.linkText("Logout")).click();
			System.out.println("appln is successfully loggedout5");
			Thread.sleep(6000);
			String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\tc23.xls","Sheet1");
			String fname=data[1][0];
			String  password=data[1][1];
			WebElement username1=driver.findElement(By.xpath("//input[@id='username']"));
			username1.clear();
			enterText(username1,fname,"username1");
			//username1.sendKeys("seemakurthikalyani@gmail.com");
			WebElement password1=driver.findElement(By.xpath("//input[@id='password']"));
			password1.clear();
			//password1.sendKeys("satish098*");
			enterText(password1, password,"password1");
			driver.findElement(By.xpath("//input[@id='Login']")).click();
			Thread.sleep(4000);
			
			 
			WebElement leads2=driver.findElement(By.linkText("Leads"));
			leads2.click();
		    
			WebElement viewmenu1=driver.findElement(By.name("fcf"));
			Select sel2=new Select(viewmenu1);
			
			WebElement viewmenu2=sel2.getFirstSelectedOption();
			System.out.println("result should be shown as same:  "+viewmenu2.getText());
		
			
	WebElement viewmenu3=driver.findElement(By.xpath("//select[@id='fcf']"));
			
			Select sel3=new Select(viewmenu3);
			sel3.selectByIndex(3);
			WebElement b1=sel3.getFirstSelectedOption();
			System.out.println("result show  "+b1.getText());
			driver.close();
			Reportclose();
	}

	public static void tc24_newlead() throws InterruptedException, IOException
	{
		createTestScriptReport("tc24_newlead");
		 initialize_driver();
		 LoginToSFDC();
		 Thread.sleep(4000);
		WebElement leads=driver.findElement(By.linkText("Leads"));
		 leads.click();
		 System.out.println("application is succesfully logged in");
		 Thread.sleep(4000);
		 
		 WebElement new1=driver.findElement(By.xpath("//input[contains(@title,'New')]"));
		 new1.click();
		 String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\tc24.xls","Sheet1");
			String fname=data[1][0];
			String lname1=data[1][1];
		 
		 WebElement lname=driver.findElement(By.name("name_lastlea2"));
		 //lname.sendKeys("abcd");
		 enterText(lname,fname,"fname1");
		 WebElement companey=driver.findElement(By.name("lea3"));
		 //companey.sendKeys("abcd");
		 enterText(companey,lname1,"fname1");
		 
		 WebElement save1=driver.findElement(By.name("save"));
		 save1.click();
		 
		 System.out.println("new lead page is created and tc is succesfully executed");
		 driver.close();
			Reportclose();
		 
	}

	public static void tc25_contacts() throws InterruptedException, IOException
	{
		createTestScriptReport("tc25_contacts");
		 initialize_driver();
		 LoginToSFDC();
		 Thread.sleep(4000);
		WebElement contacts1=driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
		contacts1.click();
		Thread.sleep(4000);
		WebElement new1=driver.findElement(By.xpath("//input[contains(@title,'New')]"));
		new1.click();
		String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\tc25.xls","Sheet1");
		String fname=data[1][0];
		String lname1=data[1][1];
		String accno1=data[1][2];
		WebElement Fname=driver.findElement(By.xpath("//input[@id='name_firstcon2']"));
		Fname.sendKeys("abcdefgh");
		enterText(Fname,fname,"fname1");
		WebElement lname=driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		lname.sendKeys("abcdefgh");
		enterText(lname,lname1,"lname");
		
		WebElement accno=driver.findElement(By.xpath("//input[@id='con4']"));
		accno.sendKeys("123456");
		enterText(accno,accno1,"accno");
		WebElement cancel=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Cancel']"));
		cancel.click();
		driver.close();
		Reportclose();
	}

	public static void tc26_createnewviewcontacts() throws InterruptedException, IOException{
		
		createTestScriptReport("tc26_createnewviewcontacts");
		 initialize_driver();
		 LoginToSFDC();
		 Thread.sleep(4000);
		WebElement contacts1=driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
		contacts1.click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
		String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\tc26.xls","Sheet1");
		String fname=data[1][0];
		String lname1=data[1][1];
		
		WebElement fname1=driver.findElement(By.xpath("//input[@id='fname']"));
		enterText(fname1,fname,"fname1");
		
		WebElement lname=driver.findElement(By.xpath("//input[@id='devname']"));
		enterText(lname,lname1,"lname");
        driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@title='Save']")).click();
        driver.close();
		Reportclose();
		
	}

	public static void tc27_Checkrecentlycreatedcontacts() throws InterruptedException, IOException
	{
		createTestScriptReport("tc27_Checkrecentlycreatedcontacts");
		 initialize_driver();
		 LoginToSFDC();
		Thread.sleep(4000);
		WebElement contacts1=driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
		contacts1.click();
		Thread.sleep(4000);
		WebElement wb=driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
		wb.click();
		Select sel=new Select(wb);
		sel.selectByVisibleText("Recently Viewed");
		driver.close();
		Reportclose();
		
	}
	public static void tc28_Mycontactviewcontact() throws InterruptedException, IOException
	{
		createTestScriptReport("tc28_Mycontactviewcontact");
		 initialize_driver();
		 LoginToSFDC();
		 Thread.sleep(4000);
		WebElement contacts1=driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
		contacts1.click();
		Thread.sleep(4000);
		WebElement wb=driver.findElement(By.xpath("//select[@id='fcf']"));
		wb.click();
		Select sel=new Select(wb);
		sel.selectByVisibleText("My Contacts");
		System.out.println("tc28 is executed" );
		driver.close();
		Reportclose();
	}

	public static void tc29_viewcontactsincontacts() throws InterruptedException, IOException
	{
		createTestScriptReport("tc29_viewcontactsincontacts");
		 initialize_driver();
		 LoginToSFDC();
		 Thread.sleep(4000);
		Thread.sleep(4000);
		WebElement contacts1=driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
		contacts1.click();
		Thread.sleep(4000);
		WebElement wb=driver.findElement(By.xpath("//select[@id='fcf']"));
		wb.click();
		Select sel=new Select(wb);
		sel.selectByVisibleText("My Contacts");
		System.out.println("conytacts page shoild be displayed" );
		driver.close();
		Reportclose();
		
	}

	public static void tc30_creatingnewviewcontacts() throws InterruptedException, IOException
	{
		createTestScriptReport("tc30_creatingnewviewcontacts");
		 initialize_driver();
		 LoginToSFDC();
		 Thread.sleep(4000);
		Thread.sleep(4000);
		WebElement contacts1=driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
		contacts1.click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
		String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\tc30.xls","Sheet1");
		String fname=data[1][0];
		String lname1=data[1][1];
	WebElement fname1=driver.findElement(By.xpath("//input[@id='fname']"));
	enterText(fname1,fname,"fname");
	WebElement devname=driver.findElement(By.xpath("//input[@id='devname']"));
	enterText(devname,lname1,"lname");
		driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@title='Save']")).click();
		System.out.println("error message shoild be displayed");
		driver.close();
		Reportclose();
	}

	public static void  tc31_cancel_contacts() throws InterruptedException, IOException
	{
		createTestScriptReport("tc31_cancel_contacts");
		 initialize_driver();
		 LoginToSFDC();
		 Thread.sleep(4000);

		WebElement contacts1=driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
		contacts1.click();
		Thread.sleep(4000);
		WebElement new1=driver.findElement(By.xpath("//input[contains(@title,'New')]"));
		new1.click();
		String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\tc31.xls","Sheet1");
		String fname=data[1][0];
		String lname1=data[1][1];
		String accno1=data[1][2];
		WebElement Fname=driver.findElement(By.xpath("//input[@id='name_firstcon2']"));
		enterText(Fname,fname,"fname");
		WebElement lname=driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		enterText(lname,lname1,"lname");
		WebElement accno=driver.findElement(By.xpath("//input[@id='con4']"));
		enterText(accno,accno1,"accno");
		WebElement cancel=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Cancel']"));
		cancel.click();
		driver.close();
		Reportclose();
	}
	public static void tc32_saveandnewbutoonincontacts() throws InterruptedException, IOException
	{
		createTestScriptReport("tc32_saveandnewbutoonincontacts");
		 initialize_driver();
		 LoginToSFDC();
		 Thread.sleep(4000);
		WebElement contacts1=driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
		contacts1.click();
		Thread.sleep(4000);
		WebElement new1=driver.findElement(By.xpath("//input[contains(@title,'New')]"));
		new1.click();
		String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\tc32.xls","Sheet1");
		String fname=data[1][0];
		String lname1=data[1][1];
        WebElement Fname=driver.findElement(By.xpath("//input[@id='name_firstcon2']"));
		enterText(Fname,fname,"fname");
		WebElement lname=driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		enterText(lname,lname1,"lname1");
		WebElement accno=driver.findElement(By.xpath("//img[@title='Account Name Lookup (New Window)']"));
		accno.click();
		//driver.switchTo().frame("searchFrame");
		//String homepage=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		String[] window=windows.toArray(new String[windows.size()]);
		driver.switchTo().window(window[1]);
		driver.switchTo().frame("searchFrame");
		driver.findElement(By.name("go")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("resultsFrame");
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/th[1]/a[1]")).click();
		
		//driver.switchTo().defaultContent();
		driver.switchTo().window(window[0]);
		System.out.println("i came back");
			 driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']")).click();
			 driver.close();
				Reportclose();
			 
		 }
	public static void tc33_home () throws InterruptedException, IOException
	{
		createTestScriptReport("tc22_defaultpage");
		 initialize_driver();
		 LoginToSFDC();
		 Thread.sleep(4000);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[contains(@title,'Home Tab')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'kalyani D')]")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'kalyaniD')]")).click();
		driver.close();
		Reportclose();
		
	}
	public static void tc34_verifylastname() throws InterruptedException, IOException
	{
		createTestScriptReport("tc34_verifylastname");
		 initialize_driver();
		 LoginToSFDC();
		 Thread.sleep(4000);
		 driver.findElement(By.xpath("//a[contains(@title,'Home Tab')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'kalyani D')]")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'kalyani D')]"))
		driver.findElement(By.xpath("//a[contains(text(),'kalyani D')]")).click();
		WebElement ele=driver.findElement(By.xpath("//a[contains(@class,'contactInfoLaunch editLink')]//img[contains(@title,'Edit Profile')]"));
		ele.click();
		Thread.sleep(4000);
		//driver.switchTo().frame(0);
		//driver.switchTo().frame("contactInfoContentId");
		System.out.println("i am in frame");
		driver.switchTo().frame("contactInfoContentId");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//li[@id='aboutTab']")).click();
		Thread.sleep(4000);
		
		WebElement lname=driver.findElement(By.name("lastName"));
		lname.clear();
		String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\tc34.xls","Sheet1");
		String accn=data[1][0];
        enterText(lname,accn,"lname");
		//lname.sendKeys("D");
		driver.findElement(By.xpath("//input[@value='Save All']")).click();
		driver.close();
		Reportclose();	
		
		
	}
	public static void tc35_removebutton() throws InterruptedException, IOException
	{
		createTestScriptReport("tc35_removebutton");
		 initialize_driver();
		 LoginToSFDC();
		 Thread.sleep(4000);
		driver.findElement(By.xpath("//img[@title='All Tabs']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@title='Customize My Tabs']")).click();
		driver.findElement(By.xpath("//select[@id='duel_select_1']")).click();
		driver.findElement(By.xpath("//option[contains(@value,'Campaign')]")).click();
		driver.findElement(By.xpath("//img[contains(@title,'Remove')]")).click();
		driver.findElement(By.xpath("//input[contains(@title,'Save')]")).click();
		
		WebElement usermenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
		usermenu.click();
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(4000);
		//driver.findElement(By.linkText("Login")).click();
		String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\tc35.xls","Sheet1");
		String username1=data[1][0];
		String password1=data[1][1];
       
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		 enterText(username,username1,"username");
		//username.sendKeys("seemakurthikalyani@gmail.com");
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		//password.sendKeys("satish098*");
		enterText(password,password1,"password");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		System.out.println("campaigns should not be displayed");
		driver.close();
		Reportclose();
	}
	public static void tc36_currentDateLink() throws InterruptedException, IOException
	{
		 createTestScriptReport("tc36_currentDateLink");
		 initialize_driver();
		 LoginToSFDC();
		 Thread.sleep(4000);
		 driver.findElement(By.xpath("//a[contains(@title,'Home Tab')]")).click();
         driver.findElement(By.xpath("//a[contains(text(),'Sunday February 17, 2019')]")).click();
		 driver.findElement(By.xpath("//div[@id='p:f:j_id25']"));
		 driver.findElement(By.xpath("//a[contains(text(),'8:00 AM')]")).click();
		Thread.sleep(4000);
		//driver.findElement(By.xpath("//img[contains(@title,'Subject Combo (New Window)')]")).click();
		String homepage=driver.getWindowHandle();
		System.out.println("homepage");
		driver.findElement(By.xpath("//img[contains(@title,'Subject Combo (New Window)')]")).click();
		Thread.sleep(4000);
		Set<String> windows=driver.getWindowHandles();
		Iterator it=windows.iterator();
		String currentid;
		while(it.hasNext()) {
			currentid=it.next().toString();
			System.out.println("current window is");
			if(!currentid.equals(homepage))
			{
				driver.switchTo().window(currentid);
				driver.manage().window().maximize();
				Thread.sleep(4000);
			driver.findElement(By.xpath("//a[@href='javascript:pickValue(4);']")).click();
			driver.switchTo().window(homepage);
			driver.findElement(By.xpath("//input[@id='StartDateTime']")).click();
			//driver.findElement(By.xpath("//input[@id='EndDateTime_time']")).click();
			driver.findElement(By.name("save")).click();
			System.out.println("save");
			driver.close();
			Reportclose();
	}
		 }
	}
	public static void tc37_Blocking_an_event_in_the_calender_with_weekly_recurrance() throws InterruptedException, IOException
	{
		createTestScriptReport("tc37_Blocking_an_event_in_the_calender");
		 initialize_driver();
		 LoginToSFDC();
		 Thread.sleep(4000);
		driver.findElement(By.xpath("//a[contains(@title,'Home Tab')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Sunday February 17, 2019')]")).click();
		driver.findElement(By.xpath("//div[@id='p:f:j_id25']"));
		driver.findElement(By.xpath("//a[contains(text(),'4:00 PM')]")).click();
		Thread.sleep(4000);
		String homepage=driver.getWindowHandle();
		System.out.println("homepage");
		driver.findElement(By.xpath("//img[contains(@title,'Subject Combo (New Window)')]")).click();
		Thread.sleep(4000);
		driver.close();
		Reportclose();
		
		
		
		
		
		
	}


}
