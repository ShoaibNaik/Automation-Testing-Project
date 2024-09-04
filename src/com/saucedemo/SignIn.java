package com.saucedemo;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SignIn {
	
	public static void main(String[] args) {
		
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(op);
		
		driver.get("https://www.saucedemo.com/");
		String title = driver.getTitle();
		System.out.println("Title: "+title);
		try {
			Thread.sleep(500); 
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(1000);
		driver.findElement(By.name("login-button")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("shopping_cart_container")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//button[contains(@class, 'btn btn_action btn_medium checkout_button')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("first-name")).sendKeys("abc");
		Thread.sleep(1000);
		driver.findElement(By.name("lastName")).sendKeys("xyz");
		Thread.sleep(1000);
		driver.findElement(By.id("postal-code")).sendKeys("400125");
		Thread.sleep(1000);
		driver.findElement(By.name("continue")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//button[contains(@class, 'btn btn_action btn_medium cart_button')]")).click();
		
		
		Thread.sleep(1000);
		
		TakesScreenshot tk = (TakesScreenshot)driver;
		File f = tk.getScreenshotAs(OutputType.FILE);
		File f1 = new File("./Print success message.jpg");
		FileUtils.copyFile(f, f1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		}

}
