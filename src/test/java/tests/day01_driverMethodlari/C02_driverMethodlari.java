package tests.day01_driverMethodlari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_driverMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");

        System.out.println(driver.getCurrentUrl()); // https://www.amazon.com/

        System.out.println(driver.getTitle()); // Amazon.com. Spend less. Smile more.

        System.out.println(driver.getWindowHandle()); // 5D189AD5C5AAF2A6A4523673966D621E

        System.out.println(driver.getWindowHandles()); // [5D189AD5C5AAF2A6A4523673966D621E]

        System.out.println(driver.getPageSource());


        Thread.sleep(3000);
        driver.close();
    }
}
