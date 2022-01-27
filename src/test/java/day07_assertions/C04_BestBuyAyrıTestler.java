package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BestBuyAyrıTestler {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }

    @Test
    public void Url() {
        driver.get("https://www.bestbuy.com/");
        //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.bestbuy.com/";
        Assert.assertEquals("asdad", expectedUrl, actualUrl);

    }

    @Test
    public void TestTitle() {

        //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String actualBaşlık = driver.getTitle();
        String istenmeyenKelime = "Rest";
        Assert.assertFalse(actualBaşlık.contains(istenmeyenKelime));
    }

    @Test
    public void logoTesti() {
        //○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logo = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));

        Assert.assertTrue(logo.isDisplayed());


    }

    @Test
    public void  franca() {
        //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement franca=driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue(franca.isDisplayed());
    }
    @AfterClass
    public void arkayıTopla() {
        driver.close();

    }
}