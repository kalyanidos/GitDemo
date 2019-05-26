

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.GetAllWindowHandles;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SDFClogin extends reusable {
	
	static WebDriver driver;
	static ExtentTest logger;
	
	//static ExtentTest logger;

	// ExtentReports report;
	
	 
	public  SDFClogin() throws InterruptedException
	{
		logger=SDFCmain.report.startTest("Starts salesforce application");
		initialize_driver();
		Launch_UrL();
		Login();
		
	}
	
	public  void initialize_driver()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\seema\\Selenium\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
	}
	public void Launch_UrL()
	{
		//driver.get("https://www.salesforce.com/");
		clickinglink( driver,"https://www.salesforce.com/");
		driver.manage().window().maximize();
	}
	public boolean Login() throws InterruptedException
	{
		
		driver.findElement(By.linkText("Login")).click();
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		//username.sendKeys("seemakurthikalyani@gmail.com");
		enterText(logger,username, "seemakurthikalyani@gmail.com","usernName");
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		//password, "seemakurthikalyani@gmail.com","usernName");
		enterText(logger,password, "satish098*","password");
		WebElement login=driver.findElement(By.xpath("//input[@id='Login']"));
		clickObj(login,"login");
		Thread.sleep(4000);
		return true;
		
		
    
	}
	public void Tc2_Login_Salesforce () {
		
		driver.close();
	}
	public static void Tc3_Test_the_rememberUsername_check() throws InterruptedException
	{
//		driver.findElement(By.linkText("Login")).click();
//		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
//		username.sendKeys("seemakurthikalyani@gmail.com");
//		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
//		password.sendKeys("satish098*");
		WebElement rememberme=driver.findElement(By.xpath("//input[@id='rememberUn']"));
		selectcheckbox(rememberme,"check box");
		deselectcheckbox(rememberme,"check box");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		Thread.sleep(1000);
	}
	public void TC4_Test_ForgotPassword() throws InterruptedException
	{
		driver.findElement(By.linkText("Login")).click();
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys("seemakurthikalyani@gmail.com");
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@id='forgot_password_link']")).click();
	
		driver.findElement(By.xpath("//input[@id='un']")).click();
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		driver.close();
	}
	public static void Tc5_Selectusemenu_usernamedropdown() throws InterruptedException
	{
		
		WebElement usermenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
		//usermenu.click();
		dropdown(usermenu,"usermenu");
		Thread.sleep(4000);
		WebElement profiletab=driver.findElement(By.xpath("//a[@title='My Profile']"));
		//profiletab.click();
		dropdown(profiletab,"profiletab");
		driver.close();
	}
	public static void Tc6_Editprofile_Data() throws InterruptedException
	{


		System.out.println("for displaying user menu is");
		
		WebElement usermenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
		usermenu.click();
		
		WebElement profiletab=driver.findElement(By.xpath("//a[@title='Profile Tab']"));
		profiletab.click();
		Thread.sleep(4000);
		WebElement editprofile=driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']"));
		editprofile.click();
		WebElement iframe=driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']"));
		//driver.switchTo().frame(iframe);
		switchFrame(driver,iframe);
		WebElement about=driver.findElement(By.id("aboutTab"));
		about.click();
		WebElement lastname=driver.findElement(By.name("lastName"));
		lastname.clear();
		lastname.sendKeys("D");
		Thread.sleep(4000);
		driver.switchTo().defaultContent();
		//driver.switchTo().frame("contactInfoContentId");
		switchFrameid( driver,"contactInfoContentId");
		System.out.println("user menu is displayed");
		WebElement saveall=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]"));
		saveall.click();
		driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'Post')]")).click();
		Thread.sleep(4000);
        System.out.println("postlink");
		driver.findElement(By.xpath("//a[contains(@title,'Profile Tab - Selected')]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'Post')]")).click();
		
		WebElement iframe1=driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, publisherRichTextEditor']"));
		System.out.println(4000);
		//driver.switchTo().frame(iframe1);
		switchFrame(driver,iframe1);
		WebElement textbox=  driver.findElement(By.xpath("/html[1]/body[1]"));
		textbox.click();
		textbox.sendKeys("hello hi");
		//driver.switchTo().defaultContent();
		switchdefaultFrame(driver);
		System.out.println("i am out of teh frame");
		driver.findElement(By.xpath("//input[@id='publishersharebutton']")).click();
		System.out.println("postlink page is displayed");
		System.out.println("postlink page is displayed successfullty");
		System.out.println("uploading the file is started");
		Thread.sleep(4000);
		  driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'File')]")).click();
		  driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']")).click();
		  driver.findElement(By.xpath("//input[@id='chatterFile']")).click();
		  System.out.println("file is choosen");
		  Thread.sleep(4000);
		  WebDriverWait wait = new WebDriverWait(driver, 40);
		  WebElement browse=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='chatterFile']")));
		  browse.sendKeys("C:\\Users\\seema\\OneDrive\\Desktop\\hakathon.txt");
		  Thread.sleep(4000);
		  WebElement share=driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
		  share.click();
		  System.out.println("file is uploaded succesfully");
		
	}
	public static void Tc7_usernamedropdwn()
	{
		
	System.out.println("usermenu");
	WebElement usermenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
	usermenu.click();
	driver.findElement(By.linkText("My Settings")).click();
	driver.findElement(By.id("PersonalInfo_font")).click();
	driver.findElement(By.id("LoginHistory_font")).click();
		
      WebElement link=driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]"));
      link.click();
	
