package org.fb;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseCls_UsrDfindCls {
	public static WebDriver driver;
	public static WebElement element;

	public static void launchBrowser(String browser) {

		if (browser.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "D:\\NewWorkspoace\\Maven_Demo\\drivers\\chromedriver.exe");

			driver = new ChromeDriver();

		} else {
			if (browser.equals("ie")) {
				System.setProperty("webdriver.ie.driver",
						"C:\\Users\\ELCOT-Lenovo\\eclipse-workspace\\SeleniumDemo\\driver\\IEDriverServer.exe");

				driver = new InternetExplorerDriver();
			} else {
				System.setProperty("webdriver.gecko.driver", "D:\\NewWorkspoace\\Maven_Demo\\drivers\\geckodriver.exe");

				driver = new FirefoxDriver();

			}

		}

	}

	public static void launchUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void getText(WebElement w) {

		w.getAttribute("value");
	}

	public static void getThetitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void getTheUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void passValue(WebElement e, String value) {

		e.sendKeys(value);

	}

	public static void passValue_xpath(String xpath, String value) {
		WebElement w = driver.findElement(By.xpath(xpath));
		w.sendKeys(value);

	}
	public void screenshot(String s) throws Exception {
		
	TakesScreenshot tk=(TakesScreenshot)driver;
	File temp = tk.getScreenshotAs(OutputType.FILE);
	File perm=new File("D:\\NewWorkspoace\\Maven_Demo\\screenShot"+s+".png");
	FileUtils.copyFile(temp, perm);
	
	}
	public void clearTxt(String S) {
		WebElement r=driver.findElement(By.xpath(S));
		r.clear();
	}
	public void clearTxtWeb(WebElement e) {
		e.clear();
	}

	public static void quit() {
		driver.quit();
	}

	public static void fillTheTextBox(String locator, String key, String value) {

		switch (locator.toUpperCase()) {

		case "ID":
			element = driver.findElement(By.id(key));
			element.sendKeys(value);
			break;

		case "NAME":
			element = driver.findElement(By.name(key));
			element.sendKeys(value);

		case "CLASS":
			element = driver.findElement(By.className(key));
			element.sendKeys(value);

		}

	}

	// alert
	public static void abnormalPopup_ok() {
		Alert a = driver.switchTo().alert();

		a.accept();
	}

	public static void abnormalPopup_cancle() {
		Alert b = driver.switchTo().alert();

		b.dismiss();
	}

	public static void abnormalPopup_txt(String N) {
		Alert c = driver.switchTo().alert();

		c.sendKeys(N);

	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static void clickXpath(String p) {

		WebElement a = driver.findElement(By.xpath(p));

		a.click();

	}

	public static void click_Normal(WebElement a) {

		a.click();

	}

	// dropdown
	public static void selectOption_ByText(String dropXpath, String txt) {

		WebElement month = driver.findElement(By.xpath(dropXpath));
		Select s1 = new Select(month);
		s1.selectByVisibleText(txt);

	}

	public static void selectOption_ByValue(String dropXpath, String value) {

		WebElement month = driver.findElement(By.xpath(dropXpath));
		Select s1 = new Select(month);
		s1.selectByValue(value);

	}

	public static void selectOption_ByIndex(String dropXpath, String index) {

		WebElement month = driver.findElement(By.xpath(dropXpath));
		Select s1 = new Select(month);
		s1.selectByVisibleText(index);

	}

	public static void pomSelectOption_ByText(WebElement pomGet, String txt) {

		Select s1 = new Select(pomGet);
		s1.selectByVisibleText(txt);

	}

	public static void pomSelectOption_ByValue(WebElement pomGet, String value) {

		Select s1 = new Select(pomGet);
		s1.selectByValue(value);

	}

	public static void pomSelectOption_ByIndex(WebElement pomGet, String index) {

		Select s1 = new Select(pomGet);
		s1.selectByVisibleText(index);

	}

	// keyboard

	public static void cutAndPaste(String txtboxCopy, String name, String txtboxPaste) throws AWTException {

		element = driver.findElement(By.xpath(txtboxCopy));

		element.sendKeys(name);

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_X);

		element = driver.findElement(By.xpath(txtboxPaste));

		element.click();

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}

	public static void copyAndPaste(String txtboxCopy, String name, String txtboxPaste) throws AWTException {

		element = driver.findElement(By.xpath(txtboxCopy));

		element.sendKeys(name);

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);

		element = driver.findElement(By.xpath(txtboxPaste));

		element.click();

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);

	}

}