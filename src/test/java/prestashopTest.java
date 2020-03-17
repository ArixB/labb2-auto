import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class prestashopTest {

    static WebDriver driver = new ChromeDriver();
    static WebDriverWait wait = new WebDriverWait(driver, 30);

    @BeforeClass
    public static void setUp(){
        //driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.navigate().to("http://demo.prestashop.com/#/en/front");
        driver.manage().window().maximize();
        driver.switchTo().frame("framelive");
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);


    }

    @Before
    public void goHome(){
        System.out.println("Home page");

    }

    //Testen funkar bara engång efter måste man byta e-post för att det ska funkar igen.
    @Test
    public void  createAccount(){
        /*driver.switchTo().frame("framelive");
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);*/
        driver.findElement(By.id("_desktop_user_info")).click();
        driver.findElement(By.linkText("No account? Create one here")).click();
        driver.findElement(By.name("id_gender")).click();
        driver.findElement(By.name("firstname")).sendKeys("Rio");
        driver.findElement(By.name("lastname")).sendKeys("Tester");
        driver.findElement(By.name("email")).sendKeys("RioTester@testtt.com");
        driver.findElement(By.name("password")).sendKeys("autotest");
        driver.findElement(By.name("optin")).click();
        driver.findElement(By.name("newsletter")).click();
        driver.findElement(By.name("psgdpr")).click();
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        //String name = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[2]/span")).getText();
        //Assert.assertEquals("Rio Tester",name);

    }

    // som en kund vill jag kunna lägga varor i kundvagn
    @Test
    public void addItemToCart(){
        /*driver.switchTo().frame("framelive");
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);*/
        driver.findElement(By.cssSelector(".product-miniature:nth-child(5) img")).click();
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        driver.findElement(By.cssSelector(".cart-content-btn > .btn-primary")).click();
        driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"_desktop_cart\"]/div/div/a/span[1]"))));

        String itemNr = driver.findElement(By.xpath("//*[@id=\"cart-subtotal-products\"]/span[1]")).getText();
        Assert.assertEquals("1 item",itemNr);


    }

    @Test
    public void SignIn(){
       /* driver.switchTo().frame("framelive");
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);*/
        driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span")).click();
        driver.findElement(By.name("email")).sendKeys("jojolala@mig.com");
        driver.findElement(By.name("password")).sendKeys("jojolala");
        driver.findElement(By.id("submit-login")).click();
        String name = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[2]/span")).getText();
        Assert.assertEquals("jojo lala",name);
    }

    @AfterClass
    public static void closingTime () {

        driver.quit();

    }

}