//Alert alert=driver.switchTo().alert();
	//String ok=alert.getText();
	//Thread.sleep(4000);
//alert.accept();
	WebElement displaylayout=driver.findElement(By.id("DisplayAndLayout_font"));
	displaylayout.click();
	WebElement custamizetabs=driver.findElement(By.id("CustomizeTabs_font"));
	custamizetabs.click();
	WebElement selectsalesforechatter=driver.findElement(By.id("p4"));
	
//	Select sel=new Select(selectsalesforechatter);
//	sel.selectByIndex(3);
	
	SelectByindex( selectsalesforechatter,3);
	WebElement selectbutton=driver.findElement(By.xpath("//select[@id='duel_select_0']"));
	
//	Select sel2=new Select(selectbutton);
//	sel2.selectByVisibleText("Reports");
SelectbyText(selectbutton,"Reports");
	WebElement add1=driver.findElement(By.xpath("//img[@title='Add']"));
	add1.click();
	//WebElement save=driver.findElement(By.name("save"));
	//save.click();
	//Thread.sleep(4000);
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
	
	}
	public static void Tc8_developerconsoledata() throws InterruptedException
	{
	//ExtentTest logger;
		logger =SDFCmain.report.startTest("developerconsole Data");
		logger.log(LogStatus.INFO, "Firefox browser is launced....");
		
		Thread.sleep(4000);
		WebElement usermenu1=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
		usermenu1.click();
		WebElement developerconsole=driver.findElement(By.linkText("Developer Console"));
		developerconsole.click();
		Set<String> getAllWindows=driver.getWindowHandles();
		String[] window=getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(window[1]).close();
		System.out.println("executed");
		logger.log(LogStatus.PASS, "window is opened");
        SDFCmain.report.endTest(logger);
		
		//SDFCmain.report.flush();
		//driver.close();
	}
	public static void Tc9_SelectLogoutUser_menu() throws InterruptedException
	{
		logger=SDFCmain.report.startTest("logout usermenu");
		
		Thread.sleep(4000);
		
		
		WebElement usermenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
		usermenu.click();
		
		logger.log(LogStatus.INFO, "usermenu opened");
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("logout page should be displayed");
		logger.log(LogStatus.PASS, "logged out successfully");
		//SDFCmain.report.flush();
	}
	
	public static void Tc10_Create_acc() throws InterruptedException
	{
		
		logger=SDFCmain.report.startTest("Create aaccount");
		Thread.sleep(4000);
		WebElement accuontButton=driver.findElement(By.linkText("Accounts"));
		accuontButton.click();
		WebElement new1=driver.findElement(By.name("new"));
		logger.log(LogStatus.INFO, "new button is opened");
		
		new1.click();
		WebElement AccName=driver.findElement(By.id("acc2"));
		AccName.sendKeys("123456");
		WebElement save=driver.findElement(By.name("save"));
		save.click();
		System.out.println("executed");
		logger.log(LogStatus.PASS, "Account is created");
		
	}
	public static void tc11_Create_new_view() throws InterruptedException
	{
		logger=SDFCmain.report.startTest("Create new view");
		Thread.sleep(4000);
		WebElement accuontButton=driver.findElement(By.linkText("Accounts"));
		accuontButton.click();
		logger.log(LogStatus.INFO, "Accounts button is clicked");
		WebElement newview=driver.findElement(By.id("createNewButton"));
		newview.click();
		/*Select sel=new Select(newview);
		sel.selectByValue("3");
		WebElement txt=driver.findElement(By.id("acc2"));
		txt.sendKeys("seemakurthikalyani@gmai.com");
	*/
		WebElement edit=driver.findElement(By.linkText("Edit"));
		edit.click();
		WebElement btn=driver.findElement(By.id("fname"));
		btn.sendKeys("kalyani");
		WebElement btn1=driver.findElement(By.id("devname"));
		btn.sendKeys("kalyani");
		
		WebElement btn2=driver.findElement(By.id("devname"));
		btn2.sendKeys("kalyani");
		WebElement save1=driver.findElement(By.name("save"));
		save1.click();
		logger.log(LogStatus.PASS,"newly added view is displayed");
		
	}
