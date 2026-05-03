package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.Framespage;

public class FramesTest extends BaseTest {
@Test
public void framedemo(){
	Framespage fp = new Framespage(driver);
	fp.navigatto();
}


}
