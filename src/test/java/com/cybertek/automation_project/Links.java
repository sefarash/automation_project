package com.cybertek.automation_project;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Links extends TestBase {
	
	@Test
	public void links() {
		
		driver.get("https://www.w3schools.com/");
		List<String> arr = new ArrayList<>();
		String str = driver.findElement(By.id("mySidenav")).getText();
		arr.add(str);
		for (String item : arr) {
			if(item.equals("Learn CSS"))
				driver.findElement(By.linkText("Learn CSS")).click();
		}
		System.out.println(str);
	}

}
