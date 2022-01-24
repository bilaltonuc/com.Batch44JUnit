package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TekrarTesti {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1-C01_TekrarTesti isimli bir class olusturun
        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        //3- cookies uyarisini kabul ederek kapatin
        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin

        String actualTitle= driver.getTitle();
        String expectedTitle="Google";
        if (actualTitle.contains(expectedTitle)){
            System.out.println("içeriyor PASSED");
        }else {
            System.out.println("içermiyor FAİLED");
        }
        //5- Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Nutella"+Keys.ENTER);

        //6-Bulunan sonuc sayisini yazdirin
        WebElement sayı= driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sayı.getText());




        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String SonucSayısıString=sayı.getText();
        String sonucKelimeleri[]=SonucSayısıString.split(" ");
        String sonucNutellaSayısıString=sonucKelimeleri[1];
        sonucNutellaSayısıString=sonucNutellaSayısıString.replace(".","");

       int nutellaAramaSonucu=Integer.parseInt(sonucNutellaSayısıString);

       if (nutellaAramaSonucu>10000000){
           System.out.println("buyuklugu PASS");

       }else {
           System.out.println("buyuklugu FAİLED");
       }
        //8-Sayfayi kapatin

        driver.close();

    }
}
