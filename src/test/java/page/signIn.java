package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signIn {

    WebDriver driver;

    By signInLink = By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span");
    By userMail = By.name("email");
    By password = By.name("password");
    By signInButton = By.id("submit-login");

    public signIn(WebDriver driver){
        this.driver = driver;
    }

    public void signInToPrestaShop(String userId, String userPassword){

        driver.findElement(signInLink).click();
        driver.findElement(userMail).sendKeys(userId);
        driver.findElement(password).sendKeys(userPassword);
        driver.findElement(signInButton).click();

    }

}
