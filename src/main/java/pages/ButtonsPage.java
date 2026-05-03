package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import base.BasePage;

public class ButtonsPage extends BasePage {

    // Locators (NON-static)
    private final By buttonPageLink = By.xpath("//a[text()=' Click ']");
    private final By homeBtn = By.xpath("//button[text()='Goto Home']");
    private final By findLocationBtn = By.xpath("//button[text()='Find Location']");
    private final By colorBtn = By.xpath("//button[text()='What is my color?']");
    private final By sizeBtn = By.xpath("//button[text()='How tall & fat I am?']");
    private final By disabledBtn = By.xpath("//button[text()='Disabled']");
    private final By holdBtn = By.xpath("//h2[text()=' Button Hold!']");
    private final By updatedText = By.xpath("//div/button[@id='isDisabled']/div/h2");

    // Constructor (Correct)
    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    // =========================
    // Actions (Atomic Methods)
    // =========================

    public void openButtonsPage() {
        scrollBy(200);
        click(buttonPageLink);
    }

    public void clickHomeButton() {
        click(homeBtn);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void holdButton(int durationMillis) {
        clickAndHold(holdBtn, durationMillis);
    }

    // =========================
    // Getters (No Printing)
    // =========================

    public Point getButtonLocation() {
        return getLocation(findLocationBtn);
    }

    public String getButtonColor() {
        return getCssValue(colorBtn, "color");
    }

    public Dimension getButtonSize() {
        return getSize(sizeBtn);
    }

    public boolean isButtonDisabled() {
        return !isEnabled(disabledBtn);
    }

    public String getUpdatedText() {
        return getText(updatedText);
    }
}