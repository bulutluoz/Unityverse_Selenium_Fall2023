package tests.day02_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_linkText_partialLinkText {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        // Gift Cards linkine tiklayalim

        // driver.findElement(By.linkText("Gift Cards")).click();

        // Burada linkText String olarak yazildigindan,
        // bosluklar ve buyuk kucuk harf onemli olacaktir
        // linkText dendiginde HTML kodun acilis ve kapanis taglari arasindaki metin
        //  tamamen yazilmalidir <a>Gift Cards</a>

        // driver.findElement(By.linkText("Gift Cards ")).click();

        // Eger tum metni degil de metnin bir parcasini kullanmak isterseniz
        // linkText() yerine partialLinkText() kullanabilirsiniz

        //driver.findElement(By.partialLinkText("Cards")).click();
        driver.findElement(By.partialLinkText("ards")).click();


        Thread.sleep(5000);
        driver.close();

    }
}
