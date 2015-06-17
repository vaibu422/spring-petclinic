package org.springframework.samples.petclinic.test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class SeleniumTestForPC {

	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://10.63.39.119:8080";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testMytestpc() throws Exception {
	    driver.get(baseUrl + "/petclinic/");
	    driver.findElement(By.linkText("Find owners")).click();
	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
	    driver.findElement(By.linkText("Test 1")).click();
	    driver.findElement(By.linkText("Edit Pet")).click();
	    new Select(driver.findElement(By.id("type"))).selectByVisibleText("dog");
	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
	    driver.findElement(By.linkText("Add Visit")).click();
	    driver.findElement(By.id("description")).clear();
	    driver.findElement(By.id("description")).sendKeys("for checkup to mydog");
	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
	    driver.findElement(By.linkText("Add New Pet")).click();
	    new Select(driver.findElement(By.id("type"))).selectByVisibleText("cat");
	    driver.findElement(By.id("birthDate")).click();
	    driver.findElement(By.linkText("1")).click();
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys("mycat");
	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
	    driver.findElement(By.linkText("Find owners")).click();
	    driver.findElement(By.linkText("Add Owner")).click();
	    driver.findElement(By.id("firstName")).clear();
	    driver.findElement(By.id("firstName")).sendKeys("barun");
	    driver.findElement(By.id("lastName")).clear();
	    driver.findElement(By.id("lastName")).sendKeys("singh");
	    driver.findElement(By.id("address")).clear();
	    driver.findElement(By.id("address")).sendKeys("mathekere");
	    driver.findElement(By.id("city")).clear();
	    driver.findElement(By.id("city")).sendKeys("bangalore");
	    driver.findElement(By.id("telephone")).clear();
	    driver.findElement(By.id("telephone")).sendKeys("9008630729");
	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
	    driver.findElement(By.linkText("Add New Pet")).click();
	    new Select(driver.findElement(By.id("type"))).selectByVisibleText("bird");
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys("barun bird");
	    driver.findElement(By.id("birthDate")).click();
	    driver.findElement(By.linkText("7")).click();
	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
	    driver.findElement(By.linkText("Add Visit")).click();
	    driver.findElement(By.id("description")).clear();
	    driver.findElement(By.id("description")).sendKeys("consultation with doctor");
	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
	    driver.findElement(By.linkText("Veterinarians")).click();
	    driver.findElement(By.linkText("Error")).click();
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
}
