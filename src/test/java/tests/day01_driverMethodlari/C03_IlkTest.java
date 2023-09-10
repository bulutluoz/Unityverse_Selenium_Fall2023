package tests.day01_driverMethodlari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_IlkTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //3. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com");
        //4. Sayfa basligini(title) yazdirin
        System.out.println("Sayfa basligi : "+driver.getTitle());
        //5. Sayfa basliginin “Amazon” icerdigini test edin


        String expectedIcerik = "Amazon";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedIcerik)){
            System.out.println("Title testi PASSED");
        }else{
            System.out.println("Title "+ expectedIcerik + " icermiyor, Test FAILED");
        }

        //6. Sayfa adresini(url) yazdirin
        System.out.println("Sayfa Url : "+driver.getCurrentUrl());
        //7. Sayfa url’inin “amazon” icerdigini test edin.

        String expectedUrlIcerik = "amazon";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Url testi PASSED");
        }else {
            System.out.println("Url " + expectedUrlIcerik+ " kelimesi icermiyor, Test FAILED");
        }

        //8. Sayfa handle degerini yazdirin
        System.out.println("Sayfa Handle degeri : "+driver.getWindowHandle());
        //9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin

        String expectedHtmlIcerik = "alisveris";
        String actualPageSource = driver.getPageSource();

        if (actualPageSource.contains(expectedHtmlIcerik)){
            System.out.println("HTML icerik testi PASSED");
        }else {
            System.out.println("Sayfa kaynak kodlari "+ expectedHtmlIcerik + " kelimesi icermiyor, Test FAILED");
        }

        Thread.sleep(13000);
        driver.close();
        //10. Sayfayi kapatin.
    }
}
