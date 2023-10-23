import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_AutomationAnywhere {
	
	public static void main(String args[]) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String url = "https://www.automationanywhere.com/";
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//List of WebElements
		WebElement logo = driver.findElement(By.xpath("//div[@class='coh-container nav-logo-wrap']//img[@class='coh-image coh-image-responsive-xl']"));
		WebElement requestDemoButton = driver.findElement(By.xpath("//div[@class='coh-container utility-navbtn']//a[@title='Request Demo']"));
		WebElement acceptCookiesButton = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
		WebElement productsLink = driver.findElement(By.xpath("//a[text()='Products']"));
		WebElement solutionsLink = driver.findElement(By.xpath("//a[text()='Solutions']"));
		WebElement resourcesLink = driver.findElement(By.xpath("//a[text()='Resources']"));
		WebElement beyondRpaLink = driver.findElement(By.xpath("//li[@class='coh-menu-list-item aboutRPANav nav-head coh-ce-71c1a106 js-coh-menu-item has-children is-collapsed']//a[text()='Beyond RPA']"));
		WebElement companyLink = driver.findElement(By.xpath("//a[text()='Company']"));
		
		// List of URLs
		String productsUrl = "https://www.automationanywhere.com/products";
		String solutionsUrl = "https://www.automationanywhere.com/solutions";
		String resourcesUrl = "https://www.automationanywhere.com/resources";
		String beyondRpaUrl = "https://www.automationanywhere.com/rpa/robotic-process-automation";
		String companyUrl ="https://www.automationanywhere.com/company/about-us";
		
		// Code for accept cookies button
		if(acceptCookiesButton.isDisplayed() && acceptCookiesButton.isEnabled()) {
			acceptCookiesButton.click();
		}
		
		// Code for scrolling down using java script executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		// Code for finding the logo tag name
		if(logo.isDisplayed()) {
			System.out.println("Automation Anywhere Logo tag: "+logo.getTagName());
		}
		
		//Code for clicking on the Request Demo Button
		if(requestDemoButton.isDisplayed() && requestDemoButton.isEnabled()) {
			requestDemoButton.click();
			System.out.println("URL after clicking on Request Demo Button: " +driver.getCurrentUrl());
			driver.navigate().back();
		}else {
			System.out.println("Error");
		}
		
		// Code for clicking on - Products Link
		try {
			productsLink.click();
			System.out.println("URL after clicking on Products Link: "+driver.getCurrentUrl());
		}catch(Exception e) {
			productsLink = driver.findElement(By.xpath("//a[text()='Products']"));
			productsLink.click();
			if(productsUrl.equals(driver.getCurrentUrl()))
				System.out.println("URL after clicking on Products Link: "+driver.getCurrentUrl());
		}
		
		// Code for clicking on - solutions Link
		try {
			solutionsLink.click();
			System.out.println("URL after clicking on Products Link: "+driver.getCurrentUrl());
		}catch(Exception e) {
			solutionsLink = driver.findElement(By.xpath("//a[text()='Solutions']"));
			solutionsLink.click();
			if(solutionsUrl.equals(driver.getCurrentUrl()))
				System.out.println("URL after clicking on Solutions Link: "+driver.getCurrentUrl());
		}
		
		// Code for clicking on - Resources Link
		try {
			resourcesLink.click();
			System.out.println("URL after clicking on Products Link: "+driver.getCurrentUrl());
		}catch(Exception e) {
			resourcesLink = driver.findElement(By.xpath("//a[text()='Resources']"));
			resourcesLink.click();
			if(resourcesUrl.equals(driver.getCurrentUrl()))
				System.out.println("URL after clicking on Resources Link: "+driver.getCurrentUrl());
		}
		
		// Code for clicking on - Beyond RPA Link
		try {
			beyondRpaLink.click();
			System.out.println("URL after clicking on Products Link: "+driver.getCurrentUrl());
		}catch(Exception e) {
			beyondRpaLink = driver.findElement(By.xpath("//li[@class='coh-menu-list-item aboutRPANav nav-head coh-ce-71c1a106 js-coh-menu-item has-children is-collapsed']//a[text()='Beyond RPA']"));
			beyondRpaLink.click();
			if(beyondRpaUrl.equals(driver.getCurrentUrl()))
				System.out.println("URL after clicking on Beyond RPA Link: "+driver.getCurrentUrl());
		}
		
		// Code for clicking on - Company Link
		try {
			companyLink.click();
			System.out.println("URL after clicking on Products Link: "+driver.getCurrentUrl());
		}catch(Exception e) {
			companyLink = driver.findElement(By.xpath("//a[text()='Company']"));
			companyLink.click();
			if(companyUrl.equals(driver.getCurrentUrl()))
				System.out.println("URL after clicking on Company Link: "+driver.getCurrentUrl());
		}
		
		
		driver.close();
	}

}
