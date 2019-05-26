package ReUsable;

import org.openqa.selenium.WebElement;

public class reuse {

	public static void enterText(WebElement obj,String textval,String objName) throws InterruptedException

	{
		if(obj.isDisplayed())
		{
			Thread.sleep(4000);
			obj.sendKeys(textval);
			System.out.println("pass: "+textval+"value is entered"+objName+"field");
			
		}
		else
		{
			System.out.println("fail:" +objName+ "field does not exist please check application");
		}
	}
}
