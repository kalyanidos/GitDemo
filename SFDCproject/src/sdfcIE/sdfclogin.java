package sdfcIE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sdfclogin {
	static WebDriver driver;
	public  sdfclogin() throws InterruptedException
	{
		initialize_driver();
		Launch_UrL();
		Login();
		
	}
	
	public  void initialize_driver()
	{
		System.setProperty("webdriver.ie.driver", "C:\\Users\\seema\\Selenium\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
	}
	public void Launch_UrL()
	{
		driver.get("https://www.salesforce.com/");
		driver.manage().window().maximize();
	}
	public void Login() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,4000);
		driver.findElement(By.linkText("Login")).click();
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys("seemakurthikalyani@gmail.com");
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("satish098*");
		
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		Thread.sleep(4000);
	
		
		
    
	}
	public static void Tc2_Login_Salesforce () {
		
		driver.close();
		System.out.println("tc2 isbexecuted");
	}
	public void Tc3_Test_the_rememberUsername_check() throws InterruptedException
	{
		driver.findElement(By.linkText("Login")).click();
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys("seemakurthikalyani@gmail.com");
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("satish098*");
		WebElement rememberme=driver.findElement(By.xpath("//input[@id='rememberUn']"));
		rememberme.click();
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		Thread.sleep(1000);
		System.out.println("tc3 isbexecuted");
	}
	public static void TC4_Test_ForgotPassword() throws InterruptedException
	{
		driver.findElement(By.linkText("Login")).click();
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys("seemakurthikalyani@gmail.com");
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@id='forgot_password_link']")).click();
	
		driver.findElement(By.xpath("//input[@id='un']")).click();
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		driver.close();
		System.out.println("tc4 isbexecuted");
	}
	public static void Tc5_Selectusemenu_usernamedropdown() throws InterruptedException
	{
		
		WebElement usermenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
		usermenu.click();
		Thread.sleep(4000);
		WebElement profiletab=driver.findElement(By.xpath("//a[@title='My Profile']"));
		profiletab.click();
		driver.close();
		System.out.println("tc5 isbexecuted");
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
		driver.switchTo().frame(iframe);
		WebElement about=driver.findElement(By.id("aboutTab"));
		about.click();
		WebElement lastname=driver.findElement(By.name("lastName"));
		lastname.clear();
		lastname.sendKeys("D");
		Thread.sleep(4000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contactInfoContentId");
		
		System.out.println("user menu is displayed");
		
		WebElement saveall=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]"));
		
		saveall.click();
		
		driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'Post')]")).click();
		
		Thread.sleep(4000);

		
		System.out.println("postlink");
		
		
		driver.findElement(By.xpath("//a[contains(@title,'Profile Tab - Selected')]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'Post')]")).click();
		WebElement iframe1=driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, publisherRichTextEditor']"));
        
		driver.switchTo().frame(iframe1);
		WebElement textbox=  driver.findElement(By.xpath("/html[1]/body[1]"));
		textbox.click();
		textbox.sendKeys("hello hi");
		driver.switchTo().defaultContent();
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
		  System.out.println("tc6 isbexecuted");
		
	}
}
