package tests;

import org.testng.annotations.Test;
import base.BaseTest2;
import pages.Seleniumbase;

public class seleniumbasetest extends BaseTest2 {
	
	@Test
	public void textinputs() {
		Seleniumbase sb = getSb();
		//sb.seleniumhome();
		
	System.out.println(sb.gethtage());
	System.out.println(sb.textarea());
	System.out.println(sb.preFilled());
	System.out.println(sb.buttonclr());
	System.out.println(sb.buttonclr());
	System.out.println(sb.placeholder());
	sb.navigator();
	}
	@Test
	public void selectinputs() {
		Seleniumbase sb = getSb();
		System.out.println(sb.getdropdownval());
		System.out.println(sb.selectdropdown("index", "1"));
		System.out.println(sb.selectdropdown("value", "75%"));
		System.out.println(sb.selectdropdown("text", "Set to 25%"));
		System.out.println(sb.frameimage());
		System.out.println(sb.frametxt());
		System.out.println(sb.radiobtn());
		
	}
	@Test
	public void actioninputs() {
		Seleniumbase sb = getSb();
	System.out.println(sb.checkbox());
	System.out.println(sb.draganddrop1());
	System.out.println(sb.draganddrop2());	
	System.out.println(sb.dragslider(10));
	System.out.println(sb.dragslider(-50));
	}
}
