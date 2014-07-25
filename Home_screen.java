package asda_version_1;
//import java.util.Set;

	//import org.junit.Assert;
	import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

	import jxl.Workbook;
import jxl.Sheet;
import jxl.Cell;
import jxl.read.biff.BiffException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import seledatadriven.Cell;
//import seledatadriven.Sheet;
//import seledatadriven.Workbook;

public class Home_screen {

	WebDriver driver;
	public String username;
	public String pwd;
	public int count=0;
	List<String> cinlist1 = new ArrayList<String>();
	

	//constructor
	Home_screen(WebDriver driver){
		this.driver=driver;
	}
	
	//Checks the homepage title and the link on which it navigate after clicking on ASDA LOGO
	public void homepage_title_check(){
		String a = driver.getTitle();
		System.out.println(a);
		Assert.assertEquals(a,"Online Food Shopping - ASDA Groceries");
		String b = driver.getCurrentUrl();
		System.out.println(b);
		Assert.assertEquals("http://groceries.asda.com/asda-webstore/landing/home.shtml", driver.getCurrentUrl());
	}
	
		public void logo_click(){
		//navigate to any random page
		driver.findElement(By.xpath("//img [@width='203' and @height='74' and @src='//i3-groceries.asda.com/theme/img/modules/home_page/logo-asda.png']")).click();
	}
		
		
		
	public void check_offerpage(){
		//navigating to offer page
		WebElement obj = driver.findElement(By.xpath("//a [@class='special-offer' and contains(text(),'Special Offers')]"));
	
		Assert.assertEquals(obj.getText(),"Special Offers");
		obj.click();
		String a = driver.getTitle();
		System.out.println(a);
		Assert.assertEquals(a,"Special Offers - ASDA Groceries");
	}
	
	//check if the postcode page is opening or not
	public void postcode_screen_check(){
		String a = driver.getTitle();
		System.out.println(a);
		Assert.assertEquals(a,"Special Offers - ASDA Groceries");
	}
	//postcode Screen_value_entering_method_and_clicking_continuing
	public void post_code_screen(String postcode){
		driver.findElement(By.xpath("//input [@id = 'postcode' and @type='text']")).sendKeys(postcode);
		driver.findElement(By.xpath("//input [@type='submit' and @value='Continue']")).click();	
	}
	
