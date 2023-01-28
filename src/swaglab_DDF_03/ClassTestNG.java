package swaglab_DDF_03;

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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ClassTestNG extends BaseClass
{
	SwagLabLoginPage login;
	SwagLabHomePage home;
	SwagLabOpenMenuPage menu;
	int TCID;
	@Parameters("BrowserName")
	@BeforeClass
	public void openBrowser(String BrowserName) throws EncryptedDocumentException, IOException
	{
		openBroswer(BrowserName);
		
		login= new SwagLabLoginPage(m);
		home = new SwagLabHomePage(m);
		menu= new SwagLabOpenMenuPage(m);
		
	}
	@BeforeMethod
	public void loginINSwagLab() throws EncryptedDocumentException, IOException
	{
		login.inpSwagLabLoginPageusername(UtilityClass.getDataFromPF("username"));
		login.inpSwagLabLoginPagepassword(UtilityClass.getDataFromPF("password"));
		login.clickSwagLabLoginLoginbtn();
	}
	@Test
	public void verifySwagLabHomePageLogo()
	{
		TCID=107;
		boolean actResult = home.getSwagLabHomePageLogo();
		Assert.assertFalse(actResult);
		
	}
	
	@Test (priority = 1)
	public void verifySwagLabHomeAddCartbutton() throws EncryptedDocumentException, IOException
	{
		TCID=108;
		home.clickSawgLabHomeAddToCART();
		String remove = home.verifySwagLabHomeRemove();
		Assert.assertNotEquals(remove, UtilityClass.getData(2, 0));
	}
	
	@AfterMethod 
	public void logoutFromSwagLab(ITestResult s) throws IOException
	{
		
		if(s.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureScreenshot(m);
		}
		home.clickSwagLabHomPageOpenMenu();
		menu.clickSawgLabOpenmenuLogout();
	}
	
	@AfterClass
	public void clsoeBrowser()
	{
		m.close();
	}

}
