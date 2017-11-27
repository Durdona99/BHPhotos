package com.BHPotosTables;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bh.utilities.Driver;

public class EmployeeTestPage {

	private WebDriver driver;

	public EmployeeTestPage(WebDriver driver) {
		PageFactory.initElements(Driver.getInstance(), this);
	}

	@FindBy(css = "input[type='search']")
	public WebElement searchField;

}
