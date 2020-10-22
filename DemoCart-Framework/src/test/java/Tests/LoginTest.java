package Tests;

import io.qameta.allure.*;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.loginPage;
import PageObjects.dashboardPage;

import DataProviders.usersDataProvider;
import pojo.loginData;

import utilities.waits;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class LoginTest extends baseTest {



    LoginTest(){
        super("chrome");
    }

    @Test(groups = {"sanity"}, dataProvider = "getUsersDataFromJson", dataProviderClass = usersDataProvider.class, description = "User is allowed to do login and go to account dashboard")
    @Description("User is allowed to do login and go to account dashboard")
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
    @Description("User with wrong credentials is not able to login and warning message is displayed")
    @Link("https://example.org")
    @Attachment(value = "Screenshot", type = "image/png")
    public void doNotAllowUsersToLogin(loginData _loginData) throws InterruptedException, FileNotFoundException {


        loginPage login = new loginPage(driver, getBaseURL());
        waits wait = new waits(driver);
        dashboardPage dashboard = new dashboardPage(driver);

        login.goToPage();
        login.doLogin(_loginData.getEmail(), _loginData.getPassword());

        Allure.addAttachment("image", new FileInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)));

        Assert.assertEquals(login.setWrongCredentialsMessage().isDisplayed(), false);
    }


}