public static void Tc12_EditView ()
{
	logger =SDFCmain.report.startTest("Edit view");
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
	editname.sendKeys("kalyani1");
	WebElement conatainsdropdown=driver.findElement(By.xpath("//select[@id='fcol1']"));
	Select sel1=new Select(conatainsdropdown);
	sel1.selectByIndex(5);
	logger.log(LogStatus.INFO,"contains dropdown is selected by using index");
	WebElement operator=driver.findElement(By.xpath("//select[@id='fop1']"));
	Select sel2=new Select(operator);
	sel2.selectByIndex(3);
	logger.log(LogStatus.INFO,"operator is selected");
	WebElement value=driver.findElement(By.xpath("//input[@id='fval1']"));
	value.sendKeys("a123");
	//WebElement Availablefileds=driver.findElement(By.xpath("//select[@id='colselector_select_0']"));
	 //Availablefileds.click();
	WebElement avalsel=driver.findElement(By.xpath("//option[@value='SOCIAL_PERSONA_FACEBOOK']"));
	avalsel.click();
	WebElement add1=driver.findElement(By.className("rightArrowIcon"));
	add1.click();
	WebElement save1=driver.findElement(By.name("save"));
	save1.click();
	driver.close();
	logger.log(LogStatus.PASS, "last activity column is added" );
	
}
public static void tc13_mergeacc() throws InterruptedException
{
	logger=SDFCmain.report.startTest("mergeacc");
	Thread.sleep(4000);
	WebElement accuontButton=driver.findElement(By.linkText("Accounts"));
	accuontButton.click();
	Thread.sleep(4000);
	WebElement mergeacc=driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
	mergeacc.click();
	driver.findElement(By.xpath("//input[@id='srch']")).sendKeys("123456");
	driver.findElement(By.xpath("//div[contains(@class,'pbWizardBody')]//input[2]")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//input[@id='cid0']")).click();
	driver.findElement(By.xpath("//input[@id='cid1']")).click();
	driver.findElement(By.xpath("//input[@id='cid2']")).click();
	driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[contains(@title,'Next')]")).click();
	driver.findElement(By.xpath("//div[contains(@class,'pbTopButtons')]//input[contains(@title,'Merge')]")).click();
	Alert alert=driver.switchTo().alert();
	alert.accept();
	//switchtoAlert(WebDriver driver,alert)
	logger.log(LogStatus.PASS,"merge acc is listed");
}

public void t14_createAcc() throws InterruptedException
{
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
		 startdate.sendKeys("12/12/18");
		 
		
		
		 WebElement enddate=driver.findElement(By.name("endDate"));
		 enddate.clear();
		 enddate.sendKeys("12/14/18");
		 
		
		 
		 WebElement save2=driver.findElement(By.xpath("//button[@id='ext-gen49']"));
		 save2.click();
		 WebElement rpname=driver.findElement(By.name("reportName"));
		
		 
		 rpname.sendKeys("satishkalyani331");
		 WebElement upname=driver.findElement(By.id("saveReportDlg_DeveloperName"));
		 upname.sendKeys("");
		 Thread.sleep(4000);
		// WebElement save3=driver.findElement(By.id("ext-gen257"));
		 //save3.click();
		 
		 WebElement save3=driver.findElement(By.xpath("//button[contains(text(),'Save and Run Report')]"));
		 save3.click();
	
		 
		 ////table[@id='dlgSaveAndRun']
	
}
public void tc15_opertunites()
{
	
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
}
public void tc16_newopty() throws InterruptedException
{
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
 



}
	 }
 }
}
public void Tc17_opp() throws InterruptedException
{
	WebElement opertunites=driver.findElement(By.linkText("Opportunities"));
	opertunites.click();
Thread.sleep(4000);	
WebElement opertunitespipeline=driver.findElement(By.xpath("//body[contains(@class,'ext-webkit ext-chrome sfdcBody brandQuaternaryBgr')]/div[@id='contentWrapper']/div[contains(@class,'bodyDiv brdPalette brandPrimaryBrd')]/table[@id='bodyTable']/tbody/tr/td[@id='bodyCell']/table[@id='toolsContent']/tbody/tr/td/div[contains(@class,'toolsContentLeft')]/div[1]"));
	opertunitespipeline=driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));
	opertunitespipeline.click();	
}

