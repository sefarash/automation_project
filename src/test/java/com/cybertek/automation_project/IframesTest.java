package com.cybertek.automation_project;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IframesTest extends TestBase{

	
	@Test
	public void iframeTest1() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("http://toolsqa.com/iframe-practice-page/");
		
		assertTrue(driver.findElement(By.linkText("Home")).isDisplayed());
		
		//driver.findElement(By.id("tinymce")).sendKeys("more text");
		
		//find the iframe as an element and switch to the element
		Thread.sleep(3000);
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		
		Thread.sleep(3000);
		
		//switchTo() ==> swithces to the frame
		driver.switchTo().frame("iframe[1]");
		
		driver.findElement(By.name("firstname")).sendKeys(" Sefa ");
		driver.findElement(By.name("lastname")).sendKeys(" Sefa ");
		driver.findElement(By.cssSelector("input[value='Male']")).click();
		driver.findElement(By.cssSelector("input[value='7']")).click();
		driver.findElement(By.id("datepicker")).sendKeys("01/25/80");
		// swtich back to previous frame
		driver.switchTo().defaultContent();
		
		assertTrue(driver.findElement(By.linkText("HOME")).isDisplayed());
	}
	
	@Test 
	  public void iframeTest2() {
	    driver.get("http://the-internet.herokuapp.com/iframe");
	    assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());
	    
	    // pass the id or name of the iframe to the switchTo method
	    driver.switchTo().frame("mce_0_ifr");
	    driver.findElement(By.id("tinymce")).sendKeys(" more text");

	    // Selects either the first frame on the page, 
	    //or the main document when a page contains iframes.

	    driver.switchTo().defaultContent();
	    assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());

	  }
	  
	  
	  @Test 
	  public void iframeTest3() {
	    driver.get("http://the-internet.herokuapp.com/iframe");
	    assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());
	    
//	    // pass the index the iframe to the switchTo method
	    driver.switchTo().frame(0);
	    driver.findElement(By.id("tinymce")).sendKeys(" more text");
	    
	    // switchTo().parentFrame()   --> switches to the parent of the current frame
	    driver.switchTo().parentFrame();
	    assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());

	  }
}
