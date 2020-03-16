package testCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.signIn;

import java.util.concurrent.TimeUnit;

public class signInCase {

    // som en kund vill jag kunna logga in på hemsidan.
    @Test
    public void signInTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("http://demo.prestashop.com/#/en/front");
        driver.switchTo().frame("framelive");
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        signIn login = new signIn(driver);

        login.signInToPrestaShop("aritester@testing.com","12345a");

        String name = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[2]/span")).getText();
        Assert.assertEquals("ari tester",name);

        driver.quit();

    }
}
