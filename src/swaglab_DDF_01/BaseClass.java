package swaglab_DDF_01;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass
{
	WebDriver m;
	public void initializeBrowser()
	{
		 m= new ChromeDriver();
		 m.get("https://www.saucedemo.com/");
		 m.manage().window().maximize();
		 m.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 
		 
	}
	
}
