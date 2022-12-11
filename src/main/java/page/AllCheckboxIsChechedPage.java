package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AllCheckboxIsChechedPage {

	WebDriver driver;

	public AllCheckboxIsChechedPage(WebDriver driver) {

		this.driver = driver;

	}

	// Finding Element
	@FindBy(how = How.NAME, using = "allbox")
	WebElement toggleAll;

	@FindBy(how = How.NAME, using = "data")
	WebElement addName;

	@FindBy(how = How.CSS, using = "input[value='Add']")
	WebElement addButton;

	@FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
	List<WebElement> allCheckBoxes;

	@FindBy(how = How.NAME, using = "todo[0]")
	WebElement checkbox1;

	@FindBy(how = How.CSS, using = "input[value='Remove']")
	WebElement removeButton;

	// Using Element
	
	
	
	public void TA() {
		toggleAll.click();
	}
	
	public void clickToggleAll() {

		if (allCheckBoxes.size() > 1) {
			toggleAll.click();
		} else {
			createNewList("Item # 1 - Created by Ahmed Ali");
			createNewList("Item # 2 - Created by Ahmed Ali");
			createNewList("Item # 3 - Created by Ahmed Ali");
			toggleAll.click();

		}

	}

	public boolean validateIfAllCheckboxesAreCehcked() {

		boolean booleanVariable = false;
		for (int i = 0; i < allCheckBoxes.size(); i++) {

			if (allCheckBoxes.get(i).isSelected()) {
				booleanVariable = true;
				System.out.println("checkbox index value selcted " + i);

			}

		}
		return booleanVariable;
	}

	public void createNewList(String newListText) {

		addName.sendKeys(newListText);
		addButton.click();
	}

	public void selectFirstCheckBox() {
		checkbox1.click();
	}

	public void clicRemoveButton() {
		removeButton.click();
	}

	public int getNumberOfCheckboxes() {
		
		
		System.out.println("Number of Checkboxes: " + allCheckBoxes.size());
		
		return allCheckBoxes.size();
	
	}
	
}
