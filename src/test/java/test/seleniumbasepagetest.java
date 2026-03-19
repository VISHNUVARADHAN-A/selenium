package test;

import org.testng.annotations.Test;

import Pages.Seleniumbase;
import basePage.Basepage;

public class seleniumbasepagetest extends Basepage{
@Test
	public void runner() {
	Seleniumbase sb = new Seleniumbase(getDriver());
	sb.seleniumhome();
	
	}

}
