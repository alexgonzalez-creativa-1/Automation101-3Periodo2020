package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {

    public WebDriver driver;
    private String browser;

    public baseTest(String browser) {
        this.browser = browser;
    }

    public String getBaseURL() {
        return "https://demo.opencart.com/";
    }

    @BeforeTest
    public void setUpTest(){
        this.setWebDriverConfiguration(browser);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    private void setWebDriverConfiguration(String browser) {
        if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }


    }
}
