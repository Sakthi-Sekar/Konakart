package com.atmecs.konakart.testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.atmecs.konakart.testbase.InvokeBrowser;
import com.atmecs.konakart.utils.PageActions;
import com.atmecs.konakart.utils.ValidateTestResult;

public class HeroImagePage extends InvokeBrowser {
	@Test(priority = 2)
	public void clickOnHeroImage() {
		Xpath = read.readPropertiesFile("loc.heroimage.click.xpath");
		PageActions.clickOnElement(driver, Xpath);
	}

	@Test(priority = 3)
	public void navigateTabs() {
		Xpath = read.readPropertiesFile("loc.navigate.specifications.xpath");
		PageActions.clickOnElement(driver, Xpath);
		Xpath = read.readPropertiesFile("loc.navigate.customer.xpath");
		PageActions.clickOnElement(driver, Xpath);
	}

	@Test(priority = 4)
	public void validateContent() {
		Xpath = read.readPropertiesFile("loc.validatecontent.description.xpath");
		String desc = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(desc, "description", "No matches");

		Xpath = read.readPropertiesFile("loc.validatecontent.specifications.xpath");
		String speccontent = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(speccontent, "specvalue", "No matches");

		Xpath = read.readPropertiesFile("loc.validatecontent.customer.xpath");
		String customercontent = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(customercontent, "customervalue", "No matches");
	}

	@Test(priority = 5)
	public void validateSortByNumber() {
		Xpath = read.readPropertiesFile("loc.sortbynumber.click.xpath");
		PageActions.clickOnElement(driver, Xpath);

		Xpath = read.readPropertiesFile("loc.validate.sortperpage.xpath");
		PageActions.clickOnElement(driver, Xpath);

		Xpath = read.readPropertiesFile("loc.validate.sortperpage.xpath");
		String perpage = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(perpage, "numberperpage", "No match");
	}

	@Test(priority = 6)
	public void validateSortByActions() {
		Xpath = read.readPropertiesFile("loc.sortbyaction.click.xpath");
		PageActions.clickOnElement(driver, Xpath);

		Xpath = read.readPropertiesFile("loc.validate.sortbyactions.xpath");
		PageActions.clickOnElement(driver, Xpath);

		Xpath = read.readPropertiesFile("loc.validate.sortbyactions.xpath");
		String byaction = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(byaction, "sortbyaction", "No match");
	}
}
