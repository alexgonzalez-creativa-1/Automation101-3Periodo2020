package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.loginPage;
import PageObjects.dashboardPage;

import DataProviders.usersDataProvider;
import pojo.loginData;

import utilities.waits;

public class LoginTest extends baseTest {

    LoginTest(){
        super("chrome");
    }

    @Test(groups = {"sanity"}, dataProvider = "getUsersDataFromJson", dataProviderClass = usersDataProvider.class)
    public void doLogin(loginData _loginData) throws InterruptedException {

        loginPage login = new loginPage(driver, getBaseURL());
        waits wait = new waits(driver);
        dashboardPage dashboard = new dashboardPage(driver);

        login.goToPage();
        login.doLogin(_loginData.getEmail(), _loginData.getPassword());
        wait.untilElementExists(dashboard.setAccountContainger());
        Assert.assertEquals(dashboard.setAccountContainger().isDisplayed(), true);
    }

    @Test(groups = {"sanity"}, dataProvider = "getWrongUsersDataFromJson", dataProviderClass = usersDataProvider.class)
    public void doNotAllowUsersToLogin(loginData _loginData) throws InterruptedException {

        loginPage login = new loginPage(driver, getBaseURL());
        waits wait = new waits(driver);
        dashboardPage dashboard = new dashboardPage(driver);

        login.goToPage();
        login.doLogin(_loginData.getEmail(), _loginData.getPassword());
       Assert.assertEquals(login.setWrongCredentialsMessage().isDisplayed(), true);
    }


}
