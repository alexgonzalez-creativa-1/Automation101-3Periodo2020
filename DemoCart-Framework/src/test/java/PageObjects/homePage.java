package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class homePage extends basePage{

    public homePage(WebDriver driver, String url) {
        super(driver, url);
    }

    private By searchTextBox = By.xpath("//input[@name='search']");

    public WebElement getSearchTextBox() {
        return driver.findElement(this.searchTextBox);
    }

    public void doSearch(String productName) {
        getSearchTextBox().sendKeys(productName);
        getSearchTextBox().sendKeys(Keys.ENTER);
    }

}
