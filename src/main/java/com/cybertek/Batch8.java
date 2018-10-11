package com.cybertek;

import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;

public class Batch8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Faker f = new Faker();
		String name = f.chuckNorris().fact();
		String num = f.gameOfThrones().dragon();
		//String a = f.currency().name();
		System.out.println(name);
		WebDriver driver;

	}

}
