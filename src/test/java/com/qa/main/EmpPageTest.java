package com.qa.main;

import static com.qa.chrome.SeleniumChromeCookies.chromeCfg;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EmpPageTest {
	private static ExtentReports extent;
	private static ExtentTest test;
	private static int count = 0;
	private WebDriver driver;
	private String url = "http://127.0.0.1:5501/html/emp.html";

	@BeforeClass
	public static void init() {
		extent = new ExtentReports("src/test/resources/reports/EmployeePageReport.html", true);

	}

	@Before
	public void setup() {
		test = extent.startTest("To-Do App Employee Page: Test Number " + ++count);
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver(chromeCfg());
		driver.manage().window().setSize(new Dimension(1366, 768));
	}

	@After
	public void tearDown() {
		driver.quit();
		extent.endTest(test);
	}

	@AfterClass
	public static void fini() {
		extent.flush();
		extent.close();
	}

	@Test
	public void testNavbarEmployeeBtn() {
		driver.get(url);
		WebElement home = driver.findElement(By.id("navbaremp"));
		home.click();
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().equals("http://127.0.0.1:5501/html/emp.html")) {
			test.log(LogStatus.PASS, "Passed");
			assertTrue(true);
		} else {
			test.log(LogStatus.FAIL, "Failed");
			assertTrue(false);
		}
	}

	@Test
	public void testNavbarTaskBtn() {
		driver.get(url);
		WebElement home = driver.findElement(By.id("navbartask"));
		home.click();
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().equals("http://127.0.0.1:5501/html/task.html")) {
			test.log(LogStatus.PASS, "Passed");
			assertTrue(true);
		} else {
			test.log(LogStatus.FAIL, "Failed");
			assertTrue(false);
		}
	}

	@Test
	public void testNavbarHomeBtn() {
		driver.get(url);
		WebElement home = driver.findElement(By.id("navbarhome"));
		home.click();
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().equals("http://127.0.0.1:5501/index.html")) {
			test.log(LogStatus.PASS, "Passed");
			assertTrue(true);
		} else {
			test.log(LogStatus.FAIL, "Failed");
			assertTrue(false);
		}
	}

//	@SuppressWarnings("unlikely-arg-type")
//	@Test
//	public void testEmployeeCreation() {
//		driver.get(url);
//		WebElement name = driver.findElement(By.id("commentName"));
//		name.sendKeys("Test Person");
//		name.submit();
//		new WebDriverWait(driver, 3).until(ExpectedConditions.);
//		if (driver.findElement(By.xpath("/html/body/table/thead/tr[2]/td[2]")).equals("Test Person")) {
//			test.log(LogStatus.PASS, "Passed");
//			assertTrue(true);
//		} else {
//			test.log(LogStatus.FAIL, "Failed");
//			assertTrue(false);
//		}
//	}

}
