package swaglab_DDF_07;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SwagLabTestNG extends BaseClass
{
	SwagLabLoginPage login;
	SwagLabHomePage home;
	SwagLabOpenMenuPage menu;
	SawgLabCartPage cart;
	SwagLabCheckOutPage checkout;

	int TCID;
	
	@BeforeClass
	public void Broswerinvoke() throws IOException
	{
		OpenBrowser();
		login= new SwagLabLoginPage(m);
		home= new SwagLabHomePage(m);
		menu= new SwagLabOpenMenuPage(m);
		cart = new SawgLabCartPage(m);
		checkout= new SwagLabCheckOutPage(m);
		
		
	}
	@BeforeMethod
	public void login() throws EncryptedDocumentException, IOException
	{
		login.inpSwagLabLoginPageusername(UtilityClass.getDataFPropertyFile("username"));
		login.inpSwagLabLoginPagepassword(UtilityClass.getDataFPropertyFile("password"));
		login.clickSwagLabLoginLoginbtn();
	}
	@Test (priority = 1)
	public void verifylog() throws InterruptedException
	{
		TCID=117;
		boolean act = home.verifySwagLabHomePageLogo();
		Assert.assertFalse(act,"Fail: logo is not present on home page");
		Thread.sleep(2000);
		
	}
	
	@Test(priority = 2)
	public void verifySwagLabHomePageAddtoCartRemovebutton() throws EncryptedDocumentException, IOException, InterruptedException
	{
		TCID=118;
		home.clickSawgLabHomeAddToCART();
		String act = home.verifySwagLabHomeRemove();
		Assert.assertNotEquals(act, UtilityClass.getData(2, 0),"fail: Addto Cart button Not working ");
		Thread.sleep(2000);
		
	}
	
	@Test (priority = 3)
	public void verifySawgLabHomeListBOxA_Z() throws InterruptedException
	{
		TCID=119;
		boolean listbox = home.SelectSwagLabHomeA_z();
		Assert.assertTrue(listbox,"fail: liastbox is multiselected");
		Thread.sleep(2000);
	}
	
	@Test(priority = 4)
	public void verifySwagLabCartPageTitle() throws EncryptedDocumentException, IOException, InterruptedException
	{
		TCID=120;
		home.clickSwagLabHomePagCart();
		String Title = cart.verifySwabLabCartPageTitle();
		Assert.assertNotEquals(Title, UtilityClass.getData(3, 0));
		Thread.sleep(2000);
		m.navigate().back();
	}
	
	@Test (priority = 5, enabled = false)
	public void verifySwagLabChekoutPageTiltle() throws EncryptedDocumentException, IOException, InterruptedException
	{
		TCID=121;
		home.clickSwagLabHomPageOpenMenu();
		cart.clickSwagLabCartPageCheckOUT();
		String Tilte = checkout.VerifySwagLabCheKOutPageTitle();
		Assert.assertNotEquals(Tilte, UtilityClass.getData(4, 0),"fail: Title is not present on checkOUT page");
		Thread.sleep(2000);
		m.navigate().back();
		m.navigate().back();
	}
	
	@Test (priority = 6)
	public void verifySwagLabCheKOutErrorOnSumbitButn() throws EncryptedDocumentException, IOException, InterruptedException
	{
		TCID=122;
		home.clickSwagLabHomePagCart();
		cart.clickSwagLabCartPageCheckOUT();
		checkout.clickSwagLabChekOutContinueButn();
		String error = checkout.verifySwagLabCheKOutErrorOnSumbitButn();
		Assert.assertNotEquals(error, UtilityClass.getData(5, 0),"Fail:Error not maatching");
		Thread.sleep(2000);
		m.navigate().back();
		m.navigate().back();
		
		 
	}
	
	
	@AfterMethod
	public void lougoutFromApp(ITestResult S) throws InterruptedException, IOException
	{
		if(S.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureSceenshot(m, TCID);
		}
		home.clickSwagLabHomPageOpenMenu();
		Thread.sleep(2000);
		menu.clickSawgLabOpenmenuLogout();
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void closeBroswer()
	{
		m.close();
		
	}

}
