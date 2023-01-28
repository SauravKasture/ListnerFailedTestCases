package swaglab_DDF_07;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.Return;

public class SwagLabChekOutcomplete 
{
	@FindBy(xpath="//h2[text()='THANK YOU FOR YOUR ORDER']") private WebElement thankyou;
	@FindBy(xpath = "//button[text()='Back Home']") private WebElement backtohome;
	public SwagLabChekOutcomplete(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String VerifySwagLabChekOutCompletepage()
	{
		String actRe = thankyou.getText();
			return actRe;
	}
	
	public void clickSwagLabChekOutcompletebacktohomebtn()
	{
		backtohome.click();
	}

}
