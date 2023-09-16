package tests.day02_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_DriverMethodlari {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // ChromeDriver kullanarak facebook sayfasina gidin
        driver.get("https://www.facebook.com");
        // ve sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        String expectedTitle = "facebook";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Facebook title testi PASSED");
        }else{
            System.out.println("Facebook sayfasinda title facebook icermiyor, test FAILED. " +
                    "\nActual Title : " + actualTitle);
        }
        // Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        String expectedUrlIcerik = "facebook";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Facebook Url testi PASSED");
        }else{
            System.out.println("Facebook sayfasinda Url facebook icermiyor, test FAILED. " +
                    "\nActual Url : " + actualUrl);
        }
        // https://www.walmart.com/ sayfasina gidin.
        driver.navigate().to("https://www.walmart.com/");

        // Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String expectedTitleIcerik = "Walmart.com";
        actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Walmart Title testi PASSED");
        }else{
            System.out.println("Walmart title'i istenen icerigi barindirmiyor test FAILED\n" +
                    "Actual title : " + actualTitle);
        }

        // Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        // Sayfayi yenileyin
        driver.navigate().refresh();
        // Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
        // Browser’i  kapatin
        Thread.sleep(3000);
        driver.close();
    }
}