public void tc18_stuckopp() throws InterruptedException
{
	
	WebElement opertunites=driver.findElement(By.linkText("Opportunities"));
	opertunites.click();
Thread.sleep(4000);	
WebElement stuckopertunities=driver.findElement(By.xpath("//body[contains(@class,'ext-webkit ext-chrome sfdcBody brandQuaternaryBgr')]/div[@id='contentWrapper']/div[contains(@class,'bodyDiv brdPalette brandPrimaryBrd')]/table[@id='bodyTable']/tbody/tr/td[@id='bodyCell']/table[@id='toolsContent']/tbody/tr/td/div[contains(@class,'toolsContentLeft')]/div[1]"));

stuckopertunities=driver.findElement(By.linkText("Stuck Opportunities"));
stuckopertunities.click();
}

public void tc19_open_or_close() throws InterruptedException
{
	WebElement opertunites=driver.findElement(By.linkText("Opportunities"));
	opertunites.click();
Thread.sleep(4000);	

WebElement quaterlysummary=driver.findElement(By.xpath("//form[@id='lead_summary']"));
quaterlysummary=driver.findElement(By.xpath("//select[@id='quarter_q']"));

Select sel=new Select(quaterlysummary);
sel.selectByIndex(2);
WebElement quaterlysummaryinclude=driver.findElement(By.xpath("//select[@id='open']"));

Select sel2=new Select(quaterlysummaryinclude);
sel2.selectByIndex(2);

driver.findElement(By.xpath("//input[contains(@title,'Run Report')]")).click();
}
public static void tc20_leads() throws InterruptedException
{
	logger=SDFCmain.report.startTest("leads Tab");
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
		SDFCmain.report.endTest(logger);
		
		
}
public static void  tc21_view() throws InterruptedException
{
//	logger=SDFCmain.report.startTest("leads Selectview");
	Thread.sleep(4000);	
	WebElement leads=driver.findElement(By.xpath("//a[contains(@title,'Leads Tab')]"));
	 leads.click();
	// logger.log(LogStatus.INFO, "application is succesfully loggedin");
	 System.out.println("application is succesfully logged in");
	 //Thread.sleep(4000);
		WebElement viewmenu=driver.findElement(By.xpath("//select[@id='fcf']"));
		viewmenu.click();
		Select sel =new Select
				(viewmenu);
		List<WebElement> options=sel.getOptions();
		
		if(options.isEmpty())
		{
			//return false;
		}
		else
		{
		for(WebElement item:options) {
		System.out.println("dropdown values are  "+ item.getText());
		
		//logger.log(LogStatus.PASS, "drop down values are displayed");
		//return true;
		}
		}
		//logger.log(LogStatus.PASS, "drop down values are displayed");
		//SDFCmain.report.endTest(logger);
		/*WebElement wb=sel.getWrappedElement();
		System.out.println("elements visible in view button is :  "+wb.getText());
		
		
		System.out.println("-------------------");
		WebElement usermenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
		usermenu.click();
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("appln is successfully loggedout5");
		Object Actuvalval = null;
		ArrayList arr=new ArrayList();
		arr.add("My Unread Leads");
		arr.add("Recently Viewed Lead");
		arr.add("Today's Leads");
		
		Iterator it=arr.iterator();
		while(it.hasNext())
		{
			
			Actuvalval=it.next();
			System.out.println("Actualvalue of array list   ==="+Actuvalval);
			System.out.println();
		}
		*/
		//return false;
}

