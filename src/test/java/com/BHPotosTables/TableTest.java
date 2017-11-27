package com.BHPotosTables;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bh.utilities.Config;
import com.bh.utilities.Driver;

public class TableTest {
	static WebDriver driver;
	WebElement webtable1 = driver.findElement(By.cssSelector(".display.dataTable"));

	@BeforeClass
	public static void setUp() {
		driver = Driver.getInstance();
		driver.get(Config.getProperty("url"));

	}

	@Test
	public void testData() {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(webtable1));
		WebElement header = webtable1.findElement(By.tagName("thead"));

		List<WebElement> columns = header.findElements(By.tagName("th"));
		Assert.assertEquals(columns.size(), 6);
		String expectedHeaders = "Name Position Office Extn. Start date Salary";
		// System.out.println(header.getText());
		Assert.assertEquals(header.getText(), expectedHeaders);

		List<WebElement> rows = webtable1.findElements(By.tagName("tr"));
		for (int rowNum = 1; rowNum < rows.size() - 1; rowNum++) {
			if (webtable1.findElement(By.xpath("//tbody/tr[" + rowNum + "]/td[1]")).getText().equals("Bruno Nash")) {
				Assert.assertEquals(webtable1.findElement(By.xpath("//tbody/tr[" + rowNum + "]/td[2]")).getText(),
						"Software Engineer");
				Assert.assertEquals(webtable1.findElement(By.xpath("//tbody/tr[" + rowNum + "]/td[3]")).getText(),
						"London");

			}
		}

		for (WebElement row : rows) {
			System.out.println(row.getText());
		}

		driver.findElement(By.linkText("New")).click();
	}

	@Test
	public void createTest() throws InterruptedException {
		CreateNewPage page = new CreateNewPage(Driver.getInstance());
		page.firstName.sendKeys(Config.getProperty("fName"));
		page.lastName.sendKeys(Config.getProperty("lName"));
		page.position.sendKeys(Config.getProperty("position"));
		page.office.sendKeys(Config.getProperty("office"));
		page.extension.sendKeys(Config.getProperty("extension"));
		page.startDate.sendKeys(Config.getProperty("startDate"));
		page.salary.sendKeys(Config.getProperty("salary"));
		page.createButton.click();
		// String

		EmployeeTestPage employee = new EmployeeTestPage(Driver.getInstance());
		employee.searchField.sendKeys(Config.getProperty("fName") + " " + Config.getProperty("lName"));

		Thread.sleep(3000);

		String actualResult = driver.findElement(By.cssSelector(".odd")).getText().replaceAll("\\$", "").replaceAll(",",
				"");
		String expectedResult = Config.getProperty("fName") + " " + Config.getProperty("lName") + " "
				+ Config.getProperty("position") + " " + Config.getProperty("office") + " "
				+ Config.getProperty("extension") + " " + Config.getProperty("startDate") + " "
				+ Config.getProperty("salary");
		Assert.assertEquals(expectedResult, actualResult);

	}

}
