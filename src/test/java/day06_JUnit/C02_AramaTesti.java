package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_AramaTesti {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna “standard_user” yazdirin

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce"+ Keys.ENTER);

        //4. Login tusuna basin

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin,
        WebElement ilkUrunElementi= driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String ilkUrunKayıt=ilkUrunElementi.getText();
        ilkUrunElementi.click();
        //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.id("shopping_cart_container")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement seciliÜrün= driver.findElement(By.id("item_4_title_link"));
        String seçiliÜrün=seciliÜrün.getText();
        if (ilkUrunKayıt.equals(seçiliÜrün)){

            System.out.println("urun testi PASSED");

        }else {

            System.out.println("urun testi FAİLED");
        }
        //9. Sayfayi kapatin
        driver.close();





    }
}
