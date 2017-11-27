package com.BHPotosTables;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bh.utilities.Driver;

public class CreateNewPage {
	private WebDriver driver;

	public CreateNewPage(WebDriver driver) {
		PageFactory.initElements(Driver.getInstance(), this);
	}

	@FindBy(css = "#DTE_Field_first_name")
	public WebElement firstName;

	@FindBy(css = "#DTE_Field_last_name")
	public WebElement lastName;

	@FindBy(css = "#DTE_Field_position")
	public WebElement position;

	@FindBy(css = "#DTE_Field_office")
	public WebElement office;

	@FindBy(css = "#DTE_Field_extn")
	public WebElement extension;

	@FindBy(css = "#DTE_Field_start_date")
	public WebElement startDate;

	@FindBy(css = "#DTE_Field_salary")
	public WebElement salary;

	@FindBy(css = ".btn")
	public WebElement createButton;

	@FindBy(css = ".c12.bold.fs18")
	public WebElement register;
}
