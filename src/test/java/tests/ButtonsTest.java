package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ButtonsPage;

public class ButtonsTest extends BaseTest {

    @Test
    public void verifyButtonProperties() {

        ButtonsPage page = new ButtonsPage(driver);

        // Open Buttons Page
        page.openButtonsPage();

        // Validate button is disabled
        Assert.assertTrue(page.isButtonDisabled(), "Expected button to be disabled");

        // Validate button color is not empty
        String color = page.getButtonColor();
        Assert.assertNotNull(color, "Button color should not be null");
        Assert.assertFalse(color.isEmpty(), "Button color should not be empty");

        // Validate button size
        Assert.assertNotNull(page.getButtonSize(), "Button size should not be null");

        // Validate button location
        Assert.assertNotNull(page.getButtonLocation(), "Button location should not be null");
    }

    @Test
    public void verifyButtonHoldAction() {

        ButtonsPage page = new ButtonsPage(driver);

        page.openButtonsPage();

        // Perform hold action (e.g., 2 seconds)
        page.holdButton(2000);

        // Validate updated text after hold
        String text = page.getUpdatedText();
        Assert.assertNotNull(text, "Updated text should not be null");
        Assert.assertFalse(text.isEmpty(), "Updated text should not be empty");
    }
}