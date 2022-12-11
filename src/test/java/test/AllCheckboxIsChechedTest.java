package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;
import page.AllCheckboxIsChechedPage;
import util.BrowserFactory;

public class AllCheckboxIsChechedTest {

	WebDriver driver;

	@Before

	public void launchBrowser() {
		driver = BrowserFactory.init();
	}

	@Test
	public void testCase1() {

		AllCheckboxIsChechedPage allCheckboxIsChechedPage = PageFactory.initElements(driver,
				AllCheckboxIsChechedPage.class);
		allCheckboxIsChechedPage.TA();
		allCheckboxIsChechedPage.clicRemoveButton();
		allCheckboxIsChechedPage.clickToggleAll();
		Assert.assertTrue(allCheckboxIsChechedPage.validateIfAllCheckboxesAreCehcked());

	}

	@Test
	public void testCase2() {
		AllCheckboxIsChechedPage allCheckboxIsChechedPage = PageFactory.initElements(driver,
				AllCheckboxIsChechedPage.class);
		int x = allCheckboxIsChechedPage.getNumberOfCheckboxes();
		allCheckboxIsChechedPage.selectFirstCheckBox();
		allCheckboxIsChechedPage.clicRemoveButton();
		int y = allCheckboxIsChechedPage.getNumberOfCheckboxes();
		Assert.assertNotSame("not same", y, x);

	}

	@Test
	public void testCase3() {
		AllCheckboxIsChechedPage allCheckboxIsChechedPage = PageFactory.initElements(driver,
				AllCheckboxIsChechedPage.class);
		allCheckboxIsChechedPage.clickToggleAll();
		allCheckboxIsChechedPage.clicRemoveButton();
		int y = allCheckboxIsChechedPage.getNumberOfCheckboxes();
		Assert.assertEquals(1, y);

	}

	@After
	public void tearDown() {
		BrowserFactory.tearDown();
	}

}
