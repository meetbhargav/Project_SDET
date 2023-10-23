package com.test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TestNG_Annotations {
	WebDriver driver = new ChromeDriver();
	
	@Test(priority = 4)
	public void testResources() {
		String resourcesUrl = "https://www.automationanywhere.com/resources";
		WebElement resourcesLink = driver.findElement(By.xpath("//a[text()='Resources']"));
		// Code for clicking on - Resources Link
		try {
			resourcesLink.click();
			System.out.println("URL after clicking on Resources Link: "+driver.getCurrentUrl());
		}catch(Exception e) {
			resourcesLink = driver.findElement(By.xpath("//a[text()='Resources']"));
			resourcesLink.click();
			if(resourcesUrl.equals(driver.getCurrentUrl()))
				System.out.println("URL after clicking on Resources Link: "+driver.getCurrentUrl());
		}
	}
	
	@Test(priority = 6)
	public void testRpaLink() {
		WebElement beyondRpaLink = driver.findElement(By.xpath("//li[@class='coh-menu-list-item aboutRPANav nav-head coh-ce-71c1a106 js-coh-menu-item has-children is-collapsed']//a[text()='Beyond RPA']"));
		String beyondRpaUrl = "https://www.automationanywhere.com/rpa/robotic-process-automation";
		// Code for clicking on - Beyond RPA Link
		try {
			beyondRpaLink.click();
			System.out.println("URL after clicking on Beyond RPA Link: "+driver.getCurrentUrl());
		}catch(Exception e) {
			beyondRpaLink = driver.findElement(By.xpath("//li[@class='coh-menu-list-item aboutRPANav nav-head coh-ce-71c1a106 js-coh-menu-item has-children is-collapsed']//a[text()='Beyond RPA']"));
			beyondRpaLink.click();
			if(beyondRpaUrl.equals(driver.getCurrentUrl()))
				System.out.println("URL after clicking on Beyond RPA Link: "+driver.getCurrentUrl());
		}
		
	}
	
	  @Test(priority = 2)
	  public void testCompany() {
			WebElement companyLink = driver.findElement(By.xpath("//a[text()='Company']"));
			String companyUrl ="https://www.automationanywhere.com/company/about-us";
			try {
				companyLink.click();
				System.out.println("URL after clicking on Company Link: "+driver.getCurrentUrl());
			}catch(Exception e) {
				companyLink = driver.findElement(By.xpath("//a[text()='Company']"));
				companyLink.click();
				if(companyUrl.equals(driver.getCurrentUrl()))
					System.out.println("URL after clicking on Company Link: "+driver.getCurrentUrl());
			}
	  }
	  
	  @Test(priority = 1)
	  public void testProducts() {
		  WebElement productsLink = driver.findElement(By.xpath("//a[text()='Products']"));
		  String productsUrl = "https://www.automationanywhere.com/products";
		  
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
		  
		  
	  }
	  
	  @Test(enabled = true)
	  public void testLogo() {
		  WebElement logo = driver.findElement(By.xpath("//div[@class='coh-container nav-logo-wrap']//img[@class='coh-image coh-image-responsive-xl']"));
			// Code for finding the logo tag name
			if(logo.isDisplayed()) {
				System.out.println("Automation Anywhere Logo tag: "+logo.getTagName());
			}
		  
	  }
	  
	  @Test(enabled = true)
	  public void testRequestDemoButton() {
		  WebElement requestDemoButton = driver.findElement(By.xpath("//div[@class='coh-container utility-navbtn']//a[@title='Request Demo']"));
			// Code for scrolling down using java script executor
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");
			//Code for clicking on the Request Demo Button
			if(requestDemoButton.isDisplayed() && requestDemoButton.isEnabled()) {
				requestDemoButton.click();
				System.out.println("URL after clicking on Request Demo Button: " +driver.getCurrentUrl());
				driver.navigate().back();
			}else {
				System.out.println("Error - Request Demo");
			}
			
	  }
	  
	  @Test(timeOut = 1000)
	  public void testSolutions() throws InterruptedException {
		  WebElement solutionsLink = driver.findElement(By.xpath("//a[text()='Solutions']"));
		  String solutionsUrl = "https://www.automationanywhere.com/solutions";
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
		  Thread.sleep(2000);
	  }
	  
	  
	  

  @BeforeTest
  public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		String url = "https://www.automationanywhere.com/";
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Accept Cookies
		WebElement acceptCookiesButton = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
		// Code for accept cookies button
		if(acceptCookiesButton.isDisplayed() && acceptCookiesButton.isEnabled()) {
			acceptCookiesButton.click();
		}
  }

  @AfterTest
  public void afterTest() {
		driver.close();
  }

}
