package tests.day01_driverMethodlari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_driverNavigateMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.navigate().to("https://www.amazon.com");
        Thread.sleep(1000);

        driver.navigate().to("https://www.youtube.com");
        Thread.sleep(1000);
        // tekrar amazon'a donelim

        driver.navigate().back();
        Thread.sleep(1000);
        // tekrar youtube'a gidelim

        driver.navigate().forward();
        Thread.sleep(1000);
        driver.close();
    }
}
