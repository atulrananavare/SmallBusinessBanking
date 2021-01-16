package com.inetbanking.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	ReadConfig readConfig= new ReadConfig();
	
	
	public String baseURL=readConfig.getApplicationURL();
	public String userName=readConfig.getUserName();
	public String password=readConfig.getpassword();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
			
		logger= Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getchromepath());
			driver= new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readConfig.getfirefoxpath());
			driver= new FirefoxDriver();
		}
		else if(br.equals("ie")){
			System.setProperty("webdriver.ie.driver", readConfig.getIEpath());
			driver= new InternetExplorerDriver();
		}
		
		driver.get(baseURL);
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
