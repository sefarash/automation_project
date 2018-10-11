package com.cybertek.automation_project;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PopupExamples extends TestBase {
	
	@Test
	public void jsAlertTest() {
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("(//button)[1]")).click();
		
		Alert alert = driver.switchTo().alert();
		//alert.getText() ==> get the text of alert
		System.out.println(alert.getText());
		//alert.accept() ==> click ok on alert
		alert.accept();
		
		driver.findElement(By.xpath("(//button)[2]")).click();
		alert = driver.switchTo().alert();
		//alert.dismiss() ==> click cancel on alert
		alert.dismiss();
		
		driver.findElement(By.xpath("(//button)[3]")).click();
		alert = driver.switchTo().alert();
		// types on alert
		alert.sendKeys("aaaaaaaaaaa");
		
		System.out.println(alert.getText());
		
		//How to verify 
		
		try {
			Alert alert1 =driver.switchTo().alert();
		}catch (NoAlertPresentException e) {
			Assert.fail("Alert was not present");
		}
		
		alert.accept();
	}
	
	@Test
	public void alerts() {
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		driver.findElement(By.name("cusid")).sendKeys("54654");
		driver.findElement(By.name("submit")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.accept();
		
	}
	
	@Test
	public void htmlPopUps() {
	  driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
	  driver.findElement(By.xpath("//span[.='Destroy the World']")).click();
	  Assert.assertTrue(driver.findElement(By.xpath("//span[.='Destroy the World']")).isDisplayed());
	 
	  
	  //Alert alert = driver.switchTo().alert();
	  driver.findElement(By.xpath("//span[.='No']")).click();
	  
	  
	}

}
