package test;

import org.testng.annotations.Test;

import Pages.letcodedemo;
import basePage.Basepage;

public class letcodeMainPageTest extends Basepage {


	  @Test
	    void inputspage() throws InterruptedException {
	        letcodedemo lc = new letcodedemo(getDriver());
	        lc.landingpage();
	        lc.inputspage();
	    }
	    @Test
	    void buttonspage() throws InterruptedException {
	        letcodedemo lc = new letcodedemo(getDriver());
	        lc.landingpage();
	        lc.buttonspage();
	    }
	    @Test
	    void selectpage() throws InterruptedException{
	        letcodedemo lc = new letcodedemo(getDriver());
	        lc.landingpage();
	        lc.selectpage();
	    }
	    @Test
	    void alertPage() throws InterruptedException{
	        letcodedemo lc = new letcodedemo(getDriver());
	        lc.landingpage();
	    	lc.alertpage();
	    }
	    @Test
	    void frames() throws InterruptedException{
	        letcodedemo lc = new letcodedemo(getDriver());
	        lc.landingpage();
	    	lc.frames();
	    }
}