public void tc22_defaultpage () throws InterruptedException
{
	WebElement leads=driver.findElement(By.linkText("Leads"));
	 leads.click();
	 System.out.println("application is succesfully logged in");
	 Thread.sleep(4000);
	
		WebElement viewmenu=driver.findElement(By.xpath("//select[@id='fcf']"));
		
		Select sel1=new Select(viewmenu);
		//sel1.getAllSelectedOptions();
		sel1.selectByIndex(3);
		WebElement b=sel1.getFirstSelectedOption();
		
		System.out.println("the selected leads is:     "+b.getText());
		
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
			
		
		
/* tc 21 and 22 equals operator can not able to do*/

	
}
public void tc23_todayslead() throws InterruptedException
{
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
	
		
WebElement viewmenu3=driver.findElement(By.xpath("//select[@id='fcf']"));
		
		Select sel3=new Select(viewmenu3);
		sel3.selectByIndex(3);
		WebElement b1=sel3.getFirstSelectedOption();
		System.out.println("result show  "+b1.getText());
}

public void tc24_newlead() throws InterruptedException
{
	
	WebElement leads=driver.findElement(By.linkText("Leads"));
	 leads.click();
	 System.out.println("application is succesfully logged in");
	 Thread.sleep(4000);
	 
	 WebElement new1=driver.findElement(By.xpath("//input[contains(@title,'New')]"));
	 new1.click();
	 
	 WebElement lname=driver.findElement(By.name("name_lastlea2"));
	 lname.sendKeys("abcd");
	 
	 WebElement companey=driver.findElement(By.name("lea3"));
	 companey.sendKeys("abcd");
	 
	 
	 WebElement save1=driver.findElement(By.name("save"));
	 save1.click();
	 
	 System.out.println("new lead page is created and tc is succesfully executed");
	 
	 
}

public void tc25_contacts() throws InterruptedException
{
	WebElement contacts1=driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
	contacts1.click();
	Thread.sleep(4000);
	WebElement new1=driver.findElement(By.xpath("//input[contains(@title,'New')]"));
	new1.click();
	
	WebElement Fname=driver.findElement(By.xpath("//input[@id='name_firstcon2']"));
	Fname.sendKeys("abcdefgh");
	
	WebElement lname=driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
	lname.sendKeys("abcdefgh");
	
	
	WebElement accno=driver.findElement(By.xpath("//input[@id='con4']"));
	accno.sendKeys("123456");
	
	WebElement cancel=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Cancel']"));
	cancel.click();
}

public void tc26_createnewviewcontacts() throws InterruptedException{
	Thread.sleep(4000);
	WebElement contacts1=driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
	contacts1.click();
	Thread.sleep(4000);
	
	driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
	
	driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("kalyani");
	driver.findElement(By.xpath("//input[@id='devname']")).sendKeys("kalyani");
	
	driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@title='Save']")).click();
	
}

