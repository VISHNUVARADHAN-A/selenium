package pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;
public class selectionsPage extends BasePage{
	    // Locators (NON-static)
	    private final By dropdownspage = By.xpath("//a[text()=' Drop-Down ']");
	    private final By selectFruit = By.id("fruits");
	    private final By getselected = By.xpath("//p[text()='You have selected Banana']");
	    private final By multiselect = By.id("superheros");
	    private final By clearField = By.id("clearMe");
	    private final By disabledField = By.id("noEdit");
	    private final By enabledField = By.id("dontwrite");

	  //System.out.println(sl.getOptions());
	    //
	    //
	    //Select co = new Select());
	    //System.out.println(co.getFirstSelectedOption().getText());
	    //co.selectByValue("India");
	    //System.out.println(co.getFirstSelectedOption());
	    //System.out.println(co.getAllSelectedOptions());
	    //Select s2 = new Select(driver.findElement(By.id("superheros")));
	    //System.out.println(s2.isMultiple());
	    //s2.selectByIndex(0);
	    //s2.selectByIndex(5);
	    //List<WebElement> allselected= s2.getAllSelectedOptions();
	    //System.out.println(allselected);
	    
	    // Constructor
	    public selectionsPage(WebDriver driver) {
	        super(driver);
	    }

	    // =========================
	    // Actions (Atomic Methods)
	    // =========================

	    public void openInputsPage() {
	        scrollBy(200);
	        click(dropdownspage);
	    }

	    public String selectByValue(String value) {
	    	selectByValue(selectFruit, value);
	    	String value1= getText(selectFruit) + getText(getselected);
	    	return value1 ;
	    }
	    
	    public String selectByIndex(int value) {
	    	selectByIndex(selectFruit, value);
	    	String value1= getText(selectFruit) + getText(getselected);
	    	return value1 ;
	    }
	    
	    public String selectByVisibleText(String value) {
	    	selectByVisibleText(selectFruit, value);
	    	String value1= getText(selectFruit) + getText(getselected);
	    	return value1 ;
	  }
	    public String selectBymulti() {
	        // Select multiple options by index
	        selectByIndex(multiselect, 0);
	        selectByIndex(multiselect, 1);
	        selectByIndex(multiselect, 2);
	        selectByIndex(multiselect, 3);
	        selectByIndex(multiselect, 4);

	        // Get all selected options from the dropdown
	      
	        List<String> selectedOptions = getSelectedOptions(multiselect);
	        String a="";
	        System.out.println("Selected options in dropdown:");
	        for (String option : selectedOptions) {
	            a=  a + " - " + option;
	        }

	        return a;
	    }

 
	  }






