package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public void waitForElement(WebDriver driver, int timeInSeconds, WebElement ElementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.visibilityOf(ElementLocator));

	}

	public void selectDropDown(WebElement elementLocator, String visibleText) {
		Select sc = new Select(elementLocator);
		sc.selectByVisibleText(visibleText);
	}

	public int randomGenerator(int boundaryNumber) {
		Random rnd = new Random();
		int randomNumber = rnd.nextInt(boundaryNumber);
		return randomNumber;

	}

}
