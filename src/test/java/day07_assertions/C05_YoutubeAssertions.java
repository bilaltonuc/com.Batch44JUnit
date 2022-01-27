package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_YoutubeAssertions {
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin



    static WebDriver driver;
    @BeforeClass
    public  static void setup() {


        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");

    }

    @Test

    public void titleTest() {
        String actualTitle= driver.getTitle();
        String expectedTitle="YouTube";
        Assert.assertTrue(actualTitle.equals(expectedTitle));

    }
    //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    @Test
    public void imageTest() {
        WebElement resim= driver.findElement(By.xpath("(//yt-icon[@class='style-scope ytd-logo'])[1]"));
        Assert.assertTrue(resim.isDisplayed());


    }

    @Test
    public  void searchBoc() {
        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBox.isEnabled());

    }
    @Test
    public void wrongTitleTest() {
        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String sayfaBaşlığı= driver.getTitle();
        String aranmayanKelime="youtube";
        Assert.assertFalse("YANLIŞ OLDU",sayfaBaşlığı.equals(aranmayanKelime));
        System.out.println(driver.getTitle());
    }
    @AfterClass
    public static void close() {
        driver.close();
    }






}
