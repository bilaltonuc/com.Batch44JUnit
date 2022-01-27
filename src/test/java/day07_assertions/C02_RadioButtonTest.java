package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_RadioButtonTest {
    WebDriver driver;

    //1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void Test1() {
        //- https://www.facebook.com adresine gidin
        //- Cookies’i kabul edin
        //- “Create an Account” button’una basin
        //- “radio buttons” elementlerini locate edin
        //- Secili degilse cinsiyet butonundan size uygun olani secin
        driver.get("https://www.facebook.com");
        WebElement accountCreate=driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        accountCreate.click();
        WebElement cinsiyetClick= driver.findElement(By.xpath("//input[@value='2']"));
        cinsiyetClick.click();

    }

    @After
    public void teardown() {

        driver.close();
    }
}
