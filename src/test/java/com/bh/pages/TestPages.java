package com.bh.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bh.utilities.Driver;

public class TestPages {
	private WebDriver driver;

	public TestPages() {
		this.driver = driver;
		PageFactory.initElements(Driver.getInstance(), this);
	}

	@FindBy(css = "#mail")
	public WebElement tempEmail;

}
