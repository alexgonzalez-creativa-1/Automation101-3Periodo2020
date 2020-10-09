package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {

    public WebDriver driver;
    public ChromeOptions chromeOptions;
    private String browser;

    public baseTest(String browser) {
        this.browser = browser;
    }

    public String getBaseURL() {
        return "https://demo.opencart.com/";
    }


    @BeforeTest
    public void setUpTest(){
       chromeOptions = new ChromeOptions();
      /* chromeOptions.addArguments("--kiosk");
       chromeOptions.addArguments("screenshot");
      chromeOptions.addArguments("--headless");
       chromeOptions.addArguments("--window-size=800,800");
       chromeOptions.addArguments("--incognito");*/

        this.setWebDriverConfiguration(browser, chromeOptions);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    private void setWebDriverConfiguration(String browser, ChromeOptions options) {
        if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }


    }
}
