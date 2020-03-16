package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class createAccount {

    WebDriver driver;

    By signInLink = By.id("_desktop_user_info");
    By createAccountLink = By.linkText("No account? Create one here");
    By userGender = By.name("id_gender");
    By firstname = By.name("firstname");
    By lastname = By.name("lastname");
    By email = By.name("email");
    By password = By.name("password");
    By checkbox1 = By.name("optin");
    By checkbox2 = By.name("newsletter");
    By checkbox3 = By.name("psgdpr");
    By signInButton = By.xpath("(//button[@type='submit'])[2]");

    public createAccount(WebDriver driver){
        this.driver=driver;

    }

    public void createAccountOnPrestaShop(String userFirstname, String userLastname, String userMail, String userPass){

        driver.findElement(signInLink).click();
        driver.findElement(createAccountLink).click();
        driver.findElement(userGender).click();
        driver.findElement(firstname).sendKeys(userFirstname);
        driver.findElement(lastname).sendKeys(userLastname);
        driver.findElement(email).sendKeys(userMail);
        driver.findElement(password).sendKeys(userPass);
        driver.findElement(checkbox1).click();
        driver.findElement(checkbox2).click();
        driver.findElement(checkbox3).click();
        driver.findElement(signInButton).click();
    }
}