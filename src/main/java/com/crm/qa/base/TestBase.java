package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver dr;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public  TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream ip= new FileInputStream("E:\\sujithwp\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void initialization(){
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","E:\\selenium\\drivers\\chromedriver.exe");		
			dr =new ChromeDriver();
		}else if(browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver","E:\\selenium\\drivers\\geckodriver.exe");		
				dr=  new FirefoxDriver();
		}else if(browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver","E:\\selenium\\drivers\\MicrosoftWebDriver.exe");		
			dr=  new EdgeDriver();

			
		}
		 e_driver = new EventFiringWebDriver(dr);
		 //now create object of EventlisterHandler to register it with EventFiringWebDriver 
		
		  eventListener = new WebEventListener();
		 e_driver.register(eventListener);
		 dr= e_driver;
		 
			dr.manage().window().maximize();
			dr.manage().deleteAllCookies();
			dr.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
			dr.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
			dr.get(prop.getProperty("url"));
		
	}
	
}
