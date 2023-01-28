package swaglab_DDF_04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class TestNG4 extends BaseClass
{
	
	
	SwagLabLoginPage login;
	SwagLabHomePage home;
	SwagLabOpenMenuPage menu;
	int TCID;
	@BeforeClass
	public void openBrowser() throws IOException
	{
		OpenBrowser();
		
		
		login= new SwagLabLoginPage(m);
		home = new SwagLabHomePage(m);
		menu= new SwagLabOpenMenuPage(m);
	}
	
	@BeforeMethod
	public void loginSwagLabApp() throws EncryptedDocumentException, IOException
	{
		
		login.inpSwagLabLoginPageusername(UtilityClass.getDataFromPropertyFile("username"));
		login.inpSwagLabLoginPagepassword(UtilityClass.getDataFromPropertyFile("password"));
		login.clickSwagLabLoginLoginbtn();
	}
	
	@Test 
	public void verifyLogoswagLabHome()
	{
		TCID=110;
		boolean actre = home.verifySwagLabHomePageLogo();
		Assert.assertFalse(actre,"Failed : result not match ");
	}
	@Test (priority = 1)
	public void verifySwagLabHomePageListBoxA_Z()
	{
		TCID=111;
		boolean actR = home.getSelectSwagLabHomeA_z();
		Assert.assertTrue(actR);
		
	}
	@Test (priority = 2)
	public void verifySwagLabHomePageAddCartBut() throws EncryptedDocumentException, IOException
	{
		TCID=112;
		home.clickSawgLabHomeAddToCART();
		String actRs = home.verifySwagLabHomeRemove();
		Assert.assertNotEquals(actRs, UtilityClass.getData(2, 0),"fail: not match ");
	}
	
	
	@AfterMethod
	public void logoutFromSwagLab(ITestResult S) throws IOException
	{
		if(S.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureScreenshot(m, TCID);
		}
		
		home.clickSwagLabHomPageOpenMenu();
		menu.clickSawgLabOpenmenuLogout();
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		m.close();
		
	}

}
