package testngdemo;

import org.testng.annotations.Test;

import Pages.Seleniumbase;
import Pages.letcodedemo;
import basePage.Basepage;

public class parallelexecution extends Basepage {
	@Test
	void runner() {
 letcodedemo lt = new letcodedemo(getDriver());
 lt.inputspage();
	}
 @Test
 void runner2() {
	 Seleniumbase sb = new Seleniumbase(getDriver());
	 sb.seleniumhome();
 }
	
	}
	
