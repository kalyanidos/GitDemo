package ReUsable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class reusable extends reuse {
static WebDriver driver;
	
public  reusable() throws InterruptedException {
		
			initialize_driver();
			Launch_UrL();
			Login1();
			
		}
		
		public static  void initialize_driver()
		{
//			System.setProperty("webdriver.chrome.driver", "C:\\Users\\seema\\Selenium\\chromedriver_win32\\chromedriver.exe");
//			 driver=new ChromeDriver();
			 System.setProperty("webdriver.gecko.driver", "C:\\Users\\seema\\Selenium\\geckodriver-v0.23.0-win64 (1)\\geckodriver.exe");

			 driver=new FirefoxDriver();
		}
		public static void Launch_UrL()
		{
			driver.get("https://www.salesforce.com/");
			driver.manage().window().maximize();
		}
		public static  void Login1() throws InterruptedException
		{
			
			driver.findElement(By.linkText("Login")).click();
			WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
//			username.sendKeys("seemakurthikalyani@gmail.com");
			enterText(username, "seemakurthikalyani@gmail.com", "username");
			WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
			enterText(password, "satish098*", "password");
			//password.sendKeys("satish098*");
			driver.findElement(By.xpath("//input[@id='Login']")).click();
			//Thread.sleep(4000);
			
			
			
	    
		
	}
		
		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			reusable re=new reusable();
			
			reusable.Login1();

}
		}
