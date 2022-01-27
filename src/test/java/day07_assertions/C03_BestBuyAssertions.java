package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BestBuyAssertions {

    //1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki
    //testleri yapin
    //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin


   WebDriver driver;

    @Before
    public  void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void Test1(){
        driver.get("https://www.bestbuy.com/");
        //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin

      String actualUrl=driver.getCurrentUrl();
      String expectedUrl="https://www.bestbuy.com/";
        Assert.assertEquals("asdad",expectedUrl,actualUrl);
        //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String actualBaşlık= driver.getTitle();
        String istenmeyenKelime="Rest";
        Assert.assertFalse(actualBaşlık.contains(istenmeyenKelime));
        //○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logo=driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));

        Assert.assertTrue(logo.isDisplayed());

        //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement franca=driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue(logo.isDisplayed());



    }

@After
    public  void son() {
        driver.close();
}

}
