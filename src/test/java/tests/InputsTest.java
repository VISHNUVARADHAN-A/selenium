package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InputsPage;

public class InputsTest extends BaseTest {

    @Test
    public void verifyInputFunctionality() {

        InputsPage page = new InputsPage(driver);

        // Open Inputs Page
        page.openInputsPage();

        // Enter name
        page.enterFullName("Bot 1999");

        // Validate enabled field
        Assert.assertTrue(page.isFieldEnabled(), "Expected field to be enabled");

        // Validate disabled field
        Assert.assertTrue(page.isFieldDisabled(), "Expected field to be disabled");
    }

    @Test
    public void verifyClearFunctionality() {

        InputsPage page = new InputsPage(driver);
        page.openInputsPage();

        // Clear field
        page.clearInputField();

        // Validate field is cleared
        Assert.assertEquals(page.getClearedFieldValue(), "", "Field is not cleared properly");
    }
}