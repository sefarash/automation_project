package com.cybertek.automation_project;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TabsWindowsExample extends TestBase{

	@Test
	public void switchToWindow() {
		driver.get("http://the-internet.herokuapp.com/windows");
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.linkText("Click Here")).click();
		// windowsHandle == id provided by selenium for current open tabs
		//getWindowHandle() == gets the handle , id of the current window
		String firstWindow = driver.getWindowHandle();
		
		System.out.println("current:  " + firstWindow);
		// driver.getWindowHandles() ==> returns handles of all the current tabs
		
		Set<String> windowHandles = driver.getWindowHandles();
		for (String each : windowHandles) {
			System.out.println(each);
			
			//
			if(!firstWindow.equals(each)) {
			driver.switchTo().window(each);	
			}
		}
	}
}
