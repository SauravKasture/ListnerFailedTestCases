package swaglab_DDF_07;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabChekOutOverView 
{
	@FindBy(xpath="//span[text()='Checkout: Overview']") private WebElement title;
	@FindBy(xpath="//button[@id='finish']") private WebElement finish;
	
	public SwagLabChekOutOverView(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifySwagLabChekOutOverViewTitle()
	{
		String act = title.getText();
		return act;
		
	}
	
	public void clickSwagLabChekOutOverViewFinishbtn()
	{
		finish.click();
	}
	

}
