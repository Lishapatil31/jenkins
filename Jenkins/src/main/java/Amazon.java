import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	 WebDriver driver;
	
@BeforeMethod
public void launch()
{
    WebDriverManager.chromedriver().setup();
     ChromeOptions options = new ChromeOptions();
     driver=new ChromeDriver(options);
     driver.manage().deleteAllCookies();
     driver.get("https://www.amazon.in/");
     driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
     driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }

@Test
public void verifyTitle() {
	String actualTitle=driver.getTitle();
	String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	Assert.assertEquals(actualTitle, expectedTitle);
}

@Test
public void logo() {
	boolean flag=driver.findElement(By.xpath("//a[@class='nav-logo-link nav-progressive-attribute']")).isDisplayed();
	Assert.assertTrue(flag);
}
	
@AfterMethod	
public void tearDown() {
	driver.quit();
}

}
   
