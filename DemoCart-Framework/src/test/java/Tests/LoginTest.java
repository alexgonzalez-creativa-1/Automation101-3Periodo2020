package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.loginPage;
import PageObjects.dashboardPage;

public class LoginTest extends baseTest {

    LoginTest(){
        super("chrome");
    }

    @Test
    public void doLogin() throws InterruptedException {

        loginPage login = new loginPage(driver, getBaseURL());
        dashboardPage dashboard = new dashboardPage(driver);

        login.goToPage();
        login.doLogin("alexgf08@gmail.com", "Test123");
        Assert.assertEquals(dashboard.setAccountContainger().isDisplayed(), true);


    }

}
