package platform;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromePlatform  {

	final static Logger logger = Logger.getLogger(ChromePlatform.class);


	

	public WebDriver getLocalWebDriver() {
	    
		
		logger.info("Inciando o Chrome local");
		
		String path = Paths.get("").toAbsolutePath().toString();
		System.setProperty("webdriver.chrome.driver",path+"\\src\\test\\resources\\chromeDriver\\chromedriver.exe");

		
		WebDriver webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.get("https://www.icarros.com.br/principal/index.jsp");

		return webDriver;
	}

}