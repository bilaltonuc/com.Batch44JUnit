package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_TekSayfadaFarklıTestler {
    static WebDriver driver;
    static WebElement aramaKutusu;
    static WebElement sonucYazısıElementi;


    @Test
    public void Test1(){
        //amzonsayfasında  nutella için armaa yapıp nutella ıcerip içermedıgını test edın
       aramaKutusu.sendKeys("nutella"+ Keys.ENTER);
       sonucYazısıElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
       String actualSonuc=sonucYazısıElementi.getText();
       String arananKelime="nutella";
       if (actualSonuc.contains(arananKelime)){
           System.out.println("içeriyor");
       }else{
           System.out.println("içermiyor");
       }


    }
    @Test
    public void  Test2() {
       //amazon sayfasında java ıcın arama ypıpı java ıcerıp ıcermedgını test edıj
        aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("java"+ Keys.ENTER);
        sonucYazısıElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualSonuc=sonucYazısıElementi.getText();
        String arananKelime="java";
        if (actualSonuc.contains(arananKelime)){
            System.out.println("içeriyor");
        }else{
            System.out.println("içermiyor");
        }
    }
    @Test
    public void Test3() {
       //amazon sayfasında ali için arama yapıp sonuc yazısının ali içerip içermediğini test edin
        aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("ali"+ Keys.ENTER);
        sonucYazısıElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualSonuc=sonucYazısıElementi.getText();
        String arananKelime="ali";
        if (actualSonuc.contains(arananKelime)){
            System.out.println("içeriyor");
        }else{
            System.out.println("içermiyor");
        }


    }
    @BeforeClass
    public static void ayarlar() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
        aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
    }

    @AfterClass
    public static void ortalığıTopla() {

driver.close();
    }




}
