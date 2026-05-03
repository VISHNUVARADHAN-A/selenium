package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import base.BasePage;

public class Seleniumbase extends BasePage {
	By htagname = By.xpath("//h1[text()='Demo Page']");	
	By dropdown = By.id("myDropdown");
	By hoverselect =  By.xpath("//*[@id=\"tbodyId\"]/tr[1]/td[4]/h3");
	By selectid = By.id("dropOption2");
	By textareaid =By.id("myTextarea");
	By Pre_Filled =By.id("myTextInput2"); 
	By buttonclr =By.id("myButton");
	By readonlyfield =By.id("readOnlyText");
	By Ptag =By.id("pText");
	By gett =  By.xpath("//*[@id='tbodyId']/tr[4]/td[4]");
	By placeholdertxt =By.id("placeholderText");
	By slider =By.id("mySlider");
	By progressBar = By.id("progressBar");
	By progresslabel = By.id("progressLabel");
	By frameid = By.id("myFrame1");
	By frameimg =By.xpath("/html/body/img");
	By brokenimg = By.id("brokenimg");
	By selectdropdown  = By.id("mySelect");
	By frameid1 = By.id("myFrame2");
	By frameid3 = By.id("myFrame3");
	By texth4 = By.xpath("/html/body/h4");
	By radioBtn1 = By.id("radioButton1");
	By radioBtn2 = By.id("radioButton2");
	By checkbox1 = By.id("checkBox1");
	By checkbox2 = By.id("checkBox2");
	By checkbox3 = By.id("checkBox3");
	By checkbox4 = By.id("checkBox4");
	By checkbox5 = By.id("checkBox5");
	By checkbox6 = By.xpath("//*[@id='checkBox6']");
	By dragEle =By.id("logo");
	By dragSource =By.id("drop1");
	By dragDestination =By.id("drop2");
	By Link1 =By.id("myLink1");
	By Link2 =By.id("myLink2");
	By Link3 =By.id("myLink3");
	By Link4 =By.id("myLink4");
	
	
	  public Seleniumbase(WebDriver driver) {
	        super(driver);
	    }
//public void seleniumhome(){
//	driver.get("https://seleniumbase.io/demo_page");	
//}

public String gethtage() {
	return getText(htagname);
}

public String getdropdownval() {
	
	hover(dropdown);
	click(selectid);
	
return  getText(hoverselect);

}
 
public String textarea() {
	sendKeys(textareaid, "hello");
	return getattvalue(textareaid);
}
public String preFilled() {
	String before = getattvalue(Pre_Filled);
	clearandsendKeys(Pre_Filled, "hello");
	String After =getattvalue(Pre_Filled);
	String result =  "before: " + before +" " +"After:" +After;
	return result; 
}
public String buttonclr() {
	String Beforetext =jsvalue(readonlyfield,"readOnlyText");
	String BeforePtag =getText(Ptag);
	getreadonly(readonlyfield);
	click(buttonclr);
	String Aftertext =jsvalue(readonlyfield,"readOnlyText");
	String AfterPtag =getText(Ptag);
	
	String res = "readonly?; "+getreadonly(readonlyfield)+ "\r\n"+
			" Before text: "+ Beforetext + "  After Test: " + Aftertext + "\r\n" +
			" Before Ptag: "+ BeforePtag + "  After Test: " + AfterPtag;
	return res;
	
}
public String placeholder() {
	
	return getattplaceholder(placeholdertxt);
	
	
}

public String dragslider(int val2) {
	String val1 ="label: "+ getText(progresslabel)+" bar: "+getattvalue(progressBar);
	drag(slider, val2);
	String val ="label: "+ getText(progresslabel)+" bar: "+getattvalue(progressBar);
	return ("initial: " + val1 + " final: " +val) ;
}

public Boolean frameimage() {
	
	driver.switchTo().frame(find(frameid));
	boolean val =isImageLoaded(frameimg);
	driver.switchTo().defaultContent();
	return val;
	
	}

public String selectdropdown(String op, String val) {
	String beforeselect = selectedoption(selectdropdown);
	if(op.equalsIgnoreCase("index")) {
		selectByIndex(selectdropdown, Integer.valueOf(val));	
	}
	else if (op.equalsIgnoreCase("value")) {
		selectByValue(selectdropdown, val);
	}
	else if (op.equalsIgnoreCase("text")) {
		selectByVisibleText(selectdropdown, val);
	}
	else {
		System.out.println("nope");
	}
	String Afterselect = selectedoption(selectdropdown);
	String res = ("Before: "+ beforeselect + " Afterselect: " + Afterselect);
	return res;
}

public String frametxt()  {
	driver.switchTo().frame(find(frameid1));
	String val = getText(texth4);
	driver.switchTo().defaultContent();
	return val;
	}
public String radiobtn() {
	boolean before =isselected(radioBtn1);
	boolean before1 =isselected(radioBtn2);
	click(radioBtn2);	
	boolean After =isselected(radioBtn1);
	boolean After2 =isselected(radioBtn2);
	String val = "Radio1: " + before + " Radio2: "+ before1 +" Radio1: "+ After +" Radio2: "+ After2;
	return val;
}

public StringBuilder checkbox() {
	StringBuilder sb = new StringBuilder("");
	boolean bcheckbx1 = isselected(checkbox1);
	click(checkbox1);
	
	boolean bcheckbx2 = isselected(checkbox2);
	click(checkbox2);
	
	boolean bcheckbx3 = isselected(checkbox3);
	click(checkbox3);
	
	boolean bcheckbx4 = isselected(checkbox4);
	click(checkbox4);
	
	boolean bcheckbx5 = isselected(checkbox5);
	click(checkbox5);
	
	boolean acheckbx1 = isselected(checkbox1);
	boolean acheckbx2 = isselected(checkbox2);
	boolean acheckbx3 = isselected(checkbox3);
	boolean acheckbx4 = isselected(checkbox4);
	boolean acheckbx5 = isselected(checkbox5);
	driver.switchTo().frame(find(frameid3));
	boolean bcheckbx6 = isselected(checkbox6);
	click(checkbox6);
	boolean acheckbx6 = isselected(checkbox6);
	driver.switchTo().defaultContent();
	
	sb.append(bcheckbx1 +" "+ bcheckbx2 +" "+ bcheckbx3 +" "+ bcheckbx4 +" "+ bcheckbx5 +" "+ bcheckbx6 +" ");
	sb.append(acheckbx1 +" "+ acheckbx2 +" "+ acheckbx3 +" "+ acheckbx4 +" "+ acheckbx5 +" "+ acheckbx6 +" ");
	return sb;
}
public String draganddrop1() {
	return draganddrop(dragEle,dragDestination);
}
public String draganddrop2() {
	return draganddrop(dragEle,dragSource);
}
public void navigator() {
	click(Link1);
	driver.navigate().back();
	click(Link2);
	driver.navigate().back();
	click(Link3);
	driver.navigate().back();
	click(Link4);
}
}





