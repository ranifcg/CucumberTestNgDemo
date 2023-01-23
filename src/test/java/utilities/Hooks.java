package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import common.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {
	private BaseClass base;
	public Hooks(BaseClass base)
	{
		this.base = base;
	}

	@Before
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver\\chromedriver.exe");
		//System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver-v0.32.0-win64\\geckodriver.exe");

		base.driver = new ChromeDriver();
		base.driver.get("http://adactinhotelapp.com");


		base.driver.manage().window().maximize();
	}
	@After
	public void teardown(Scenario scenario)
	{
		if (scenario.isFailed()){
			final byte[] screenshot = ((TakesScreenshot) base.driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		base.driver.quit();
	}
}
