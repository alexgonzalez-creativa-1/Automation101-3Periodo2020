package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage extends basePage{

        private By emailTextBox = By.id("input-email");
        private By passwordTextBox = By.id("input-password");
        private By loginButton = By.xpath("//input[@value='Login']");

        private By wrongCredentialsLabel = By.xpath("//div[@class='alert alert-danger alert-dismissible']");


        public loginPage(WebDriver driver) {
            super(driver);
        }
        public loginPage(WebDriver driver, String url){
            super(driver, url + "index.php?route=account/login");
        }


    public WebElement setEmailTextBox() {
        return driver.findElement(this.emailTextBox);
    }

    public WebElement setPasswordTextBox() {
        return driver.findElement(this.passwordTextBox);
    }

    public WebElement setLoginButton() {
        return driver.findElement(this.loginButton);
    }

    public WebElement setWrongCredentialsMessage() {
            return driver.findElement((this.wrongCredentialsLabel));
    }

    public void doLogin(String email, String password) {
        this.setEmailTextBox().sendKeys(email);
        this.setPasswordTextBox().sendKeys(password);
        this.setLoginButton().click();
    }
}