public void tc27_Checkrecentlycreatedcontacts() throws InterruptedException
{
	Thread.sleep(4000);
	WebElement contacts1=driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
	contacts1.click();
	Thread.sleep(4000);
	
	WebElement wb=driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
	wb.click();
	Select sel=new Select(wb);
	sel.selectByVisibleText("Recently Viewed");
	
}
public void tc28_Mycontactviewcontact() throws InterruptedException
{
	
	Thread.sleep(4000);
	WebElement contacts1=driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
	contacts1.click();
	Thread.sleep(4000);
	WebElement wb=driver.findElement(By.xpath("//select[@id='fcf']"));
	wb.click();
	Select sel=new Select(wb);
	sel.selectByVisibleText("My Contacts");
	System.out.println("tc28 is executed" );
}

public void tc29_viewcontactsincontacts() throws InterruptedException
{
	Thread.sleep(4000);
	WebElement contacts1=driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
	contacts1.click();
	Thread.sleep(4000);
	WebElement wb=driver.findElement(By.xpath("//select[@id='fcf']"));
	wb.click();
	Select sel=new Select(wb);
	sel.selectByVisibleText("My Contacts");
	System.out.println("conytacts page shoild be displayed" );
	
}

public void tc30_creatingnewviewcontacts() throws InterruptedException
{
	Thread.sleep(4000);
	WebElement contacts1=driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
	contacts1.click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
	driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("efgh");
	driver.findElement(By.xpath("//input[@id='devname']")).sendKeys("efgh");
	driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@title='Save']")).click();
	System.out.println("error message shoild be displayed");
}

public void  tc31_cancel_contacts() throws InterruptedException
{

	WebElement contacts1=driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
	contacts1.click();
	Thread.sleep(4000);
	WebElement new1=driver.findElement(By.xpath("//input[contains(@title,'New')]"));
	new1.click();
	
	WebElement Fname=driver.findElement(By.xpath("//input[@id='name_firstcon2']"));
	Fname.sendKeys("abcdefgh");
	
	WebElement lname=driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
	lname.sendKeys("abcdefgh");
	
	
	WebElement accno=driver.findElement(By.xpath("//input[@id='con4']"));
	accno.sendKeys("123456");
	
	WebElement cancel=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Cancel']"));
	cancel.click();
}
public void tc32_saveandnewbutoonincontacts() throws InterruptedException
{
	WebElement contacts1=driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
	contacts1.click();
	Thread.sleep(4000);
	WebElement new1=driver.findElement(By.xpath("//input[contains(@title,'New')]"));
	new1.click();
	
	WebElement Fname=driver.findElement(By.xpath("//input[@id='name_firstcon2']"));
	Fname.sendKeys("abcdefgh");
	WebElement lname=driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
	lname.sendKeys("abcdefgh");
	
	
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
		 
	 }
public void tc33_home () throws InterruptedException
{
	Thread.sleep(4000);
	driver.findElement(By.xpath("//a[contains(@title,'Home Tab')]")).click();
	driver.findElement(By.xpath("//a[contains(text(),'kalyani D')]")).click();
	//driver.findElement(By.xpath("//a[contains(text(),'kalyaniD')]")).click();
	
}
public void tc34_verifylastname() throws InterruptedException
{
	driver.findElement(By.xpath("//a[contains(@title,'Home Tab')]")).click();
	driver.findElement(By.xpath("//a[contains(text(),'kalyani dosapati')]")).click();
	//driver.findElement(By.xpath("//a[contains(text(),'kalyani D')]"))
	driver.findElement(By.xpath("//a[contains(text(),'kalyani dosapati')]")).click();
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
	lname.sendKeys("D");
	driver.findElement(By.xpath("//input[@value='Save All']")).click();
			
	
	
}
public void tc35_removebutton() throws InterruptedException
{
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
	WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
	username.sendKeys("seemakurthikalyani@gmail.com");
	WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
	password.sendKeys("satish098*");
	driver.findElement(By.xpath("//input[@id='Login']")).click();
	System.out.println("campaigns should not be displayed");
}
public void tc36_currentDateLink() throws InterruptedException
{
	driver.findElement(By.xpath("//a[contains(@title,'Home Tab')]")).click();
	driver.findElement(By.xpath("//a[contains(text(),'Monday December 17, 2018')]")).click();
	
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
}
	 }
}
}


	


