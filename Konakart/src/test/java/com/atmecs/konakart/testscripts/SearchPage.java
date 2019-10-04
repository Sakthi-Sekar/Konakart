package com.atmecs.konakart.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.atmecs.konakart.testbase.InvokeBrowser;
import com.atmecs.konakart.utils.PageActions;
import com.atmecs.konakart.utils.ReadExcelData1;
import com.atmecs.konakart.utils.ValidateTestResult;

public class SearchPage extends InvokeBrowser {
	@Test(priority = 2)
	public void clickOnSearch() {
		Xpath = read.readPropertiesFile("loc.search.xpath");
		PageActions.clickOnElement(driver, Xpath);
	}

	@Test(priority = 3)
	public void selectFromDropDown() {
		Xpath = read.readPropertiesFile("loc.dropdown.product.xpath");
		PageActions.clickOnElement(driver, Xpath);
	}

	@Test(priority = 4, dataProvider = "data", dataProviderClass = ReadExcelData1.class)
	public void enterData(String[] in) {
		Xpath = read.readPropertiesFile("loc.typesearch.xpath");
		driver.findElement(By.xpath(Xpath)).sendKeys(in[0]);
		log.info("Entered the data");
		Xpath = read.readPropertiesFile("loc.hitonsearch.xpath");
		PageActions.clickOnElement(driver, Xpath);

	}

	@Test(priority = 5)
	public void validateValidOutcome() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Xpath = read.readPropertiesFile("loc.validate.validoutcome.xpath");
		String validoutcome = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(validoutcome, "validinput", "No matches");
		log.info("Call of duty");
	}

	@Test(priority = 6)
	public void validateInvalidOutcome() {
		Xpath = read.readPropertiesFile("loc.invalidinput.xpath");
		String invalidoutcome = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(invalidoutcome, "invalidinput", "No match");
	}

}
