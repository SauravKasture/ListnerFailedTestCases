package swaglab_DDF_03;

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
	//used to fetch data from excel sheet 
	//need two input : 1.rowIndex, 2. cellIndex 
	//@Athor name: Saurav
	public static String getData(int rowIndex,int cellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream m = new FileInputStream("F:\\Excel\\Book1.xlsx");
		String result = WorkbookFactory.create(m).getSheet("Sheet5").getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return result;
	}
	
	
	//used to capture screen shot 
	//need two input : 1. WebDriver object, 2. TCID
	//@Author name : Saurav
	public static void captureScreenshot(WebDriver driver) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File des= new File("F:\\ScreenShotsel\\TCID."+"jpg");
		FileHandler.copy(src, des);
		 
	}
	
	
	
	//used to fetch data from property file 
	//need one input : String key
	//@Author name: Saurav
	public static String getDataFromPF(String key) throws IOException
	{
		FileInputStream  n= new FileInputStream("D:\\eclipse\\Listner_TestNG_FailedTestCase\\SwagLab3.properties");
		Properties m= new Properties();
		m.load(n);
		String value = m.getProperty(key);
		return value;
	
	}

}
