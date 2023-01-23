package stepdefinition;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import common.BaseClass;
public class TestSteps extends BaseClass{
	
WebDriver driver;
String exp_title = "Adactin.com - Search Hotel";
String exp_greeting = "Hello aniselen!";
private BaseClass base;
/*public TestSteps(BaseClass base)
{
	System.out.println("I am inside constructor for TestSteps");
	this.base = base;
}*/

@Before
public void setup()
{
	System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver\\chromedriver.exe");
	//System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
	//System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver-v0.32.0-win64\\geckodriver.exe");

	driver = new ChromeDriver();
	driver.get("http://adactinhotelapp.com");


	driver.manage().window().maximize();
}
@After
public void teardown(Scenario scenario)
{
	if (scenario.isFailed()){
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
	}
	driver.quit();
}

@Given("user is on the login page")
public void user_is_on_the_login_page() throws Exception {
    // Write code here that turns the phrase above into concrete actions
	/*System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver\\chromedriver.exe");
	//System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
	//System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver-v0.32.0-win64\\geckodriver.exe");

	driver = new ChromeDriver();
	driver.get("http://adactinhotelapp.com");


	driver.manage().window().maximize();*/
}

@When("user enters user name and password")
public void user_enters_user_name_and_password()  {
    // Write code here that turns the phrase above into concrete actions
	
	WebElement uName = driver.findElement(By.id("username"));
	
	uName.sendKeys("raniselen");
	
	driver.findElement(By.id("password")).sendKeys("adactin");
	
}

// from feature file it picks up username and password
@When("user enters \"(.*)\", \"(.*)\"$")
public void user_enters(String username, String password)  {
	WebElement uName = driver.findElement(By.id("username"));
	
	uName.sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);

}

@When("user clicks on login button")
public void user_clicks_on_login_button() throws Exception {
    // Write code here that turns the phrase above into concrete actions
	
	driver.findElement(By.cssSelector("input#login")).click();
}


@Then("Login is succesful")
public void login_is_succesful() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	
	String curr_greeting = driver.findElement(By.id("username_show")).getAttribute("value");
	System.out.println(curr_greeting);
	
	assertEquals(exp_greeting, curr_greeting);
}

@Then("Search Page is displayed")
public void search_page_is_displayed() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	String curr_title = driver.getTitle();
	System.out.println(curr_title);
	driver.quit();
	
	assertEquals(exp_title, curr_title);	
}




@When("login is succesful")
public void login_is_succesful1() {
	String curr_greeting = driver.findElement(By.id("username_show")).getAttribute("value");
	System.out.println(curr_greeting);
}

@When("search Page is displayed")
public void search_page_is_displayed1() {
	String curr_title = driver.getTitle();
	System.out.println(curr_title);
}

@When("user selects \"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\"$")
public void user_selects(String location, String roomno, String checkin, String checkout, String adults) {
	 //Drop down  to select LOCATION
    new Select(driver.findElement(By.className("search_combobox"))).selectByValue(location);


    //Drop down to select Number of Rooms
     new Select(driver.findElement(By.id("room_nos"))).selectByValue(roomno);

     //Date picker-Enter check in date
     WebElement checkinDate = driver.findElement(By.id("datepick_in"));
     checkinDate.clear();
     checkinDate.sendKeys(checkin);

     //Date picker-Enter checkout date
     WebElement checkoutDate = driver.findElement(By.id("datepick_out"));
     checkoutDate.clear();
     checkoutDate.sendKeys(checkout);

     //Select Adults per room
     new Select(driver.findElement(By.id("adult_room"))).selectByValue(adults);
}

@When("user clicks on Search button")
public void user_clicks_on_search_button() {
    // Write code here that turns the phrase above into concrete actions
	 //Click on Search
	driver.findElement(By.id("Submit")).click();}

@Then("search results should be displayed")
public void search_results_should_be_displayed() {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("Successful search page");
	String curr_title = driver.getTitle();
	exp_title = "Adactin.com - Select Hotel";
	driver.quit();
	assertEquals(exp_title, curr_title);
}

@Given("This is a blank test")
public void this_is_a_blank_test() {

	System.out.println("Check blank test");
}


}
