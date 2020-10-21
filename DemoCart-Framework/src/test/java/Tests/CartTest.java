package Tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.homePage;
import PageObjects.searchResultsPage;
import utilities.waits;
import DataProviders.productsDataProvider;
import pojo.productData;

@Epic("Cart Tests")
public class CartTest extends baseTest{

    public CartTest() {
        super("chrome");
    }

    @Test(groups = {"sanity"}, dataProvider = "getProductsFromJson", dataProviderClass = productsDataProvider.class, description = "Anonymous user is able to add items to cart")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Add to cart")
    @Owner("Alex")
    public void addItemToCartAsAnonymous(productData _products) throws InterruptedException {
        homePage home = new homePage(driver, getBaseURL());
        searchResultsPage searchResults = new searchResultsPage(driver);
        waits wait = new waits(driver);
        home.goToPage();
        home.doSearch(_products.getName());
        Assert.assertEquals(searchResults.getProductTile().size() > 0,true);
        if(!(searchResults.getProductTile().size() > 0)) {
            Assert.fail("Empty list");
        }
        searchResults.addProductToCart();
        wait.waitForJSandJQueryToLoad();
        Assert.assertEquals(searchResults.getSuccessModal().isDisplayed(), true);
    }
}
