package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ilkTestMetodu {

    WebDriver driver;



    @Test
    public void Test1() {
        System.out.println("1.method çalıştı");
    }

    @Test
    public void Test2(){
        System.out.println("2.method çalıştı");

    }

    @Before
    public void ayarlarıDuzenle(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @After
    public void ortalığıTopla() {

      driver.close();
    }


}
