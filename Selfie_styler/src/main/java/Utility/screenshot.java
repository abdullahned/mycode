package Utility;

import java.io.File;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;


public class screenshot {
	
	public static WebDriver driver;
	
	public static void capturescreenshot (WebDriver driver, String screenshotname)
	
	{
		
		try {
			TakesScreenshot ts= (TakesScreenshot)driver;
			 File source =ts.getScreenshotAs(OutputType.FILE);
			 FileUtils.copyFile(source, new File("C:\\Users\\m.abdullah\\git\\Selfie_styler_updated\\Selfie_styler\\Failed-testcase-screenshots\\"+screenshotname+".png"));

		}
           catch (Exception e) {
			
        	   
		System.out.println("Exception while taking screenshot" +e.getMessage());
			                   
           }
		
		
		
		}
	
	public static void teardown(ITestResult result) 
	  {
		  
		  if(ITestResult.FAILURE ==result.getStatus())
			  
		  {
			  screenshot.capturescreenshot(driver, result.getName());
		  }
		  
		  
	  }
	

	
}

	