	public void sign_in_popup(){
		driver.findElement(By.xpath("//a[@ id ='sign-in-button-accessible' and  contains(text(),'Sign in')]")).click();
		wait_command(5000);
		driver.switchTo().frame("login");
		//Assert.assertEquals("Please sign in.",driver.findElement(By.xpath("//Strong [contains(text(),'Please sign in.')]")).getText());
		//String a=driver.findElement(By.xpath("//label [@for='username']/text()[4]")).getText();
		//System.out.println(a);
		//Assert.assertEquals("Email address",driver.findElement(By.xpath("//label [@for='username']/text()[4]")).getText());
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys(username);
		Assert.assertEquals("Password",driver.findElement(By.xpath("//label [@for='password' and contains(text(),'Password')]")).getText());
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//*[@id='btn-signIn-accessible']")).click();
		wait_command(5000);
		driver.switchTo().defaultContent();
		wait_command(5000);
		//String a = driver.findElement(By.xpath("//h2 [@style='background-color: transparent;' and contains(text(),'Welcome back')]")).getText();
		//System.out.println(a);
	}
	public void sign_in_popup(String pcode,String uname,String password){
		driver.findElement(By.xpath("//a[@ id ='sign-in-button-accessible' and  contains(text(),'Sign in')]")).click();
		wait_command(5000);
		driver.switchTo().frame("login");
		//Assert.assertEquals("Please sign in.",driver.findElement(By.xpath("//Strong [contains(text(),'Please sign in.')]")).getText());
		//String a=driver.findElement(By.xpath("//label [@for='username']/text()[4]")).getText();
		//System.out.println(a);
		//Assert.assertEquals("Email address",driver.findElement(By.xpath("//label [@for='username']/text()[4]")).getText());
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys(uname);
		Assert.assertEquals("Password",driver.findElement(By.xpath("//label [@for='password' and contains(text(),'Password')]")).getText());
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='btn-signIn-accessible']")).click();
		wait_command(5000);
		driver.switchTo().defaultContent();
		//String a = driver.findElement(By.xpath("//h2 [@style='background-color: transparent;' and contains(text(),'Welcome back')]")).getText();
		//System.out.println(a);
		wait_command(5000);
		
	}
	public void login_check_homepage(){
		String a = driver.getTitle();
		System.out.println(a);
		Assert.assertEquals(a,"Online Food Shopping - ASDA Groceries");
		String b = driver.getCurrentUrl();
		System.out.println(b);
		Assert.assertEquals("http://groceries.asda.com/asda-webstore/landing/home.shtml#", driver.getCurrentUrl());
	
	}
	public void data_driven_thru_excel() throws BiffException, IOException{
		System.out.println("EXL FILE OUTPUT");
		File myexcel = new File("data.xls");
		Workbook wbk= Workbook.getWorkbook(myexcel);
		Sheet sh=wbk.getSheet(0);
		int cols=sh.getColumns();
	 	int rows=sh.getRows();
	 	System.out.println(cols);
	 	System.out.println(rows);
	 	Cell un = sh.getCell(0,1);
	 	System.out.println(un.getContents());
	 	username=un.getContents();
	 	Cell pw = sh.getCell(1,1);
	 	System.out.println(pw.getContents());
	 	pwd=pw.getContents();
	 	count=0;
	 	for(int row=4;row<=6;row++)
	 	{
	 		Cell productid=sh.getCell(2,row);
	 		//System.out.println(productid.getContents());
	 		cinlist1.add(productid.getContents());
	 		
	 		System.out.println("Product cin no. added to array at"+count+ "index is"+ cinlist1.get(count));
	 //System.out.println(cinlist1.get(0));
	 		
	 count++;
	 		}
	 		
	 	
	 	
	/*	for(int row=0;row<rows;row++)
		{
			for(int col=0;col<cols;col++)
			{
				
				Cell objcell = sh.getCell(col,row);
				System.out.println(objcell.getContents());
				
			}
		}*/
	}
	
	/*public void login(String postcode, String user, String pwd) 
	{
	driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
	post_code_screen(postcode);
	driver.findElement(By.xpath("//a[@ id ='sign-in-button-accessible' and  contains(text(),'Sign in')]")).click();
	wait_command(5000);
	driver.switchTo().frame("login");
	WebElement log = 
	log.click();
	log.sendKeys(user);
	log = driver.findElement(By.xpath("//*[@id='password']"));
	log.click();
	log.sendKeys(pwd);
	driver.findElement(By.xpath("//*[@id='btn-signIn-accessible']")).click();
	System.out.println("login Successful waiting for 1min");

	}*/
	public void logout(WebDriver driver) {
	driver.findElement(By.xpath("//*[@id='sign-in-button-arrow']")).click();
	driver.switchTo().frame("login");
	driver.findElement(By.xpath("//input [@id='reChkBox']")).click();
	driver.findElement(By.xpath("//input [@ class='button button-pri signout-btn'and @type='submit']")).click();
	// driver.switchTo().defaultContent();
	wait_command(5000);
	String handles = driver.getWindowHandle();
	System.out.println(handles);
	driver.switchTo().window(handles);
	driver.findElement(By.id("confirmSignOut")).click();
	System.out.println("logout Successful");
	}
	public void registration(WebDriver driver) {
	driver.get("http://groceries.asda.com");
	System.out.println("Register to Groceries");
	driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
	wait_command(5000);
	driver.findElement(By.xpath("//input [@id = 'postcode' and @type='text']")).sendKeys("dn211nz");
	driver.findElement(By.xpath("//input [@type='submit' and @value='Continue']")).click();
	wait_command(5000);
	driver.findElement(By.xpath("//*[@id='formFname']")).sendKeys("Abhishek");
	driver.findElement(By.xpath("//*[@id='formLname']")).sendKeys("verma");
	driver.findElement(By.xpath("//*[@id='formEmail']")).sendKeys(username);
	driver.findElement(By.xpath("//*[@id='formConfirmEmail']")).sendKeys(username);
	driver.findElement(By.xpath("//*[@id='formPassword']")).sendKeys(pwd);
	driver.findElement(By.xpath("//*[@id='formConfirmPassword']")).sendKeys(pwd);
	driver.findElement(By.xpath("//div[@id='addressList']/div/span")).click();
	driver.findElement(By.xpath("//div[@id='addressList']/div[2]/div[2]/div/ul/li/span")).click();
	driver.findElement(By.xpath("//*[@id='addressNickname']")).sendKeys("sweet home");
	driver.findElement(By.xpath("//*[@id='formMobileNumbers']")).sendKeys("0987654321");
	driver.findElement(By.xpath("//*[@id='tAndC']")).click();
	driver.findElement(By.xpath("//*[@id='ageCheck']")).click();
	driver.findElement(By.xpath("//*[@id='servicesCheck']")).click();
	}
	
	public String search_functionality(WebDriver obj,String search){
		//obj.get("https://groceries.asda.com");
		obj.findElement(By.xpath("//input [@id='search']")).sendKeys(search);
		obj.findElement(By.xpath("//div [@type='image' and contains(text(),'Search button')]")).click();
		WebElement wait_obj = (new WebDriverWait(obj,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//label [@for='search' and contains(text(),'Search')]"))));
		String textpresent = obj.findElement(By.xpath("//label [contains(text(),'Search')]")).getText();
		return textpresent;
	}
public void logo_click_on(){
	driver.findElement(By.xpath("//img [@src='//i3-groceries.asda.com/theme/img/modules/home_page/logo-asda.png']")).click();
	//driver.findElement(By.cssSelector("//img [@src='//i3-groceries.asda.com/theme/img/modules/home_page/logo-asda.png']").click();
}
public void Special_offer_page(){
	driver.findElement(By.xpath("//a [@href='#/special_offers/TopOffers' and contains(text(),'Special Offers')]")).click();
}
public void search_prduct_by_cin(String cinno){
	WebElement ele=	driver.findElement(By.xpath("//input [@id='search']"));
	ele.click();
	ele.sendKeys(cinno);
	
}
public void sending_cin_and_adding_to_trolley(){
	int lenght_array = cinlist1.size();
	for(int i= lenght_array-1;i>=0;i--){
		//search_prduct_by_cin(cinlist1.get(i));
		driver.findElement(By.xpath("//input [@id='search']")).sendKeys(cinlist1.get(i));
		driver.findElement(By.xpath("//a [@id='search-submitbox-wrapper']")).click();
		System.out.println(cinlist1.get(i)+"is added for-"+ username);
		wait_command(5000);
		driver.findElement(By.xpath("//* [@onclick='return false;' and contains(text(),'Add')]")).click();
		System.out.println(cinlist1.get(i)+"-added successfully");
		wait_command(5000);
	}

}


public void add_product_to_trolley(){
	WebElement wait_obj = (new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//* [@onclick='return false;' and contains(text(),'Add')]"))));
	driver.findElement(By.xpath("//* [@onclick='return false;' and contains(text(),'Add')]")).click();
	//adding the first element present on the screen with add item botton on it.
}

	public void wait_command(int time) {
	try {
	Thread.sleep(time);
	} catch (Exception e) {
	}
	}

	public void clear_array() {
	int lenght_array = cinlist1.size();
	for(int i= lenght_array;i>=0;i--)
	cinlist1.remove(i);
	}
	public void remove_product_from_trolley(){
		driver.findElement(By.xpath("//input [@id='search']")).sendKeys("coke");
		driver.findElement(By.xpath("//a [@id='search-submitbox-wrapper']")).click();
		wait_command(10000);
		driver.findElement(By.xpath("//a [@class='EmptyTrolley' and contains(text(),'Empty trolley')]")).click();
	wait_command(5000);
	}
	

	}



