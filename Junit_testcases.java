package asda_version_1;
import java.io.IOException;
import java.sql.Driver;
import java.util.Arrays;
import java.util.Collection;

import jxl.read.biff.BiffException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
//import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

	public class Junit_testcases {
	
 static WebDriver obj;
 static Home_screen ob;
	
@BeforeClass
	public static void setup(){
		obj = new FirefoxDriver();
		ob = new Home_screen(obj);
				
	}
@Before
	public void step_up_before(){
	obj.get("http://groceries.asda.com/");
	obj.manage().window().maximize();	
	}
//@After
//	public void end_clean(){
//	ob.clear_array();}


//TC_01 Test case to check that the website_is_opening		
	@Ignore
	@Test
	public void Siteisopeningtest(){
	ob.homepage_title_check();
	}
	
//TC_02 Test case to check logo is present and it navigates to homepage	
	@Ignore	
	@Test
	public void check_logo_present_and_navigate_to_homepage()
	{
	ob.check_offerpage();
	ob.logo_click();
	ob.homepage_title_check();
	}
	
//TC_03 Validate Sign in popup elements
	@Ignore
	@Test
	public void sign_in_popup_test()
	{
		ob.sign_in_popup();
	}
	
@Ignore
	@Test
	public void logininwithvaliduser(){
//	ob.login("dn211nz","alok.sharma@qa.com","alok123");
	ob.wait_command(10000);
	WebElement a = obj.findElement(By.xpath("//a [contains(text(),'Your Account')]"));
	String str = a.getText();
	Assert.assertEquals(str,"Your Account");
	ob.logout(obj);
	ob.wait_command(10000);
	}
	
	
	@Ignore
	@Test
	public void registering_a_new_user()
	{ob.registration(obj);
	 
	}
	
//Placing an order by searching item by its cin id 		
@Ignore
@Test
public void placing_single_order() throws BiffException, IOException{
	ob.data_driven_thru_excel();
	ob.sign_in_popup();//("dn211nz","alok.sharma@qa.com","alok123");
	//ob.login_check_homepage();
	
}
@Ignore
@Test
	public void searching_an_item()
	{String textpresent = ob.search_functionality(obj,"coke");
	Assert.assertEquals("Search" ,textpresent);
	String text =obj.findElement(By.xpath("//* [@onclick='return false;' and contains(text(),'Add')]")).getText();
	System.out.println(text);
	Assert.assertEquals(obj.findElement(By.xpath("//* [@onclick='return false;' and contains(text(),'Add')]")).getText(),"Add");
	
	}
@Test
	public void add_item_from_special_offer_page() throws BiffException, IOException
	{ob.data_driven_thru_excel();
	ob.sign_in_popup();
	ob.logo_click_on();
	ob.remove_product_from_trolley();
	ob.sending_cin_and_adding_to_trolley();
	
	ob.wait_command(5000);
		}


	@AfterClass
	public static void after(){
	obj.quit();
	}
	}
	