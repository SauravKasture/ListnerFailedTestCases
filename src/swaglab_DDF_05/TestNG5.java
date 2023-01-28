package swaglab_DDF_05;

import java.io.File;
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



public class TestNG5 extends BaseClass
{
	
	SwagLabLoginPage login;
	SwagLabHomePage home;
	SwagLabOpenMenuPage menu;
	SawgLabCartPage cart;
	int TCID;
	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException
	{
		InvokeBrowser();
		
		login= new SwagLabLoginPage(m);
		home= new SwagLabHomePage(m);
		menu= new SwagLabOpenMenuPage(m);
		cart = new SawgLabCartPage(m);
		
	}
	
	@BeforeMethod
	public void loginSwagLab() throws IOException, InterruptedException
	{
		
		login.inpSwagLabLoginPageusername(UtilityClass.getDataFromPropertyFile("username"));
		login.inpSwagLabLoginPagepassword(UtilityClass.getDataFromPropertyFile("password"));
		login.ScreenshotSwagLabLoginPageLogo();
		Thread.sleep(2000);
		login.clickSwagLabLoginLoginbtn();
		
		
	}
	
	@Test(priority = 1)
	public void verifySwagLabHomeLogo() throws InterruptedException
	{
		TCID=113;
		boolean actr = home.verifySwagLabHomePageLogo();
		Assert.assertFalse(actr);
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void VerifySwagLabHomeListBoxA_Z() throws InterruptedException
	{
		
		TCID=114;
		boolean act=home.SelectSwagLabHomeA_z();
	
		
		Assert.assertTrue(act,"failed : not match");
		Thread.sleep(2000);
		
		
	}
	
	@Test(priority = 3)
	public void verifySwagHomePageAddCart() throws InterruptedException, EncryptedDocumentException, IOException
	{
		TCID=115;
		home.clickSawgLabHomeAddToCART();
		String actre = home.verifySwagLabHomeRemove();
		
		Assert.assertNotEquals(actre, UtilityClass.getData(2, 0),"Failed: not match");
		Thread.sleep(2000);
		
	}
	
	@Test(priority = 4)
	public void verifySwagLabAddcartPageTitle() throws InterruptedException, EncryptedDocumentException, IOException
	{
		
		TCID=116;
		home.clickSwagLabHomePagCart();
		String actR = cart.verifySwabLabCartPageTitle();
		
		Assert.assertNotEquals(actR, UtilityClass.getData(3, 0));
		Thread.sleep(2000);
		
		m.navigate().back();
	}
	
	@AfterMethod
	public void logout(ITestResult s) throws InterruptedException, IOException
	{
		
		if(s.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureScreenShot(m, TCID);
		}
		home.clickSwagLabHomPageOpenMenu();
		Thread.sleep(2000);
		menu.clickSawgLabOpenmenuLogout();
		
	}
	@AfterClass
	public void closeBrowser()
	{
		m.close();
		
	}

}
