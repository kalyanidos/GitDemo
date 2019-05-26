

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SDFCmain  {

	
	static ExtentReports report;
	
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		report=new ExtentReports("C:\\Users\\seema\\OneDrive\\Desktop\\Report1.html",true);
		String path="C:\\Users\\seema\\OneDrive\\Desktop\\Report1.html";
		report=new ExtentReports(path);
		//logger =report.startTest("SDFC testcases");
		
		
		//sdfc.initialize_driver();
		//sdfc.Launch_UrL();
		//sdfc.Login();
		
		//sdfc.Tc2_Login_Salesforce();
		//sdfc.TC4_Test_ForgotPassword();
//		SDFClogin sdfc5=new SDFClogin ();
//		SDFClogin.Tc5_Selectusemenu_usernamedropdown();
		
//		SDFClogin sdfc6=new SDFClogin ();
//		SDFClogin.Tc6_Editprofile_Data();
//		
//		SDFClogin sdfc7=new SDFClogin ();
//		SDFClogin.Tc7_usernamedropdwn();
		SDFClogin sdfc=new SDFClogin ();
		SDFClogin.Tc8_developerconsoledata();
//		SDFClogin sdfc3=new SDFClogin();
//		SDFClogin.Tc3_Test_the_rememberUsername_check();
//		SDFClogin sdfc9=new SDFClogin();
//		SDFClogin.Tc9_SelectLogoutUser_menu();
//		
		//SDFClogin sdfc10=new SDFClogin ();
	    //SDFClogin.Tc10_Create_acc();
//	    
//	    SDFClogin sdfc11=new SDFClogin ();
//	    SDFClogin.tc11_Create_new_view();
//		
//	    SDFClogin sdfc12=new SDFClogin ();
//	    SDFClogin.Tc12_EditView ();
//		
//	    SDFClogin sdfc13=new SDFClogin();
//	    SDFClogin.tc13_mergeacc();
//		
	   //sdfc.t14_createAcc();
	   //sdfc.tc15_opertunites();
		//sdfc.tc16_newopty();
		//sdfc.Tc17_opp();
		//sdfc.tc18_stuckopp();
		//sdfc.tc19_open_or_close();
//		SDFClogin sdfc20=new SDFClogin();
//		SDFClogin.tc20_leads();
	    
		//SDFClogin sdfc21=new SDFClogin();
		//SDFClogin.tc21_view();
		
		//sdfc.tc22_defaultpage ();
		//sdfc.tc23_todayslead();
		//sdfc.tc24_newlead();
		//sdfc.tc25_contacts();
		
		//sdfc.tc26_createnewviewcontacts();
		//sdfc.tc27_Checkrecentlycreatedcontacts();
		//sdfc.tc28_Mycontactviewcontact();
		//sdfc.tc29_viewcontactsincontacts();
		//sdfc.tc30_creatingnewviewcontacts();
		//sdfc. tc31_cancel_contacts();
		//sdfc.tc32_saveandnewbutoonincontacts();
		//sdfc. tc33_home ();
		//sdfc.tc34_verifylastname();
		//sdfc.tc35_removebutton();
		//sdfc.tc36_currentDateLink();
		//sdfc.tc36_currentDateLink();
		
	SDFCmain.report.flush();
	}

}
