package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.selectionsPage;

public class SelectionTest extends BaseTest {

    @Test
    public void verifydropdownbyvalue() {

    	selectionsPage page = new selectionsPage(driver);
        page.openInputsPage();
        System.out.println(page.selectByValue("3"));
//        // Validate button is disabled
//        Assert.assertTrue(page.isButtonDisabled(), "Expected button to be disabled");
//
//        // Validate button color is not empty
//        String color = page.getButtonColor();
//        Assert.assertNotNull(color, "Button color should not be null");
//        Assert.assertFalse(color.isEmpty(), "Button color should not be empty");
//
//        // Validate button size
//        Assert.assertNotNull(page.getButtonSize(), "Button size should not be null");
//
//        // Validate button location
//        Assert.assertNotNull(page.getButtonLocation(), "Button location should not be null");
    }

    @Test
    public void selectBymulti() {
    	selectionsPage page = new selectionsPage(driver);
    	page.openInputsPage();
        System.out.println(page.selectBymulti());
    }
}