import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.*;
import org.testng.annotations.Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginTest {

    private WebDriver driver;

    @BeforeTest
    public void setUpTest(){
        String currentDirectory = System.getProperty("user.dir");
        System.out.println(currentDirectory);
        String driverPath = currentDirectory.concat("/src/test/resources/drivers/chromedriver");
        System.out.println(driverPath);
        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();
    }

    @Test
    public void doLogin() throws InterruptedException {

        driver.get("https://demo.opencart.com/index.php?route=account/login");

        driver.findElement(By.id("input-email")).sendKeys("alexgf08@gmail.com");

        driver.findElement(By.id("input-password")).sendKeys("Test123");

        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Assert.assertEquals(driver.findElement(By.id("account-account")).isDisplayed(), true);

        Thread.sleep(5);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


}
