package PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class searchResultsPage extends basePage{

    public searchResultsPage(WebDriver driver) {
        super(driver);
    }

    private By productTile = By.xpath("//div[contains(@class,'product-layout')]");
    private By addToCartButton = By.xpath("//div[contains(@class,'product-layout')]//button[contains(span,'Add to Cart')]");
    private By successModal =  By.xpath("//div[contains(@class, 'alert alert-success alert-dismissible')]");

    public List<WebElement> getProductTile() {
        return driver.findElements(this.productTile);
    }

    public  WebElement getAddToCartButton() {
        return driver.findElement(this.addToCartButton);
    }

    public WebElement getSuccessModal() {
        return driver.findElement(this.successModal);
    }

    @Step("Add Product to Cart")
    public void addProductToCart() {
        this.getAddToCartButton().click();
    }



}
