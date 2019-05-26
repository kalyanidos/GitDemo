import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class reusable {
	static ExtentTest logger;
//	static ExtentReports report;
	
	/* name of the method:   entertext
	 * BriefDescription  :   enetering textvalue for textboxes 
	 * Arguments         :  obj-->object
	 *                      textval--->to be entered 
	 *                      objName--->object name
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */
	public static void enterText(ExtentTest logger,WebElement obj,String textval,String objName) throws InterruptedException

	{
		if(obj.isDisplayed())
		{
			Thread.sleep(4000);
			obj.sendKeys(textval);
			//System.out.println("pass: "+textval+"value is entered"+objName+"field");
			logger.log(LogStatus.PASS,textval+"value is entered"+objName+"field");
			//SDFCmain.report.flush();
		}
		else
		{
			System.out.println("fail:" +objName+ "field does not exist please check application");
			//logger.log(LogStatus.FAIL,textval+objName+"field does not exist please check application");
		}
	}
	/* name of the method:   clickobject--->Button
	 * BriefDescription  :   clicking a button
	 * Arguments         :  obj-->object,objName--->object name
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */
	public static void clickObj(WebElement obj,String objName)
	{
		if(obj.isDisplayed())
		{
			obj.click();
			System.out.println("pass :" +objName + "button is clicked");
		}
		else
		{
			System.out.println("Fail:" +objName+"button is not displayed ,please check the application");
		}
	}
	/* name of the method:   selectcheckbox for checkbox
	 * BriefDescription  :   checkbox on,checkbox of 
	 * Arguments         :  obj-->object,objName--->object name                     
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */
	public static void selectcheckbox(WebElement obj,String objName)
	{
		if(obj.isDisplayed())
		{
			System.out.println(objName+"is present");
			if(obj.isSelected())
			{
				System.out.println("pass:"+objName+"is alredy selected");
			}
			else
			{
				obj.click();
				System.out.println("pass:" +objName+ "is now clicked");
			}
		}
	}
	
	/* name of the method:   deselectcheckbox
	 * BriefDescription  :   deselectcheckbox 
	 * Arguments         :  obj-->object,objName--->object name                     
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */
	public static void deselectcheckbox(WebElement obj,String objName)
	{
		if(obj.isEnabled())
		{
			obj.click();
			System.out.println("pass:" +objName+"is disabled");
			
			
				//System.out.println("pass:"+objName+"is alredy selected");
		}	
			
			else
			{
				
				System.out.println("Fail:" +objName+ "is not deselected");
			}
		}
		
	/* name of the method:  dropdown
	 * BriefDescription  :   dropdown 
	 * Arguments         :  obj-->object,objName--->object name                     
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */
	public static void dropdown(WebElement obj,String objName)	
	{
		if(obj.isDisplayed()) {
			if(obj.isSelected()) {
				System.out.println("Pass: "+objName+" is already selected");
			}else{
			obj.click();
			System.out.println("Pass: "+objName+" is now selected");
		    }
			}
			else {
			System.out.println("Fail:"+objName+" is not present Please chk application");			
		}	
	}
	/* name of the method: radioButton
	 * BriefDescription  :   radioButton 
	 * Arguments         :  obj-->object,objName--->object name                     
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */
	
	public static void radioButton(WebElement obj, String objName) {
		if(obj.isDisplayed()) {
			if(obj.isSelected()) {
				System.out.println("Pass: "+objName+" is already selected");
			}else{
			obj.click();
			System.out.println("Pass: "+objName+" is now selected");
		    }
			}
			else {
			System.out.println("Fail:"+objName+" is not present Please chk application");			
		}	
	}
	
		
	
	/* name of the method:   iFrame
	 * BriefDescription  :   iframe using webelement 
	 * Arguments         :  driver--->driver 
	 *                      obj--->webelement
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */
	public static void switchFrame( WebDriver driver,WebElement obj) {
		 
	    if(obj.isDisplayed()) {
	     driver.switchTo().frame(obj);
	     System.out.println("Pass: we can switch to the "+obj+ " frame");
	    }else {
	     System.out.println("fail: we can't switch to the "+obj+ " frame");
	    }
	 }
	/* name of the method:   switchFrameid
	 * BriefDescription  :   iframe using webelement 
	 * Arguments         :  driver--->driver 
	 *                      obj--->iframe id
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */
	public static void switchFrameid( WebDriver driver,String obj) {
		 
	     driver.switchTo().frame(obj);
	     System.out.println("Pass: we can switch to the "+obj+ " frame");
	    }
	/* name of the method:   switchdefaultFrame
	 * BriefDescription  :   iframe for switching back to default frame 
	 * Arguments         :  driver--->driver 
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */ 
	public static void switchdefaultFrame( WebDriver driver)
	{
	driver.switchTo().defaultContent();
	System.out.println("Pass: we can switch to the "+driver+ " back to frame");
}
	/* name of the method:   selectDropdown
	 * BriefDescription  :   selected by clicking the dropdown 
	 * Arguments         :  obj,objName 
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */ 
	public static void SelectbyText(WebElement we, String VisibleText){
		   if(we.isDisplayed())
		   {
			   Select selObj=new Select(we);
	           selObj.selectByVisibleText(VisibleText);
		           System.out.println("Pass: "+VisibleText+ " is Sected by VisibleText" );
		   } 
		   else
		   {
		    System.out.println("Fail: "+VisibleText+ " is not available");
		   }
		   }
	/* name of the method:   SelectByindex
	 * BriefDescription  :   selected by clicking the dropdown 
	 * Arguments         :  obj,index 
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */ 
	public static void SelectByindex(WebElement obj, int index) {
		  if(obj.isSelected()) {
		   Select selObj=new Select(obj);
		    
		   selObj.selectByIndex(index);
		  System.out.println("pass:"+index + " is selected from drop down ");
		  }else {
		   System.out.println("Fail:"+index+"is not selected");
		  }
		 }
		   
	/* name of the method:   SelectByValue
	 * BriefDescription  :   selectedByValue by clicking the dropdown 
	 * Arguments         :  obj,index 
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */ 
	public static void SelectByValue(WebElement obj, String val) {
		  if(obj.isSelected()) {
		   Select selObj=new Select(obj);
		    
		   selObj.selectByValue(val);
		  System.out.println("pass:"+val + " is selected from drop down ");
		  }else {
		   System.out.println("Fail:"+val+"is not selected");
		  }
		 }	   
	/* name of the method:   mouseOver
	 * BriefDescription  :    
	 * Arguments         :  obj,index 
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */ 
		public static void mouseOver(WebDriver driver,WebElement obj) {
			if(obj.isDisplayed()) {
		   Actions action=new Actions(driver);
		   action.moveToElement(obj).build().perform();
			System.out.println("Pass: "+obj+" is present");
			}
	     else {
				System.out.println("Fail:"+obj+" is not present.Please chk application");
			}
		}
		/* name of the method:   switchtoAlert
		 * BriefDescription  :   Switch to alert
		 * Arguments         :  driver,obj
		 *  createdby        :  Automation team 
		 *  created date     :02/13/19 
		 *  LastModified Date:02/13/19          
		 */ 
		public static void switchtoAlert(WebDriver driver,Alert alert) {
			if(alert.equals(alert))
			{
				alert=driver.switchTo().alert();
				alert.accept();
			 System.out.println("Pass: "+alert+" is present");
	    }
			else
			{
				System.out.println("Fail: "+alert+" is not present");	
			}
		}
			
		
		/* name of the method:   validateErrorMsg
		 * BriefDescription  :   validateErrorMsg
		 * Arguments         :  actuvalmsg,errormsg
		 *  createdby        :  Automation team 
		 *  created date     :02/13/19 
		 *  LastModified Date:02/13/19          
		 */
		public static void validateErrorMsg(String actualmsg , String errormsg) {
			if(actualmsg.equals(errormsg))
		    {
		     System.out.println("Test Case Pass");
		    }else
		    {
		     System.out.println("Test Case Fail");
		    }			
		 }
		/* name of the method: clickinglink
		 * BriefDescription  :clickinglink    
		 * Arguments         :driver,obj
		 *  createdby        :  Automation team 
		 *  created date     :02/13/19 
		 *  LastModified Date:02/13/19          
		 */ 
			public static void clickinglink(WebDriver driver,String obj) {
				if(obj.equals(obj)) {
					driver.get(obj);
				System.out.println("Pass: "+obj+" is present");
				}
		     else {
					System.out.println("Fail:"+obj+" is not present.Please chk application");
				}
			}
	
	
}
		
	

