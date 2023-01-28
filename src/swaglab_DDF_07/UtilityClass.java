package swaglab_DDF_07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass
{
	public static String getData(int rowIndex,int cellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("F:\\Excel\\Book1.xlsx");
		String result = WorkbookFactory.create(file).getSheet("sheet5").getRow(rowIndex).getCell(cellIndex).getStringCellValue();
	
		return result;
	}
	
	
	public static void captureSceenshot(WebDriver driver,int TCID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dec= new File("F:\\ScreenShotsel\\TCID"+TCID+".jpg");
		
		FileHandler.copy(src, dec);
	}
	
	//used to fetch data from property file
	//need one input : String key
	//@Author name:Saurav
	public static String getDataFPropertyFile(String Key) throws IOException
	{
		FileInputStream file= new FileInputStream("D:\\eclipse\\Listner_TestNG_FailedTestCase\\SwagLab6.properties");
		Properties p = new Properties();
		p.load(file);
		String value = p.getProperty(Key);
		return value;
	
	}
}
