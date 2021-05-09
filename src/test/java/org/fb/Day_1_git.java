package org.fb;

import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day_1_git extends BaseCls_UsrDfindCls {
	@BeforeClass
	public void before() {
		launchBrowser("chrome");
		
	}
	@AfterClass
	public void after() {
		quit();
		
		
	}
	
	@BeforeMethod
	public void beforeTime() {
		Date d=new Date();
		System.out.println(d);
	}
	@AfterMethod
	public void afterTime() {
		Date d=new Date();
		System.out.println(d);
		
	}
	@Test
	public void test1() {
		launchUrl("https://www.facebook.com/");
		passValue_xpath("//*[@id='email']", "parvez");
		clickXpath("(//*[@role='button'])[2]");
		System.out.println("found");
	}


}
