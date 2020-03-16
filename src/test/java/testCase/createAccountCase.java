package testCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.createAccount;

import java.util.concurrent.TimeUnit;

public  class createAccountCase {

//Som en kund vill jag kunna skapa en konto

    @Test
    public void createAccountTest(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("http://demo.prestashop.com/#/en/front");
        driver.switchTo().frame("framelive");
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        createAccount create = new createAccount(driver);

        create.createAccountOnPrestaShop("ari", "tester", "aritester@testing1.com", "123abc");

        String name = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[2]/span")).getText();
        Assert.assertEquals("ari tester",name);

        driver.quit();

    }
}
