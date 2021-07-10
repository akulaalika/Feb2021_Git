package addCustomerForm;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerForm {

	// declaring a global variable
	WebDriver driver;

	@Before
	public void init() {

		// getting the webdriver
		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	// carrying out functional testing
	@Test
	public void newAccountOpening() throws InterruptedException {

		// input of username, password and submit button

		WebElement USERNAME_ELEMENT = driver.findElement(By.xpath("//input[@name='username']"));
		USERNAME_ELEMENT.sendKeys("demo@techfios.com");

		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
		PASSWORD_ELEMENT.sendKeys("abc123");
		WebElement LOGIN_ELEMENT = driver.findElement(By.xpath("//button[@name='login']"));
		LOGIN_ELEMENT.click();
		Thread.sleep(2000);
		WebElement DASHBOARD_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(),' Dashboard ')]"));

		// Assert.assertTrue(" title not displayed ", DASHBOARD_ELEMENT.isDisplayed());
		Assert.assertEquals("dashboard page not found", "Dashboard", DASHBOARD_ELEMENT.getText());
		// clicking customers combo and then add customerF
		WebElement CUSTOMER_BUTTON_ELEMENT = driver.findElement(By.linkText("Customers"));
		CUSTOMER_BUTTON_ELEMENT.click();

		WebElement ADD_CUSTOMER_ELEMENT = driver.findElement(By.linkText("Add Customer"));
		ADD_CUSTOMER_ELEMENT.click();

		// webElement lib for the Add contacts webpage
		Thread.sleep(5000);

		WebElement ADD_CONTACTS_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(), ' Contacts ')]"));

		Assert.assertEquals(" title not displayed ", "Contacts", ADD_CONTACTS_ELEMENT.getText());

		// to populate the contact form

		WebElement FIRSTNAME_ELEMENT = driver.findElement(By.xpath("//input[@id = 'account']"));
		FIRSTNAME_ELEMENT.sendKeys("Mike");

		WebElement COMPANY_ELEMENT = driver.findElement(By.xpath("//select[@id = 'cid']"));
		COMPANY_ELEMENT.click();

		Select sel = new Select(COMPANY_ELEMENT);
		sel.selectByVisibleText("Agency for the Performing Arts");
		WebElement EMAIL_ELEMENT = driver.findElement(By.xpath("//input[@id ='email']"));
		EMAIL_ELEMENT.sendKeys("akalaalika@gmail.com");

		WebElement PHONE_ELEMENT = driver.findElement(By.xpath("//input[@id ='phone']"));
		PHONE_ELEMENT.sendKeys("1234567890");

		WebElement ADDRESS_ELEMENT = driver.findElement(By.xpath("//input[@id ='address']"));
		ADDRESS_ELEMENT.sendKeys("890 ABA ROAD ");

		WebElement CITY_ELEMENT = driver.findElement(By.xpath("//input[@id ='city']"));
		CITY_ELEMENT.sendKeys("DALLAS ");

		WebElement STATE_ELEMENT = driver.findElement(By.xpath("//input[@id ='state']"));
		STATE_ELEMENT.sendKeys("TEXAS ");

		WebElement ZIP_ELEMENT = driver.findElement(By.xpath("//input[@id ='zip']"));
		ZIP_ELEMENT.sendKeys("75006 ");

		// Choosing from the country drop down list
		WebElement COUNTRY_ELEMENT = driver.findElement(By.xpath("//select[@id ='country']"));
		// using the instance of the Select class to choose the country

		Select sel2;
		sel2 = new Select(COUNTRY_ELEMENT);
		sel2.selectByVisibleText("Western Sahara");
		Thread.sleep(5000);
		// getting the list of options in the dropdown with getOptions()
		List<WebElement> OPTION = sel2.getOptions(); // create a webElement list
		int size = OPTION.size();
		
		  for (int i = 0; i < size; i++) { 
			  String options = OPTION.get(i).getText();
			  System.out.println(options);	
		}
		
		System.out.println("the number of countries in the country drop down combo is     :"  + size);
			WebElement SUBMIT_ELEMENT = driver.findElement(By.xpath("//button[@id ='submit']"));
			// SUBMIT_ELEMENT.click();
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();

			
		}
	

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
