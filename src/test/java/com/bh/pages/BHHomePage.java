package com.bh.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bh.utilities.Driver;

public class BHHomePage {
	private WebDriver driver;

	public BHHomePage() {
		this.driver = driver;

		PageFactory.initElements(Driver.getInstance(), this);
	}

	@FindBy(css = ".bold.myaccount-header")
	public WebElement logInWait;

	@FindBy(css = ".create-account")
	public WebElement myAccount;

	@FindBy(css = "input[name='firstName']")
	public WebElement firstName;

	@FindBy(css = "input[name='lastName']")
	public WebElement lastName;

	@FindBy(css = "input[name='newEmailAddress']")
	public WebElement emailElement;

	@FindBy(css = "input[name='retypedNewEmailAddress']")
	public WebElement confirmEmail;

	@FindBy(css = "input[name='newPassword']")
	public WebElement password;

	@FindBy(css = "input[name='retypedNewPassword']")
	public WebElement confirmPassword;

	@FindBy(css = ".c12.bold.fs18")
	public WebElement registerButton;

	@FindBy(css = "#top-search-input")
	public WebElement search;
}
