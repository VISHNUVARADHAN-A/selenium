package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.landingpage;

public class landingTest extends BaseTest {
	landingpage lp ;
@Test
public void landingpagedemo(){
	lp = new landingpage(driver);
	lp.open_landing_page();
	lp.get_the_page_title();
	
}

}
