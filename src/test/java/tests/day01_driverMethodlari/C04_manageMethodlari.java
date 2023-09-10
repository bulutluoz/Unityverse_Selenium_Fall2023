package tests.day01_driverMethodlari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class C04_manageMethodlari {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        System.out.println("maximize yapmadan once size : "+driver.manage().window().getSize());
        System.out.println("maximize yapmadan once position : "+driver.manage().window().getPosition());
        driver.manage().window().maximize();

        System.out.println("maximize yaptiktan sonra size : "+driver.manage().window().getSize());
        System.out.println("maximize yaptiktan sonra position : "+driver.manage().window().getPosition());

        driver.manage().window().fullscreen();

        System.out.println("fullscreen yaptiktan sonra size : "+driver.manage().window().getSize());
        System.out.println("fullscreen yaptiktan sonra position : "+driver.manage().window().getPosition());


        driver.manage().window().setPosition(new Point(100,100));
        driver.manage().window().setSize(new Dimension(500,500));
        System.out.println("set yaptiktan sonra size : "+driver.manage().window().getSize());
        System.out.println("set yaptiktan sonra position : "+driver.manage().window().getPosition());




        /*
            Testimizi calistirirken
            ilk basta sayfanin yuklenmesi uzun surebilir,
            ayrica driver'in sayfada kullanacagi web elementlerini
            bulmasi da zaman alabilir

            implicitlyWait bu tur islemler icin
            driver'in beklemesini istedigimiz maximum sureyi belirtir
            driver her bir islem icin yazdigimiz max sure kadar bekleyebilir
            max sure icerisinde islemi yapamazsa HATA verir

            Her test method'unda driver olustururken
            implicitlyWait() de yazmakta fayda vardir

         */


        Thread.sleep(3000);
        driver.close();
    }
}
